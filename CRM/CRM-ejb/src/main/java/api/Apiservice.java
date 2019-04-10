package api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;





public class Apiservice {
	
	  
	  public void pdfbill(String name, String billname, int reference, Float amount, int cin,Date paymentdate, String paymenttype,String url) throws MalformedURLException, IOException
	   {
	      Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(billname+"_"+String.valueOf(reference)+".pdf"));
	         document.open();
	         document.add(new Paragraph("Bill payment:"+String.valueOf(reference)));
	         //---------------------image add---------------------------
	        
	        
	        
	        
	      
	        // String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
	         //Image image2 = Image.getInstance(new URL(imageUrl));
	         String imageUrl = url;
	         Image image2 = Image.getInstance(new URL(imageUrl));
	         //Fixed Positioning
	         //image2.setAbsolutePosition(100f, 550f);
	         //Scale to new height and new width of image
	         image2.scaleAbsolute(70, 70);
	         //Add to document
	         document.add(image2);
	         
	         //-----------------table add--------------------------------
	         PdfPTable table = new PdfPTable(7); // 3 columns.
	         table.setWidthPercentage(100); //Width 100%
	         table.setSpacingBefore(10f); //Space before table
	         table.setSpacingAfter(10f); //Space after table
	  
	         //Set Column widths
	         float[] columnWidths = {1f, 1f, 1f,1f, 1f, 1f,1f};
	         table.setWidths(columnWidths);
	  
	         PdfPCell cell1 = new PdfPCell(new Paragraph("Reference"));
	         cell1.setBorderColor(BaseColor.BLUE);
	         cell1.setPaddingLeft(10);
	         cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	       
	  
	         PdfPCell cell2 = new PdfPCell(new Paragraph("cin"));
	         cell2.setBorderColor(BaseColor.GREEN);
	         cell2.setPaddingLeft(10);
	         cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell3 = new PdfPCell(new Paragraph("Client name"));
	         cell3.setBorderColor(BaseColor.RED);
	         cell3.setPaddingLeft(10);
	         cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell cell4 = new PdfPCell(new Paragraph("bill"));
	         cell4.setBorderColor(BaseColor.BLUE);
	         cell4.setPaddingLeft(10);
	         cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell5 = new PdfPCell(new Paragraph("amount"));
	         cell5.setBorderColor(BaseColor.GREEN);
	         cell5.setPaddingLeft(10);
	         cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell6 = new PdfPCell(new Paragraph("payment type"));
	         cell6.setBorderColor(BaseColor.RED);
	         cell6.setPaddingLeft(10);
	         cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell cell7 = new PdfPCell(new Paragraph("Payment date"));
	         cell7.setBorderColor(BaseColor.RED);
	         cell7.setPaddingLeft(10);
	         cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         //To avoid having the cell border and the content overlap, if you are having thick cell borders
	         //cell1.setUserBorderPadding(true);
	         //cell2.setUserBorderPadding(true);
	         //cell3.setUserBorderPadding(true);
	  
	         table.addCell(cell1);
	         table.addCell(cell2);
	         table.addCell(cell3);
	         table.addCell(cell4);
	         table.addCell(cell5);
	         table.addCell(cell6);
	         table.addCell(cell7);
	         
	         document.add(table);
	         //---------------------------------------------
	         PdfPTable table1 = new PdfPTable(7); // 3 columns.
	         table1.setWidthPercentage(100); //Width 100%
	         table1.setSpacingBefore(10f); //Space before table
	         table1.setSpacingAfter(10f); //Space after table
	  
	         //Set Column widths
	         float[] columnWidths1 = {1f, 1f, 1f,1f, 1f, 1f,1f};
	         table.setWidths(columnWidths1);
	  
	         PdfPCell celll1 = new PdfPCell(new Paragraph(String.valueOf(reference)));
	         celll1.setBorderColor(BaseColor.BLUE);
	         celll1.setPaddingLeft(10);
	         celll1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	       
	  
