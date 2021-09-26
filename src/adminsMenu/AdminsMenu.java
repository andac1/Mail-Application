package adminsMenu;

import java.io.File;
import java.util.Scanner;

import aboutMails.MailSendTransactions;
import aboutMails.MailTakingTransactions;
import addTransactions.AddUsers;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import transactions.AdminTransactions;
import transactions.UserTransactions;
import transactions.SendMail;

public class AdminsMenu extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ADMÝN SCREEN");
		
		String username;
		File Username =new File("username.txt"); 
		Scanner reader=new Scanner(Username);
		username=reader.nextLine();
		reader.close();
		
		Button btnUserOperations=new Button("     USERS     ");
		Button btnTMailOperations=new Button("  Sent Mail  ");
		Button btnSMailOperations=new Button("Received Mail");
		Button btnadmins=new Button("   Send Mail   ");
		Button btnAdminOperations=new Button("    ADMÝNS    ");
		Button btnExit=new Button("     EXÝT     ");
		btnExit.getStyleClass().add("button-exit");
		
		 
		Label i2name=new Label(username);
		Button btninfouser=new Button();
		HBox hboxtop=new HBox();
		//buton olaylarý baþlangýç
		//KULLANICI EKLEME BUTONU
		Button btnAddUser=new Button("      ADD       ");
		btnAddUser.setOnAction(e->{
		AddUsers add = new AddUsers();
		try {
			add.start(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	});
	//KAYITLI KULLANICI ÝÞLEMLERÝ
		UserTransactions usersOp=new 	UserTransactions();
		btnUserOperations.setOnAction(e->{
			try {
				usersOp.start(stage);
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
		});
		
		//GÖNDERÝLEN MAÝL ÝÞLEMLERÝ
				MailSendTransactions mailOp=new 	MailSendTransactions();
				btnTMailOperations.setOnAction(e->{
					try {
						mailOp.start(stage);
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
				});
				
				//ALINAN MAÝL ÝÞLEMLERÝ
				MailTakingTransactions mailSOp=new 	MailTakingTransactions();
				btnSMailOperations.setOnAction(e->{
					try {
						mailSOp.start(stage);
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
				});	
				
		
		//MAÝL GÖNDERME
		SendMail admins=new 	SendMail();
		btnadmins.setOnAction(e->{
			try {
				admins.start(stage);
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
		});
	
	//KAYITLI ADMÝNLERÝN ÝÞLEMLERÝ
			AdminTransactions adminOp=new 	AdminTransactions();
			btnAdminOperations.setOnAction(e->{
				try {
					adminOp.start(stage);
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
			});
	//EXIT BUTTON
	btnExit.setOnAction(e->{ 	stage.close();	 });
	
	
	
	GridPane gridPane=new GridPane();
	
	//GridPane ÖZELLÝKLER
	gridPane.setPadding(new Insets(10,10,10,10));
	gridPane.setVgap(8);
	gridPane.setHgap(10);
	gridPane.setAlignment(Pos.CENTER);
	
	GridPane.setConstraints(btnAddUser,0,0);
	GridPane.setConstraints(btnadmins,0,1);
	GridPane.setConstraints(btnAdminOperations,0,2);
	GridPane.setConstraints(btnUserOperations,0,3);
	GridPane.setConstraints(btnSMailOperations,0,4);
	GridPane.setConstraints(btnTMailOperations,0,5);
	GridPane.setConstraints(btnExit,0,6);
	gridPane.getChildren().addAll(btnAddUser,btnadmins,btnAdminOperations,btnUserOperations,btnExit,btnTMailOperations,btnSMailOperations);
		
	 	BorderPane border=new BorderPane();
		border.setTop(i2name);
		border.setCenter(gridPane);
		
	Scene scene=new Scene(border,1200,800);

	scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	stage.setScene(scene);
	stage.show();
	}
}