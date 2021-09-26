package transactions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.AllParameter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SendMail extends AllParameter{
	
	public void start(Stage stage) throws IOException  {
		GridPane gridPane=new GridPane();
		
		
		GridPane.setConstraints(getMailLabel(),0,0);
		gettFWho().setPromptText("To Who");
		GridPane.setConstraints(gettFWho(),0,1);
		
		GridPane.setConstraints(getTopicLabel(),0,2);
		gettFTopic().setPromptText("Topic");
		GridPane.setConstraints(gettFTopic(),0,3);
		
		GridPane.setConstraints(getBodyLabel(),0,4);
		gettAbody().setPromptText("Budy");
		GridPane.setConstraints(gettAbody(),0,5);
		
		Button btnSendMail=new Button("SEND MAÝL");
		GridPane.setConstraints(btnSendMail,1,6);
		btnSendMail.setOnAction(e->{
			sendMailTo();
			try {
				sendMailMe();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		//CANCEL BUTONU
				Scene backScene=stage.getScene();
				Button btnCancel=new Button("   CANCEL  ");
				GridPane.setConstraints(btnCancel,1,7);
				btnCancel.setOnAction(e->{
					stage.setScene(backScene);
					stage.setResizable(false);
					stage.show();			
				});
		
		
		gridPane.getChildren().addAll(getMailLabel(),gettFWho(),getTopicLabel(),gettFTopic(),getBodyLabel(),gettAbody(),btnSendMail,btnCancel);
		
		BorderPane borderPane=new BorderPane();
		borderPane.setCenter(gridPane);
		
		Scene scene=new Scene(borderPane,1200,800);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void sendMailTo() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
	    Date date1 = new Date();
	    
		String username = null;
		 File Username =new File("username.txt");
			Scanner reader;
			try {
				reader = new Scanner(Username);
				username=reader.nextLine();
				reader.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
			File file=new File(gettFWho().getText()+"-take"+".txt");
			BufferedWriter writer;
			writer=	new BufferedWriter(new FileWriter (file,true));
			 
			if(file.length()!=0) 
			writer.newLine();
			
			writer.write(username);
			writer.newLine();
			writer.write(gettFTopic().getText());
			writer.newLine();
			writer.write(gettAbody().getText());
			writer.newLine();
			writer.write(dateFormat.format(date1));
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
					}
	}
	public void sendMailMe() throws FileNotFoundException  {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
	    Date date1 = new Date();
		 String username = null;
		 File Username =new File("username.txt");
			Scanner reader;
			try {
				reader = new Scanner(Username);
				username=reader.nextLine();
				reader.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			 int flagA = 0; //kind of counter for missing equal values
			    File adminF =new File("Admin.txt");
				Scanner adminReader= new Scanner(adminF);
				while (adminReader.hasNextLine()) {
					String nameA = adminReader.nextLine();
					String surnameA = adminReader.nextLine();
					String mailA= adminReader.nextLine(); 
					String passwordA= adminReader.nextLine();
					String dateA= adminReader.nextLine();
					if(gettFWho().getText().equals(mailA)){
						flagA++;
						}
				}adminReader.close();
					
				
				
				int flagU = 0; //kind of counter for missing equal values
			    File User =new File("users.txt");
				Scanner userReader= new Scanner(User);
				while (userReader.hasNextLine()) {
					String nameU = userReader.nextLine();
					String surnameU = userReader.nextLine();
					String mailU= userReader.nextLine(); 
					String passwordU= userReader.nextLine();
					String dateU= userReader.nextLine();
					if(gettFWho().getText().equals(mailU)){
						flagU++;
					}
				}userReader.close();
				if(flagA==0 & flagU==0) {
					JOptionPane.showMessageDialog(null,"Please enter a registered email address.","E-Mail",JOptionPane.ERROR_MESSAGE,null);
				}
					if(flagA==1 || flagU==1) {
		try {
			File file=new File(username+"-send"+".txt");
			BufferedWriter writer;
			writer=	new BufferedWriter(new FileWriter (file,true));
			
			if(file.length()!=0) 
			writer.newLine();
			
			writer.write(gettFWho().getText());
			writer.newLine();
			writer.write(gettFTopic().getText());
			writer.newLine();
			writer.write(gettAbody().getText());
			writer.newLine();
			writer.write(dateFormat.format(date1));
			//Pop-up
			JOptionPane.showMessageDialog(null, "Mail Sent Successfully");	
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
	}
}