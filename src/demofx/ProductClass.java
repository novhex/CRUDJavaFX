/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofx;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Novi
 */
public class ProductClass {
    public SimpleStringProperty id;
    public SimpleStringProperty productDescription;
    public SimpleStringProperty productPrice;
    public SimpleStringProperty productQty;
    public SimpleStringProperty productTotalSales;
    
    
    public  ProductClass(String id,String productDescription,String productPrice,String productQty,String productTotalSales) {
    this.id=new SimpleStringProperty(id);
    this.productDescription=new SimpleStringProperty(productDescription);
    this.productPrice=new SimpleStringProperty(productPrice);
    this.productQty=new SimpleStringProperty(productQty);
    this.productTotalSales=new SimpleStringProperty(productTotalSales);
    }
    
    public SimpleStringProperty idProperty() { return id;}
    public SimpleStringProperty productDescriptionProperty() { return productDescription; } 
    public SimpleStringProperty productPriceProperty() { return productPrice; } 
    public SimpleStringProperty productQtyProperty() { return productQty; } 
    public SimpleStringProperty productTotalSalesProperty() { return productTotalSales; }
}
