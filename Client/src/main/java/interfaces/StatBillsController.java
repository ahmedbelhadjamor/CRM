package interfaces;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Bills;
import entities.Client;
import entities.Purchse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;

import javafx.scene.chart.BarChart;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import servicefacture.FactureRemote;

public class StatBillsController implements Initializable {
	@FXML
	private BarChart chart;
	@FXML
	private CategoryAxis x;
	@FXML
	private NumberAxis y;
	@FXML
	private ComboBox<String> change;
	
	ObservableList<String> T =FXCollections.observableArrayList("Bills","Bills by client","Sales per Client","sales per Item");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		change.setItems(T);
		//------------------context-----------------------
	
		
	}
	 @FXML
		public void changing(ActionEvent event) throws NamingException
		{
		//------------------context-----------------------
			Context context;
			
			context = new InitialContext();
			String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
			FactureRemote s= (FactureRemote) context.lookup(j2);
			//---------------login--------------------
			XYChart.Series series1 = new XYChart.Series();
			 series1.setName("Purchase"); 
			 float fa=0;
				float fa1=0;
		 if(change.getValue().equals("Bills"))
		 {
			 for(Bills l : s.listebills()){
	               //libsNoms.add(Integer.toString(l.getNum_vol())+l.getCompagnie
				  
				   Client c= new Client();
				   if (l.getEtat()==false)
				   {
					    fa=fa+l.getAmount();
				   
				
				   }
				   if(l.getEtat()==true)
				   {
					   fa1=fa1+l.getAmount();
				   }
			   		}
			      
		       series1.getData().add(new XYChart.Data("Paid Bills", fa1));
		        series1.getData().add(new XYChart.Data("Unpaid Bills", fa));
		        
		 }
		 if(change.getValue().equals("Bills by client"))
		 {
				for(Bills l : s.listebills()){
		               // libsNoms.add(Integer.toString(l.getNum_vol())+l.getCompagnie
					fa=fa+l.getAmount();
					series1.getData().add(new XYChart.Data(String.valueOf(l.getClient().getCin()), fa));
				   		}
				
		 }
		 if(change.getValue().equals("Sales per Client"))
		 {
			   for(Purchse l : s.listpurchase()){
	               // libsNoms.add(Integer.toString(l.getNum_vol())+l.getCompagnie
				  
				fa1=fa1+l.getAmountbeforetaxe();
				fa=fa+l.getTotal();
				series1.getData().add(new XYChart.Data(String.valueOf(l.getClient().getCin()), fa));
			   		}
				
		 }
		 if(change.getValue().equals("sales per Item"))
		 {

			   for(Purchse l : s.listpurchase()){
	               // libsNoms.add(Integer.toString(l.getNum_vol())+l.getCompagnie
				  
				fa1=fa1+l.getAmountbeforetaxe();
				fa=fa+l.getTotal();
				series1.getData().add(new XYChart.Data(l.getItem(), fa));
			   		}
				
			
		 }
		 chart.getData().addAll(series1);
		}

}
