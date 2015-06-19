/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdfwriter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import demofx.ProductClass;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;

/**
 *
 * @author Novi
 */
public class PrintInventoryReport {
     public static final String filename = "c:\\BL\\business_inventory.pdf";
  ProductClass it;
    public void create(ObservableList list,String totalSales) {
    try {
        Document document = new Document(PageSize.LETTER);
        document.setMargins(1,1,1,1);
        
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
         Font font2 = new Font(Font.FontFamily.UNDEFINED, 10,Font.BOLD);
        PdfPTable table=new PdfPTable(5);
        table.setWidthPercentage(95);
        table.setWidths(new int[]{ 40, 40,40 , 40,40});
        PdfPCell cell;
        
        
    cell=new PdfPCell(new Phrase("",font2));
               cell.setBorder(0);
               cell.setColspan(8);
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setBorderWidthTop(0);
        
            cell.setBorderWidthBottom(0);
            table.addCell(cell);
            
            
        cell=new PdfPCell(new Phrase("KELNOVI SHOPPING BOTIQUE",new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD)));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);

        

        cell=new PdfPCell(new Phrase("Pondol,Loon, Bohol",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);

        cell=new PdfPCell(new Phrase("Phone/Fax#:000-000-000",new Font(Font.FontFamily.UNDEFINED,9,Font.UNDERLINE)));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);
        
        
        cell=new PdfPCell(new Phrase(" "));
        cell.setColspan(10);
        cell.setRowspan(3);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);

        cell=new PdfPCell(new Phrase("SALES REPORT",new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD)));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);

        cell=new PdfPCell(new Phrase(" "));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);
            
            
            
        cell=new PdfPCell(new Phrase("NO."));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(14);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell=new PdfPCell(new Phrase("PRODUCT NAME"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(14);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell=new PdfPCell(new Phrase("PRICE"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(14);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
    
        cell=new PdfPCell(new Phrase("QUANTITY"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(14);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell=new PdfPCell(new Phrase("AMOUNT PAYABLE"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(14);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
     for(int i=0;i<list.size();i++) {
            it = (ProductClass) list.get(i);
           
            cell=new PdfPCell(new Phrase(""+it.idProperty().get()));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(14);
            table.addCell(cell);
            
            cell=new PdfPCell(new Phrase(""+it.productDescriptionProperty().get()));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(14);
            table.addCell(cell);
            
            cell=new PdfPCell(new Phrase(""+it.productPriceProperty().get()));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(14);
            table.addCell(cell);
            
            cell=new PdfPCell(new Phrase(""+it.productQtyProperty().get()));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(14);
            table.addCell(cell);
            //totalSales.setText(String.format("%,.2f",globalSales));
            
            cell=new PdfPCell(new Phrase(String.format("%,.2f", Double.parseDouble(it.productTotalSalesProperty().get()))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(14);
            table.addCell(cell);
            
      
     }
     
        cell=new PdfPCell(new Phrase(" "));
        cell.setColspan(10);
           cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
           cell=new PdfPCell(new Phrase(" "));
        cell.setColspan(10);
           cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
        
        cell=new PdfPCell(new Phrase("TOTAL AMOUNT PAYABLE:"));
        cell.setColspan(10);
          cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
            
      cell=new PdfPCell(new Phrase("Php "+totalSales,new Font(Font.FontFamily.UNDEFINED,14,Font.UNDERLINE)));
        cell.setColspan(10);
           cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
        
        cell=new PdfPCell(new Phrase(" "));
        cell.setColspan(10);
           cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
            
        cell=new PdfPCell(new Phrase("Approved by:"));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
        
       
        
        cell=new PdfPCell(new Phrase("MICHAEL NOVI MALUENDA II",new Font(Font.FontFamily.UNDEFINED,14,Font.UNDERLINE)));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
        cell=new PdfPCell(new Phrase("General Manager"));
        cell.setColspan(10);
         cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
            
        cell=new PdfPCell(new Phrase(" "));
        cell.setColspan(10);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        table.addCell(cell);
        
        
        document.add(table);
        document.close();
        openFile();
        
     
    }catch(Exception e) {
        e.printStackTrace();
        }
    }

    private void openFile() {
        //To change body of generated methods, choose Tools | Templates.
      try{
              Runtime.getRuntime().exec("cmd /c start /max "+filename);
        }catch(Exception e){
          
        }
    }
}
