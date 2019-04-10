package interfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import api.Apiservice;
import entities.Bills;
import entities.Client;
import entities.Operator;
import entities.Purchse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import servicefacture.FactureRemote;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FusedBillsController implements Initializable {
	@FXML
	private ComboBox<String> state;
	@FXML
	private TableView<Bills> bills;
	@FXML
	private TableColumn<Bills,Integer> reference;
	@FXML
	private TableColumn<Bills,String> bill;
	@FXML
	private TableColumn<Bills,Date> date;
	@FXML
	private TableColumn<Bills,Float> amount;
	@FXML
	private TextField cin;
	@FXML
	private TextField amount1;
	@FXML
	private TextField amount2;
	@FXML
	private TextField amount3;
	@FXML
	private TextField amount4;
	@FXML
	private TextField amount5;
	@FXML
	private TextField total;
	@FXML
	private Button pay;
	@FXML
	private Button print;
	@FXML
	private ImageView search;
	@FXML
	private ComboBox<String> type;
	@FXML
	private ComboBox<String> billsnumber;
	@FXML
	private ImageView back;
	@FXML
	private Label idoperator;
	@FXML
	private Label reference1;
	@FXML
	private Label reference2;
	@FXML
	private Label reference3;
	@FXML
	private Label reference4;
	@FXML
	private Label reference5;
	@FXML
	private ImageView add1;
	@FXML
	private ImageView add2;
	@FXML
	private ImageView add3;
	@FXML
	private ImageView add4;
	@FXML
	private ImageView add5;
	@FXML
	private ImageView calculate;
	@FXML
	private ImageView ref;
	@FXML
	private ImageView logoop;

	ObservableList<String> ptype =FXCollections.observableArrayList("Cash","Card","Check");
	ObservableList<String> statelist =FXCollections.observableArrayList("Paid","Not Paid");
	ObservableList<String> visibility =FXCollections.observableArrayList("1","2","3","4","5");
	// Event Listener on Button[#pay].onAction
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		type.setItems(ptype);
		state.setItems(statelist);
		billsnumber.setItems(visibility);
	
	
	}
	
	@FXML
	public void payment(ActionEvent event) throws NamingException, IOException {
		// TODO Autogenerated
		//------------------context-----------------------
		Context context;
		
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
		FactureRemote s= (FactureRemote) context.lookup(j2);
		//----------------update bill---------------------
		if(total.getText().equals(""))
		{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Add bills to total first!");
			   alert.showAndWait();
		}
		else
		{
			String t= type.getValue();
			if(billsnumber.getValue().equals("1"))
			{
				s.updateBills(Integer.parseInt(reference1.getText()), t);
				 Alert alert = new Alert(AlertType.INFORMATION);
				   alert.setTitle("Information Dialog");
				   alert.setHeaderText(null);
				   alert.setContentText("bills paid!");
				   alert.showAndWait();
				   //-------------------redload-----------------------
				   int idop= Integer.parseInt(idoperator.getText());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("FuzedBills.fxml"));
					Parent root=loader.load();
					FusedBillsController display=loader.getController();
					//display.setclient(c.getId());
					
					//System.out.println(c.getIdoperator());

					FusedBillsController controller = 
					loader.<FusedBillsController>getController();
					controller.reloadsame(this,idop);
					System.out.println("id login: "+idop);
					 
					   pay.getScene().setRoot(root);
			}
			if(billsnumber.getValue().equals("2"))
			{
				s.updateBills(Integer.parseInt(reference1.getText()), t);
				s.updateBills(Integer.parseInt(reference2.getText()), t);
				 Alert alert = new Alert(AlertType.INFORMATION);
				   alert.setTitle("Information Dialog");
				   alert.setHeaderText(null);
				   alert.setContentText("bills paid!");
				   alert.showAndWait();
				   //-------------------redload-----------------------
				   int idop= Integer.parseInt(idoperator.getText());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("FuzedBills.fxml"));
					Parent root=loader.load();
					FusedBillsController display=loader.getController();
					//display.setclient(c.getId());
					
					//System.out.println(c.getIdoperator());

					FusedBillsController controller = 
					loader.<FusedBillsController>getController();
					controller.reloadsame(this,idop);
					System.out.println("id login: "+idop);
					 
					   pay.getScene().setRoot(root);
			}
			if(billsnumber.getValue().equals("3"))
			{
				s.updateBills(Integer.parseInt(reference1.getText()), t);
				s.updateBills(Integer.parseInt(reference2.getText()), t);
				s.updateBills(Integer.parseInt(reference3.getText()), t);
				 Alert alert = new Alert(AlertType.INFORMATION);
				   alert.setTitle("Information Dialog");
				   alert.setHeaderText(null);
				   alert.setContentText("bills paid!");
				   alert.showAndWait();
				   //-------------------redload-----------------------
				   int idop= Integer.parseInt(idoperator.getText());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("FuzedBills.fxml"));
					Parent root=loader.load();
					FusedBillsController display=loader.getController();
					//display.setclient(c.getId());
					
					//System.out.println(c.getIdoperator());

					FusedBillsController controller = 
					loader.<FusedBillsController>getController();
					controller.reloadsame(this,idop);
					System.out.println("id login: "+idop);
					 
					   pay.getScene().setRoot(root);
				
			}
			if(billsnumber.getValue().equals("4"))
			{
				s.updateBills(Integer.parseInt(reference1.getText()), t);
				s.updateBills(Integer.parseInt(reference2.getText()), t);
				s.updateBills(Integer.parseInt(reference3.getText()), t);
				s.updateBills(Integer.parseInt(reference4.getText()), t);
				 Alert alert = new Alert(AlertType.INFORMATION);
				   alert.setTitle("Information Dialog");
				   alert.setHeaderText(null);
				   alert.setContentText("bills paid!");
				   alert.showAndWait();
				   //-------------------redload-----------------------
				   int idop= Integer.parseInt(idoperator.getText());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("FuzedBills.fxml"));
					Parent root=loader.load();
					FusedBillsController display=loader.getController();
					//display.setclient(c.getId());
					
					//System.out.println(c.getIdoperator());

					FusedBillsController controller = 
					loader.<FusedBillsController>getController();
					controller.reloadsame(this,idop);
					System.out.println("id login: "+idop);
					 
					   pay.getScene().setRoot(root);
			}
			if(billsnumber.getValue().equals("5"))
			{
				s.updateBills(Integer.parseInt(reference1.getText()), t);
				s.updateBills(Integer.parseInt(reference2.getText()), t);
				s.updateBills(Integer.parseInt(reference3.getText()), t);
				s.updateBills(Integer.parseInt(reference4.getText()), t);
				s.updateBills(Integer.parseInt(reference5.getText()), t);
				 Alert alert = new Alert(AlertType.INFORMATION);
				   alert.setTitle("Information Dialog");
				   alert.setHeaderText(null);
				   alert.setContentText("bills paid!");
				   alert.showAndWait();
				   //-------------------redload-----------------------
				   int idop= Integer.parseInt(idoperator.getText());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("FuzedBills.fxml"));
					Parent root=loader.load();
					FusedBillsController display=loader.getController();
					//display.setclient(c.getId());
					
					//System.out.println(c.getIdoperator());

					FusedBillsController controller = 
					loader.<FusedBillsController>getController();
					controller.reloadsame(this,idop);
					System.out.println("id login: "+idop);
					 
					   pay.getScene().setRoot(root);
			}
			
		}
	}
	// Event Listener on Button[#print].onAction
	@FXML
	public void printbill(ActionEvent event) throws NamingException, NumberFormatException, MalformedURLException, IOException {
		// TODO Autogenerated

		//------------------context-----------------------
				Context context;
				
				context = new InitialContext();
				String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
				FactureRemote s= (FactureRemote) context.lookup(j2);
				//---------------print--------------------
		if(bills.getSelectionModel().getSelectedItem().getEtat()==false)
		{
			 Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Bill is not paid yet!");
			   alert.showAndWait();
		}
		else
		{
			int reference =bills.getSelectionModel().getSelectedItem().getReference();
			String billname =bills.getSelectionModel().getSelectedItem().getName();
			Float montant =bills.getSelectionModel().getSelectedItem().getAmount();
			String paytype =bills.getSelectionModel().getSelectedItem().getPaymenttype();
			Date payday =bills.getSelectionModel().getSelectedItem().getPaymentdate();
			Operator o=bills.getSelectionModel().getSelectedItem().getOperator();
			Client c=bills.getSelectionModel().getSelectedItem().getClient();
			String clientn=c.getName();
			String cinn=cin.getText();
			 Apiservice d=new Apiservice();
			 if (o.getName().equals("ooredoo"))
			 {	 String url="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQt9dEGqzj-90s3tMYwO-WLXzgFdTSYYwO63FDR2qX05b5bCccyDA";
			 d.pdfbill(clientn, billname, reference, montant, Integer.parseInt(cinn), payday, paytype, url);
			 Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Bill was downloaded!");
			   alert.showAndWait();
			 }
			 else if(o.getName().equals("orange"))
					 {	 String url="https://www.google.com/imgres?imgurl=https%3A%2F%2Fmediatheque.orange.com%2Fvar%2Forange_site%2Fstorage%2Fimages%2Forange.com%2Fmediatheque%2Fchangement-de-nom%2Flogo-orange_1234%2F395019-1-fre-FR%2FLogo-Orange_1234_mediatheque-lightbox.jpg&imgrefurl=https%3A%2F%2Fwww.orange.com%2Fen%2Fhome&docid=zA2MEuxNnB0xTM&tbnid=VgQd9kCv0pbYyM%3A&vet=10ahUKEwiJpoL6xMPhAhXDBGMBHepUDzYQMwhlKAAwAA..i&w=700&h=700&client=opera&bih=665&biw=1326&q=orange&ved=0ahUKEwiJpoL6xMPhAhXDBGMBHepUDzYQMwhlKAAwAA&iact=mrc&uact=8";
					 d.pdfbill(clientn, billname, reference, montant, Integer.parseInt(cinn), payday, paytype, url);
					 Alert alert = new Alert(AlertType.INFORMATION);
					   alert.setTitle("Information Dialog");
					   alert.setHeaderText(null);
					   alert.setContentText("Bill was downloaded!");
					   alert.showAndWait();
					 }
		}
	}
	// Event Listener on ImageView[#search].onMouseClicked
	@FXML
	public void search(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		//---------------context--------------------
		Context context;
		
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
		FactureRemote s= (FactureRemote) context.lookup(j2);
		//-----------------------------------------------
		
		
		//--------------------search paid bills--------------------
		int id=Integer.parseInt(idoperator.getText());  
		if(cin.getText().equals(""))
		   {
			   Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("You have to fill cin information!");
			   alert.showAndWait();
			   cin.setStyle("-fx-control-inner-background:FFB9CE;");
		   }
		   if(cin.getText().length()!=8)
		   {
			   Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Cin have to be 8 lenght!");
			   alert.showAndWait();
			  cin.setStyle("-fx-control-inner-background:FFB9CE;");
		   }
		   if(s.findClientbyCin(Integer.parseInt(cin.getText()), s.findOperatorbyid(id))==null)
		   {
			   Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Cin not found!");
			   alert.showAndWait();
			  cin.setStyle("-fx-control-inner-background:FFB9CE;");
		   }
		    
			 if(state.getValue().equals("Paid"))
		   
		{
				 int clcin=Integer.parseInt(cin.getText());
					
					Client c= new Client();
					c=s.findClientbyCin(clcin, s.findOperatorbyid(id));
			List<Bills> bil= new ArrayList();
			bil=s.paidlist(c);
			
			ObservableList<Bills> OL = FXCollections.observableArrayList(bil);
			
			bills.setItems(OL);
			reference.setCellValueFactory(new PropertyValueFactory<>("reference"));
			bill.setCellValueFactory(new PropertyValueFactory<>("name"));
			date.setCellValueFactory(new PropertyValueFactory<>("date"));
			amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		}
		if(state.getValue().equals("Not Paid"))
		{
			int clcin=Integer.parseInt(cin.getText());
			
			Client c= new Client();
			c=s.findClientbyCin(clcin, s.findOperatorbyid(id));
			List<Bills> bil= new ArrayList();
			bil=s.notpaidlist(c);
			
			ObservableList<Bills> OL = FXCollections.observableArrayList(bil);
			
			bills.setItems(OL);
			reference.setCellValueFactory(new PropertyValueFactory<>("reference"));
			bill.setCellValueFactory(new PropertyValueFactory<>("name"));
			date.setCellValueFactory(new PropertyValueFactory<>("date"));
			amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		}
		   
		
	}
	@FXML
    public void selectamount(MouseEvent event) {
		
		/*Float data =bills.getSelectionModel().getSelectedItem().getAmount();
		int ref=bills.getSelectionModel().getSelectedItem().getReference();
		if(amount1.getText().equals("")) 
		{
			amount1.setText(String.valueOf(data));
			reference1.setText(String.valueOf(ref));
			
		}
	
	
		if(amount1.getText().length()!=0 && amount2.getText().equals(""))
		{
			reference2.setText(String.valueOf(ref));
			
			amount2.setText(String.valueOf(data));
		}
		if(amount2.getText().length()!=0)
		{
			reference3.setText(String.valueOf(ref));
			
			amount3.setText(String.valueOf(data));
		}
		
		float a1= Float.parseFloat(amount1.getText());
		float a2= Float.parseFloat(amount1.getText());
		//float a3= Float.parseFloat(amount1.getText());
		//float a4= Float.parseFloat(amount1.getText());
		//float a5= Float.parseFloat(amount1.getText());
		
		
		Float t=a1+a2;
		total.setText(String.valueOf(t));*/
		
	}
	@FXML
	public void addamount1(MouseEvent event) {
		
		Float data =bills.getSelectionModel().getSelectedItem().getAmount();
		int ref=bills.getSelectionModel().getSelectedItem().getReference();
		boolean t =bills.getSelectionModel().getSelectedItem().getEtat();
		if (reference1.getText().equals(String.valueOf(ref))||reference2.getText().equals(String.valueOf(ref))
				||reference3.getText().equals(String.valueOf(ref))||reference4.getText().equals(String.valueOf(ref))
				||reference5.getText().equals(String.valueOf(ref)))
				{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("You already added this bill!");
			   alert.showAndWait();
				}
		if(t==true)
		{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("this bill already been paid");
			   alert.showAndWait();
		}
		else{
		amount1.setText(String.valueOf(data));
		reference1.setText(String.valueOf(ref));
		}
	}
	@FXML
	public void addamount2(MouseEvent event) {
		
		Float data =bills.getSelectionModel().getSelectedItem().getAmount();
		int ref=bills.getSelectionModel().getSelectedItem().getReference();
		boolean t =bills.getSelectionModel().getSelectedItem().getEtat();
		if (reference1.getText().equals(String.valueOf(ref))||reference2.getText().equals(String.valueOf(ref))
				||reference3.getText().equals(String.valueOf(ref))||reference4.getText().equals(String.valueOf(ref))
				||reference5.getText().equals(String.valueOf(ref)))
				{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("You already added this bill!");
			   alert.showAndWait();
				}
		else{
		amount2.setText(String.valueOf(data));
		reference2.setText(String.valueOf(ref));
		}
	}
	@FXML
	public void addamount3(MouseEvent event) {
		
		Float data =bills.getSelectionModel().getSelectedItem().getAmount();
		int ref=bills.getSelectionModel().getSelectedItem().getReference();
		boolean t =bills.getSelectionModel().getSelectedItem().getEtat();
		if (reference1.getText().equals(String.valueOf(ref))||reference2.getText().equals(String.valueOf(ref))
				||reference3.getText().equals(String.valueOf(ref))||reference4.getText().equals(String.valueOf(ref))
				||reference5.getText().equals(String.valueOf(ref)))
				{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("You already added this bill!");
			   alert.showAndWait();
				}
		else{
		amount3.setText(String.valueOf(data));
		reference3.setText(String.valueOf(ref));
		}
	}
	@FXML
	public void addamount4(MouseEvent event) {
		Float data =bills.getSelectionModel().getSelectedItem().getAmount();
		int ref=bills.getSelectionModel().getSelectedItem().getReference();
		boolean t =bills.getSelectionModel().getSelectedItem().getEtat();
		if (reference1.getText().equals(String.valueOf(ref))||reference2.getText().equals(String.valueOf(ref))
				||reference3.getText().equals(String.valueOf(ref))||reference4.getText().equals(String.valueOf(ref))
				||reference5.getText().equals(String.valueOf(ref)))
				{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("You already added this bill!");
			   alert.showAndWait();
				}
		else{
		amount4.setText(String.valueOf(data));
		reference4.setText(String.valueOf(ref));
		}
	}
	@FXML
	public void addamount5(MouseEvent event) {
		
		Float data =bills.getSelectionModel().getSelectedItem().getAmount();
		int ref=bills.getSelectionModel().getSelectedItem().getReference();
		boolean t =bills.getSelectionModel().getSelectedItem().getEtat();
		if (reference1.getText().equals(String.valueOf(ref))||reference2.getText().equals(String.valueOf(ref))
				||reference3.getText().equals(String.valueOf(ref))||reference4.getText().equals(String.valueOf(ref))
				||reference5.getText().equals(String.valueOf(ref)))
				{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("You already added this bill!");
			   alert.showAndWait();
				}
		else{
		amount5.setText(String.valueOf(data));
		reference5.setText(String.valueOf(ref));
		}
	}
	@FXML
	public void numberchange(ActionEvent event){
		if(billsnumber.getValue().equals("1"))
		{
			amount1.setVisible(true);
			add1.setVisible(true);
			amount2.setVisible(false);
			add2.setVisible(false);
			amount3.setVisible(false);
			add3.setVisible(false);
			amount4.setVisible(false);
			add4.setVisible(false);
			amount5.setVisible(false);
			add5.setVisible(false);
			
			total.setVisible(true);
			type.setVisible(true);
			calculate.setVisible(true);
			ref.setVisible(true);
			
		}
		if(billsnumber.getValue().equals("2"))
		{
			amount1.setVisible(true);
			add1.setVisible(true);
			amount2.setVisible(true);
			add2.setVisible(true);
			amount3.setVisible(false);
			add3.setVisible(false);
			amount4.setVisible(false);
			add4.setVisible(false);
			amount5.setVisible(false);
			add5.setVisible(false);
			total.setVisible(true);
			type.setVisible(true);
			calculate.setVisible(true);
			ref.setVisible(true);
			
		}
		if(billsnumber.getValue().equals("3"))
		{
			amount1.setVisible(true);
			add1.setVisible(true);
			amount2.setVisible(true);
			add2.setVisible(true);
			amount3.setVisible(true);
			add3.setVisible(true);
			amount4.setVisible(false);
			add4.setVisible(false);
			amount5.setVisible(false);
			add5.setVisible(false);
			total.setVisible(true);
			type.setVisible(true);
			calculate.setVisible(true);
			ref.setVisible(true);
			
		}
		if(billsnumber.getValue().equals("4"))
		{
			amount1.setVisible(true);
			add1.setVisible(true);
			amount2.setVisible(true);
			add2.setVisible(true);
			amount3.setVisible(true);
			add3.setVisible(true);
			amount4.setVisible(true);
			add4.setVisible(true);
			amount5.setVisible(false);
			add5.setVisible(false);
			total.setVisible(true);
			type.setVisible(true);
			ref.setVisible(true);
		}
		if(billsnumber.getValue().equals("5"))
		{
			amount1.setVisible(true);
			add1.setVisible(true);
			amount2.setVisible(true);
			add2.setVisible(true);
			amount3.setVisible(true);
			add3.setVisible(true);
			amount4.setVisible(true);
			add4.setVisible(true);
			amount5.setVisible(true);
			add5.setVisible(true);
			total.setVisible(true);
			type.setVisible(true);
			calculate.setVisible(true);
			ref.setVisible(true);
			
		}
		
	}
	@FXML
	public void calculer(MouseEvent event)
	{
		float a1;
		float a2;
		float a3;
		float a4;
		float a5;
		float t;
	
		 
		if(billsnumber.getValue().equals("1")&&amount1.getText().length()!=0 )
			{	a1= Float.parseFloat(amount1.getText());
				t=a1;		
				total.setText(String.valueOf(t));
			}
		else if(billsnumber.getValue().equals("2")&&amount1.getText().length()!=0&&amount2.getText().length()!=0)
			{
			a1= Float.parseFloat(amount1.getText());
			 a2= Float.parseFloat(amount2.getText());
			t=a1+a2;
			total.setText(String.valueOf(t));
			
			}
		else if(billsnumber.getValue().equals("3")&&amount1.getText().length()!=0&&amount2.getText().length()!=0
				&&amount3.getText().length()!=0)
			{a1= Float.parseFloat(amount1.getText());
			 a2= Float.parseFloat(amount2.getText());
			 a3= Float.parseFloat(amount3.getText());
			t=a1+a2+a3;
			total.setText(String.valueOf(t));
			
			}
		else if(billsnumber.getValue().equals("4")&&amount1.getText().length()!=0&&amount2.getText().length()!=0
				&&amount3.getText().length()!=0&&amount4.getText().length()!=0)
			{a1= Float.parseFloat(amount1.getText());
		 a2= Float.parseFloat(amount2.getText());
		 a3= Float.parseFloat(amount3.getText());
		 a4= Float.parseFloat(amount4.getText());
			t=a1+a2+a3+a4;
			total.setText(String.valueOf(t));
			
			}
		else if(billsnumber.getValue().equals("5")&&amount1.getText().length()!=0&&amount2.getText().length()!=0
				&&amount3.getText().length()!=0&&amount4.getText().length()!=0
				&&amount5.getText().length()!=0)
			{	a1= Float.parseFloat(amount1.getText());
			 a2= Float.parseFloat(amount2.getText());
			 a3= Float.parseFloat(amount3.getText());
			 a4= Float.parseFloat(amount4.getText());
			 a5= Float.parseFloat(amount5.getText());
			t=a1+a2+a3+a4+a5;
			total.setText(String.valueOf(t));
			
			}
		else{
			  Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("You need to add it all!");
			   alert.showAndWait();
			
		}

		
		
	
		
	}
	@FXML
	public void refresh(MouseEvent event)
	{
		amount1.clear();
		amount2.clear();
		amount3.clear();
		amount5.clear();
		amount4.clear();
		reference1.setText("");
		reference2.setText("");
		reference3.setText("");
		reference4.setText("");
		reference5.setText("");
		
		total.clear();
	}
	@FXML
	public void backk(MouseEvent event) throws IOException, NamingException
	{
		int idop= Integer.parseInt(idoperator.getText());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Bills.fxml"));
		Parent root=loader.load();
		BillsController display=loader.getController();
		//display.setclient(c.getId());
		
		//System.out.println(c.getIdoperator());

		 BillsController controller = 
		loader.<BillsController>getController();
		controller.backfused(this,idop);
		System.out.println("id login: "+idop);
		 
		   back.getScene().setRoot(root);
	}
	
	public void logo(BillsController t, int id) throws FileNotFoundException, NamingException {
		
		//------------------context-----------------------
				Context context;
				
				context = new InitialContext();
				String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
				FactureRemote dao= (FactureRemote) context.lookup(j2);
				//---------------login--------------------
			
			dao.findOperatorbyid(id);
			idoperator.setText(String.valueOf(dao.findOperatorbyid(id).getIdoperator()));

			FileInputStream input = new FileInputStream(dao.findOperatorbyid(id).getImage());
			Image img = new Image(input);
			logoop.setImage(img);
	

	}
	public void reloadsame(FusedBillsController t, int id) throws FileNotFoundException, NamingException {
		
		//------------------context-----------------------
				Context context;
				
				context = new InitialContext();
				String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
				FactureRemote dao= (FactureRemote) context.lookup(j2);
				//---------------login--------------------
			
			dao.findOperatorbyid(id);
			idoperator.setText(String.valueOf(dao.findOperatorbyid(id).getIdoperator()));

			FileInputStream input = new FileInputStream(dao.findOperatorbyid(id).getImage());
			Image img = new Image(input);
			logoop.setImage(img);
	

	}
    private void saveTextToFile(String content, File file) throws FileNotFoundException {
        
        PrintWriter writer;
        writer = new PrintWriter(file);
        writer.println(content);
        writer.close();
    }
}