	         PdfPCell celll2 = new PdfPCell(new Paragraph(String.valueOf(cin)));
	         celll2.setBorderColor(BaseColor.GREEN);
	         celll2.setPaddingLeft(10);
	         celll2.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell celll3 = new PdfPCell(new Paragraph(name));
	         celll3.setBorderColor(BaseColor.RED);
	         celll3.setPaddingLeft(10);
	         celll3.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell celll4 = new PdfPCell(new Paragraph(billname));
	         celll4.setBorderColor(BaseColor.BLUE);
	         celll4.setPaddingLeft(10);
	         celll4.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell celll5 = new PdfPCell(new Paragraph(String.valueOf(amount)));
	         celll5.setBorderColor(BaseColor.GREEN);
	         celll5.setPaddingLeft(10);
	         celll5.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell celll6 = new PdfPCell(new Paragraph(paymenttype));
	         celll6.setBorderColor(BaseColor.RED);
	         celll6.setPaddingLeft(10);
	         celll6.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell celll7 = new PdfPCell(new Paragraph(String.valueOf(paymentdate)));
	         celll7.setBorderColor(BaseColor.RED);
	         celll7.setPaddingLeft(10);
	         celll7.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll7.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         //To avoid having the cell border and the content overlap, if you are having thick cell borders
	         //cell1.setUserBorderPadding(true);
	         //cell2.setUserBorderPadding(true);
	         //cell3.setUserBorderPadding(true);
	  
	         table1.addCell(celll1);
	         table1.addCell(celll2);
	         table1.addCell(celll3);
	         table1.addCell(celll4);
	         table1.addCell(celll5);
	         table1.addCell(celll6);
	         table1.addCell(celll7);
	         
	         document.add(table1);
	  
