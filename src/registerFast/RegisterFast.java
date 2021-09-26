package registerFast;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import txtWarehouse.TxtUsers;

public class RegisterFast extends AllParameter{
	public void start(Stage stage) throws IOException  {
		String username;
		File Username =new File("username.txt");
		Scanner reader=new Scanner(Username);
		username=reader.nextLine();
		reader.close();
		// Top menu info labels
		Label i2name=new Label(username);
		Label information=new Label("                                                     Welcome.\n" + 
				"                                   Don't you have a T-Mail account?\n" 
						+ "                                                    Don't worry.\n"+
				"  From here you can quickly register and start sending mail to your loved ones.\n"+
						"                                                    So,let's start.\n"+
				"	(Don't forget to invite your loved ones to the T-Mail application)\n\n\n\n\n\n\n");
		information.getStyleClass().add("label-mesaj");
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
		
		GridPane.setConstraints(getPasswordL(),0,3);
		getPasswordinput().setPromptText("Password");
		GridPane.setConstraints(getPasswordinput(),1,3);
		//GridPane's OVER
		
		//GridPane iþlemleri
				gridpane.setPadding(new Insets(10,10,10,10));
				gridpane.setVgap(8);
				gridpane.setHgap(10);
				gridpane.setAlignment(Pos.CENTER);
				
				//CANCEL BUTONU
				Scene backScene=stage.getScene();
				Button btnCancel=new Button("CANCEL");
				GridPane.setConstraints(btnCancel,2,7);
				btnCancel.setOnAction(e->{
					stage.setScene(backScene);
					stage.setResizable(false);
					stage.show();			
				});
				
				//Add user Button
				Button btnAuser=new Button("REGÝSTER");
				GridPane.setConstraints(btnAuser,1,7);
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
				
		
				
				gridpane.getChildren().addAll(getNameL(),getNameinput(),getSurnameL(),getSurnameinput(),getMailL(),getMailinput(),
						getPasswordL(),getPasswordinput(),btnAuser,btnCancel);
				StackPane stackPane=new StackPane();
				stackPane.getChildren().add(information);
				VBox vbox=new VBox(gridpane);
				BorderPane borderPane=new BorderPane();
				borderPane.setTop(stackPane);
				borderPane.setCenter(vbox);
				Scene scene=new Scene(borderPane,1200,800);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
	
	}
}
