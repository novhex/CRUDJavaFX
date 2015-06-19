/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofx;

import com.dbconnection.DBInfo;
import com.pdfwriter.PrintInventoryReport;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Novi
 */
public class MainFXMLController implements Initializable {
Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;

@FXML
private AnchorPane basePane;

@FXML 
private TableView<ProductClass>tableProducts;

@FXML 
private TableColumn tblCol_ID;

@FXML 
private TableColumn tblCol_DESC;


@FXML 
private TableColumn tblCol_PRICE;

@FXML
private TableColumn tblCol_SALES;
        
@FXML 
private TableColumn tblCol_QTY;

@FXML
private TextField product_Desc;

@FXML
private TextField product_Price;

@FXML
private TextField product_Qty;

@FXML
private Button btnNew;

@FXML
private Button  btnAdd;

@FXML 
private Button btnDel;

@FXML
private Button btnEdit;

@FXML
private Button btnCancel;

@FXML
private Button btnPrint;

@FXML 
private Button btnSaveEdited;

@FXML
private TextField totalSales;

@FXML
ObservableList<ProductClass> plist = FXCollections.observableArrayList();

@FXML
private TextField txtResID;

@FXML
private String generatedResID="";

@FXML
ArrayList<Double>totalProductSales =new ArrayList<Double>();

@FXML
 private String rowClicked;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBInfo.ConnectDb();
        getAllRecords();
        initTableColumns();
       
    }    
    /*
    *   method for displaying data in every column -> [id][product desc] [product price] [product qty]
        PropertyValue for each comes from ProductClass like id,productDescription,productPrice and productQty
     */
    public void initTableColumns(){
     tblCol_ID.setCellValueFactory(new PropertyValueFactory("id"));
     tblCol_DESC.setCellValueFactory(new PropertyValueFactory("productDescription"));
     tblCol_PRICE.setCellValueFactory(new PropertyValueFactory("productPrice"));
     tblCol_QTY.setCellValueFactory(new PropertyValueFactory("productQty"));
     tblCol_SALES.setCellValueFactory(new PropertyValueFactory("productTotalSales"));
    }
    
    public void getAllRecords() {

        tableProducts.getItems().clear();
       try {
            pst=conn.prepareStatement("SELECT * FROM products");
            rs=pst.executeQuery();
            
        while(rs.next()) {
                plist.add(new ProductClass(rs.getString("prod_code"),rs.getString("prod_desc"),rs.getString("prod_price"),rs.getString("prod_qty"),expectedSales(rs.getString("prod_price"),rs.getString("prod_qty"))));
                tableProducts.setItems(plist);
                 totalProductSales();
                }
              totalProductSales();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private String expectedSales(String x , String y) {
        double totalSalesPerProduct=0.0;
        totalSalesPerProduct=(Double.parseDouble(x)*Double.parseDouble(y));
        totalProductSales();
        //return totalSalesPerProduct+""
     return String.format("%.2f",totalSalesPerProduct);
    }
    
    private void totalProductSales(){
        double globalSales=0.0;
      for(int x=0; x<tableProducts.getItems().size(); x++) {
            System.out.println(tableProducts.getItems().get(x).productTotalSales.get());  
            globalSales+=(Double.parseDouble(tableProducts.getItems().get(x).productTotalSales.get()));
      }
      if(tableProducts.getItems().size()<=0){
            totalSales.setText("");
            btnDel.setDisable(true);
            btnEdit.setDisable(true);
      }else
      {
         totalSales.setText(String.format("%,.2f",globalSales));
      }

    }
    
   
    
  
   
    public void tableClickEvent() {
     
        try {
            
            rowClicked = tableProducts.getSelectionModel().getSelectedItems().get(0).idProperty().get();
            txtResID.setText(rowClicked);
                
            product_Price.setText(tableProducts.getSelectionModel().getSelectedItems().get(0).productPriceProperty().get());
            product_Desc.setText(tableProducts.getSelectionModel().getSelectedItems().get(0).productDescriptionProperty().get());
            product_Qty.setText(tableProducts.getSelectionModel().getSelectedItems().get(0).productQtyProperty().get());
           btnNew.setDisable(true);   
           btnCancel.setDisable(false);
            btnDel.setDisable(false);
            btnEdit.setDisable(false);
            btnAdd.setDisable(true);
        }catch(Exception e){
            System.out.println("Table is empty!");
            btnDel.setDisable(true);
            btnEdit.setDisable(true);
        }
    }
    
    public void reDisableDelBtn() {
      btnDel.setDisable(true);
      btnEdit.setDisable(true);
      txtResID.setText("");
    }
    public void clearTextFields() {
            product_Price.setText("");
            product_Desc.setText("");
            product_Qty.setText("");
    }
    
    /*
    *   BUTTON ACTIONS
     */
    
    public void newRecord(ActionEvent e) {
            btnAdd.setDisable(false);
            btnNew.setDisable(true);
            btnSaveEdited.setDisable(true);
            btnCancel.setDisable(false);
            reDisableDelBtn();
            clearTextFields();
    }
    public void cancelNewRecord() {
            btnNew.setDisable(false);
            btnAdd.setDisable(true);
            btnSaveEdited.setDisable(true);
            btnEdit.setDisable(true);
            btnCancel.setDisable(true);
            btnEdit.setDisable(true);
            btnDel.setDisable(true);
                  clearTextFields();
    }
      public void enableSaveEditedButton(ActionEvent e) {
            btnSaveEdited.setDisable(false);
            btnDel.setDisable(true);
            btnEdit.setDisable(true);
    }
      
     public void addRecord(ActionEvent e) {
         if(isFieldEmpty()==true) {
        try {
           pst.execute("INSERT INTO `products` (`prod_code`, `prod_desc`, `prod_price`, `prod_qty`) VALUES (NULL, '"+product_Desc.getText()+"', '"+product_Price.getText()+"', '"+product_Qty.getText()+"');");
           getAllRecords();
           clearTextFields();
           btnAdd.setDisable(true);
           btnNew.setDisable(false);
        }catch(Exception E) {E.printStackTrace();}
         }else {
         
         }
   }
    public void deleteRecord(ActionEvent e) {
        if(Integer.parseInt(rowClicked)>0) {
            
            try {
            pst.execute("DELETE FROM `products` WHERE `products`.`prod_code` = "+rowClicked);
              getAllRecords();
                 clearTextFields();
                 btnNew.setDisable(false);
                 btnCancel.setDisable(true);
            }catch(Exception E) { E.printStackTrace();}
            
        }else {
        
        }
    }
  
    public void saveEditedRecord(ActionEvent e){
         if(Integer.parseInt(rowClicked)>0) {
            
            try {
            pst.execute("UPDATE `products` SET `prod_desc` = '"+product_Desc.getText()+"', `prod_price` = '"+product_Price.getText()+"', `prod_qty` = '"+product_Qty.getText()+"' WHERE `products`.`prod_code` = '"+rowClicked+"';");
            btnCancel.setDisable(true);
            btnNew.setDisable(false);
            btnSaveEdited.setDisable(true);
            getAllRecords();
              clearTextFields();
              reDisableDelBtn();
            }catch(Exception E) { E.printStackTrace();}
            
        }else {
        
        }
    }
    
    /*
    * Some Validations Here!
    */
    
    public boolean isFieldEmpty() {
  if(product_Price.getText().length()<=0 ||  product_Desc.getText().length()<=0 || product_Qty.getText().length()<=0){
          return false;
      }
      return true;
    }
    /*
    *   print business records
     */
    
    public void printAllRecords()
       {
            ObservableList<ProductClass> list = FXCollections.observableArrayList();
        for(int i=0;i<tableProducts.getItems().size();i++) {
            list.addAll((ProductClass)tableProducts.getItems().get(i));
        }
       
      new PrintInventoryReport().create(list, totalSales.getText());
         
  
       }
}