	         //-----------------doc close and write----------------
	         document.add(new Paragraph("Signature"));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	   
}
	  public void pdfsale(String billname, int quantity, String clientn, int cinn,Float amountbeforetaxe, Float total,String url) throws MalformedURLException, IOException
	   {
	      Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(billname+String.valueOf(quantity)+".pdf"));
	         document.open();
	         document.add(new Paragraph("sales: "+ billname));
	         //---------------------image add---------------------------
	        
	        
	        
	        
	      
	        // String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
	         //Image image2 = Image.getInstance(new URL(imageUrl));
	         String imageUrl = url;
	         Image image2 = Image.getInstance(new URL(imageUrl));
	         //Fixed Positioning
	         //image2.setAbsolutePosition(100f, 550f);
	         //Scale to new height and new width of image
	         image2.scaleAbsolute(70, 70);
	         //Add to document
	         document.add(image2);
	         
	         //-----------------table add--------------------------------
	         PdfPTable table = new PdfPTable(6); // 3 columns.
	         table.setWidthPercentage(100); //Width 100%
	         table.setSpacingBefore(10f); //Space before table
	         table.setSpacingAfter(10f); //Space after table
	  
	         //Set Column widths
	         float[] columnWidths = {1f, 1f, 1f,1f, 1f, 1f};
	         table.setWidths(columnWidths);
	  
	         PdfPCell cell1 = new PdfPCell(new Paragraph("Item"));
	         cell1.setBorderColor(BaseColor.BLUE);
	         cell1.setPaddingLeft(10);
	         cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	       
	  
	         PdfPCell cell2 = new PdfPCell(new Paragraph("Quantity"));
	         cell2.setBorderColor(BaseColor.GREEN);
	         cell2.setPaddingLeft(10);
	         cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell3 = new PdfPCell(new Paragraph("Client name"));
	         cell3.setBorderColor(BaseColor.RED);
	         cell3.setPaddingLeft(10);
	         cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell cell4 = new PdfPCell(new Paragraph("cinn"));
	         cell4.setBorderColor(BaseColor.BLUE);
	         cell4.setPaddingLeft(10);
	         cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell5 = new PdfPCell(new Paragraph("amountbeforetaxe"));
	         cell5.setBorderColor(BaseColor.GREEN);
	         cell5.setPaddingLeft(10);
	         cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell cell6 = new PdfPCell(new Paragraph("total"));
	         cell6.setBorderColor(BaseColor.RED);
	         cell6.setPaddingLeft(10);
	         cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         
	  
	         //To avoid having the cell border and the content overlap, if you are having thick cell borders
	         //cell1.setUserBorderPadding(true);
	         //cell2.setUserBorderPadding(true);
	         //cell3.setUserBorderPadding(true);
	  
	         table.addCell(cell1);
	         table.addCell(cell2);
	         table.addCell(cell3);
	         table.addCell(cell4);
	         table.addCell(cell5);
	         table.addCell(cell6);
	        
	         
	         document.add(table);
	         //---------------------------------------------
	         PdfPTable table1 = new PdfPTable(6); // 3 columns.
	         table1.setWidthPercentage(100); //Width 100%
	         table1.setSpacingBefore(10f); //Space before table
	         table1.setSpacingAfter(10f); //Space after table
	  
	         //Set Column widths
	         float[] columnWidths1 = {1f, 1f, 1f,1f, 1f, 1f};
	         table.setWidths(columnWidths1);
	  
	         PdfPCell celll1 = new PdfPCell(new Paragraph(billname));
	         celll1.setBorderColor(BaseColor.BLUE);
	         celll1.setPaddingLeft(10);
	         celll1.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	       
	  
	         PdfPCell celll2 = new PdfPCell(new Paragraph(String.valueOf(quantity)));
	         celll2.setBorderColor(BaseColor.GREEN);
	         celll2.setPaddingLeft(10);
	         celll2.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell celll3 = new PdfPCell(new Paragraph(clientn));
	         celll3.setBorderColor(BaseColor.RED);
	         celll3.setPaddingLeft(10);
	         celll3.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	         PdfPCell celll4 = new PdfPCell(new Paragraph(String.valueOf(cinn)));
	         celll4.setBorderColor(BaseColor.BLUE);
	         celll4.setPaddingLeft(10);
	         celll4.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell celll5 = new PdfPCell(new Paragraph(String.valueOf(amountbeforetaxe)));
	         celll5.setBorderColor(BaseColor.GREEN);
	         celll5.setPaddingLeft(10);
	         celll5.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	  
	         PdfPCell celll6 = new PdfPCell(new Paragraph(String.valueOf(total)));
	         celll6.setBorderColor(BaseColor.RED);
	         celll6.setPaddingLeft(10);
	         celll6.setHorizontalAlignment(Element.ALIGN_CENTER);
	         celll6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         
	  
	  
	         //To avoid having the cell border and the content overlap, if you are having thick cell borders
	         //cell1.setUserBorderPadding(true);
	         //cell2.setUserBorderPadding(true);
	         //cell3.setUserBorderPadding(true);
	  
	         table1.addCell(celll1);
	         table1.addCell(celll2);
	         table1.addCell(celll3);
	         table1.addCell(celll4);
	         table1.addCell(celll5);
	         table1.addCell(celll6);
	  
	         
	         document.add(table1);
	  
	         //-----------------doc close and write----------------
	         document.add(new Paragraph("Signature"));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	   
}
	  //------------------------------send mail--------------------------------------------
	  private static final String senderEmail = "meehthis69@gmail.com";//change with your sender email
	  private static final String senderPassword = "1994gamess";//change with your sender password
	  private Session session;
	  public void sendAsHtml(String to, String title, String html) throws MessagingException {
	      System.out.println("Sending email to " + to);
	    
	      Session session = createSession();

	      //create message using session
	      MimeMessage message = new MimeMessage(session);
	      prepareEmailMessage(message, to, title, html);

	      //sending message
	      Transport.send(message);
	      System.out.println("Done");
	  }

	  private void prepareEmailMessage(MimeMessage message, String to, String title, String html)
	          throws MessagingException {
	      message.setContent(html, "text/html; charset=utf-8");
	      message.setFrom(new InternetAddress(senderEmail));
	      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	      message.setSubject(title);
	  }

	  private Session createSession() {
		  Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	    
	      
	      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication("meehthis69@gmail.com", "1994gamess");
	          }
	      });
	      return session;
	  }
}
