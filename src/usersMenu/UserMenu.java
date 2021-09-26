package usersMenu;

import java.io.File;
import java.util.Scanner;

import aboutMails.MailSendTransactions;
import aboutMails.MailTakingTransactions;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import transactions.SendMail;

public class UserMenu extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("USER SCREEN");
		
		String username;
		File Username =new File("username.txt"); 
		Scanner reader=new Scanner(Username);
		username=reader.nextLine();
		reader.close();
		
		GridPane gridPane=new GridPane();
		BorderPane border=new BorderPane();
		VBox vmenu=new VBox();
		Button btnExit=new Button("EXÝT");
		btnExit.getStyleClass().add("button-exit");
		 
		Label i2name=new Label(username);
		
		//BUTON ÝÞLEMLERÝ
		//MAÝL ÝÞLEMLERÝ  
	Button btnTMailOperations=new Button("Sent Mails");
	MailSendTransactions mailOp=new MailSendTransactions();
	btnTMailOperations.setOnAction(e->{
		try {
			mailOp.start(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	});
	
	//GÖNDERÝLEN MAÝL ÝÞLEMLERÝ 
	Button btnSMailOperations=new Button("Received Mails");
	MailTakingTransactions mailSOp=new 	MailTakingTransactions();
	btnSMailOperations.setOnAction(e->{
		try {
			mailSOp.start(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	});	
	
	//EXIT bUTTON
		btnExit.setOnAction(e->{ 	stage.close();	 });
		
	//MAÝL GÖNDERME 
	Button btnSMail=new Button("Send Mail");
	SendMail admins=new 	SendMail();
	btnSMail.setOnAction(e->{
		try {
			admins.start(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	});
	
	//GridPane ÖZELLÝKLER
			gridPane.setPadding(new Insets(10,10,10,10));
				gridPane.setVgap(8);
					gridPane.setHgap(10);
						gridPane.setAlignment(Pos.CENTER);
		
			GridPane.setConstraints(btnSMail,0,0);
				GridPane.setConstraints(btnTMailOperations,0,1);
					GridPane.setConstraints(btnSMailOperations,0,2);
						GridPane.setConstraints(btnExit,0,3);
	
		
		gridPane.getChildren().addAll(btnExit,btnSMailOperations,btnTMailOperations,btnSMail);
		
	 	border.setTop(i2name);
		border.setCenter(gridPane);
		
	Scene scene=new Scene(border,1200,800);
	scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	stage.setScene(scene);
	stage.show();
	}
}