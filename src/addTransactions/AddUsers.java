package addTransactions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import entity.AllParameter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import txtWarehouse.TxtAdmins;
import txtWarehouse.TxtUsers;

public class AddUsers extends AllParameter{
	
	public void start(Stage stage) throws IOException  {
		String username;
		File Username =new File("username.txt");
		Scanner reader=new Scanner(Username);
		username=reader.nextLine();
		reader.close();
		// Top menu bilgi
		Label i2name=new Label(username);
		Button btninfouser=new Button();
		GridPane gridpane=new GridPane();
		
		GridPane.setConstraints(getNameL(),0,0);
		getNameinput().setPromptText("NAME");
		GridPane.setConstraints(getNameinput(),1,0);
		

		GridPane.setConstraints(getSurnameL(),0,1);
		getSurnameinput().setPromptText("SURNAME");
		GridPane.setConstraints(getSurnameinput(),1,1);
 
		GridPane.setConstraints(getMailL(),0,2);
		getMailinput().setPromptText("Mail");
		GridPane.setConstraints(getMailinput(),1,2);
		
		GridPane.setConstraints(getPasswordL(),2,0);
		getPasswordinput().setPromptText("Password");
		GridPane.setConstraints(getPasswordinput(),3,0);
		//GridPanes BÝTTÝ
		
		//GridPane ÖZELLÝK TANIMLAMA
				gridpane.setPadding(new Insets(10,10,10,10));
				gridpane.setVgap(8);
				gridpane.setHgap(10);
				gridpane.setAlignment(Pos.CENTER);
				
				//USER EKLEME BUTONU
				Button btnAuser=new Button("ADD USER");
				GridPane.setConstraints(btnAuser,0,7);
				btnAuser.setOnAction(e->{
					TxtUsers users=new TxtUsers();
					users.getNameinput().getText();
					users.getSurnameinput().getText();
					users.getMailinput().getText();
					users.getPasswordinput().getText();
					
					try {
						users.addUsers(users);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				//ADMÝN EKLEM BUTONU
				Button btnAddAdmin=new Button("ADD ADMÝN");
				GridPane.setConstraints(btnAddAdmin,1,7);
				btnAddAdmin.setOnAction(e->{
					TxtAdmins admins=new TxtAdmins();
					admins.getNameinput().getText();
					admins.getSurnameinput().getText();
					admins.getMailinput().getText();
					admins.getPasswordinput().getText();
					
					try {
						admins.addAdmins(admins);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				//CANCEL BUTONU
	    		Scene backScene=stage.getScene();
	    		Button btnCancel=new Button("CANCEL");
	    		GridPane.setConstraints(btnCancel,2,7);
	    		btnCancel.setOnAction(e->{
	    			stage.setScene(backScene);
	    			stage.setResizable(false);
	    			stage.show();			
	    		});
				
				gridpane.getChildren().addAll(getNameL(),getNameinput(),getSurnameL(),getSurnameinput(),getMailL(),getMailinput(),
						getPasswordL(),getPasswordinput(),btnAuser,btnAddAdmin,btnCancel);
				
				BorderPane borderPane=new BorderPane();
				borderPane.setCenter(gridpane);
				
				Scene scene=new Scene(borderPane,1200,800);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
	}
}