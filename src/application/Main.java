package application;
	
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import login.Login;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	public void creatFile() {
		File users=new File("users.txt");
		File admin=new File("Admin.txt");
		try {
			if(users.createNewFile()&admin.createNewFile()) {
				System.out.println("File Created now");
				// Default admin user
				}else {
				System.out.println("File Already Has Created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage stage) {
		//Kullanýcý Mailleri için Txt oluþturuldu
		creatFile();
		
		//OTOMATÝK BÝR ADMÝN KULLANICI OLUÞTURMAK ÝÇÝN
		
		/******************************************
		/* 
		UserSave userSave=new UserSave();
		userSave.defaultAdmin();
		/********************************************
		*/
		
		
		Label welcome=new Label("WELCOME");
		welcome.getStyleClass().add("label-label1");
		
		
		
		Button btnLogin=new Button("LOGIN");
		Login login=new Login();
		btnLogin.setOnAction(e->{
			try {
				login.start(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
		});
		//EXÝT BUTTON
		Button btnExit=new Button(" EXIT ");
		btnExit.setOnAction(e->{ 	stage.close();	 });
		
		
		
		GridPane root=new GridPane();
		
		//GridPane ÖZELLÝKLER
		root.setPadding(new Insets(10,10,10,10));
		root.setVgap(8);
		root.setHgap(10);
		root.setAlignment(Pos.CENTER);
		
		
		
		//EKRAN OLAYLARI
		StackPane stackPane=new StackPane();
		stackPane.getChildren().add(welcome);
		
		GridPane.setConstraints(btnLogin,1,1);
		GridPane.setConstraints(btnExit,1,2);
		root.getChildren().addAll(btnLogin,btnExit);
		BorderPane borderPane=new BorderPane(); 
		borderPane.setTop(stackPane);
		borderPane.setCenter(root);
		Scene scene=new Scene(borderPane,1200,800);
		
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
