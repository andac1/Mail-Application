package login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import adminsMenu.AdminsMenu;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import registerFast.RegisterFast;
import usersMenu.UserMenu;

public class Login extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		 
		
		Label luser=new Label("Mail adress:");
		Label login=new Label("Sign In:");
		login.getStyleClass().add("label-label1");
		
		//username
		TextField tFUsername=new TextField();
		//taking password from user
		Label lPassword=new Label("Password:");
		PasswordField tFPassword=new PasswordField();
		//Giving warning massage (in else if)
		Label status=new Label("");
		
		
		
		//ButtonActions start here
		//Admin Giriþi
		Button btnlogin=new Button("Login for user");
		btnlogin.setOnAction(e->{	
			if(tFUsername.getText().isEmpty() ) {
				status.setText("USERNAME field is Empty");
				status.getStyleClass().add("label-mesaj");
			}
			else if(tFUsername.getText().isEmpty() & tFPassword.getText().isEmpty()) {
				status.setText("USERNAME and PASSWORD field is Empty");
				status.getStyleClass().add("label-mesaj");
			}
			else if(tFPassword.getText().isEmpty()) {
				status.setText("PASSWORD field is Empty");
				status.getStyleClass().add("label-mesaj");
			}
			else {
										
		//Read File
		File file = new File("users.txt");
		File Username = new File("username.txt");
		Scanner reader;
		
		try {
			reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String name = reader.nextLine();
			String surname = reader.nextLine();
			String mail = reader.nextLine();
			String password = reader.nextLine();
			String date = reader.nextLine();
			
			// if KOÞULLARI
			  if (tFUsername.getText().equals(mail) & tFPassword.getText().equals(password)) {
				  try {
						BufferedWriter writer=new BufferedWriter(new FileWriter(Username));
						writer.write(mail);
						writer.close();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				UserMenu admin=new UserMenu();
				try {
					admin.start(stage);
		        } catch (Exception e11) {
		            e11.printStackTrace();
		        }
			}
			else if(tFUsername.getText()!=(mail)) {
				status.setText("Wrong Username or Password");
				status.getStyleClass().add("label-mesaj");
				}
			  //BÝTÝÞ
		}reader.close();
		} catch (FileNotFoundException e2) {
					e2.printStackTrace();
		}
	}
});
		
		
		
		//For login Button
		Button btnadmin=new Button("Login For Admin");
		btnadmin.setOnAction(e->{
					if(tFUsername.getText().isEmpty() ) {
						status.setText("USERNAME field is Empty");
						status.getStyleClass().add("label-mesaj");
					}
					else if(tFUsername.getText().isEmpty() & tFPassword.getText().isEmpty()) {
						status.setText("USERNAME and PASSWORD field is Empty");
						status.getStyleClass().add("label-mesaj");
					}
					else if(tFPassword.getText().isEmpty()) {
						status.setText("PASSWORD field is Empty");
						status.getStyleClass().add("label-mesaj");
					}
					else {
												
				//Read File
				File file = new File("Admin.txt");
				File Username = new File("username.txt");
				Scanner reader;
				
				try {
					reader = new Scanner(file);
				while (reader.hasNextLine()) {
					String name = reader.nextLine();
					String surname = reader.nextLine();
					String mail = reader.nextLine();
					String password = reader.nextLine();
					String date = reader.nextLine();
					
					// if Conditions
					//START
					  if (tFUsername.getText().equals(mail) & tFPassword.getText().equals(password)) {
						  try {
								BufferedWriter writer=new BufferedWriter(new FileWriter(Username));
								writer.write(mail);
								writer.close();
							} catch (IOException e2) {
								e2.printStackTrace();
							}
						AdminsMenu users=new AdminsMenu();
						try {
							users.start(stage);
				        } catch (Exception e11) {
				            e11.printStackTrace();
				        }
					}
					
					else if(tFUsername.getText()!=(mail.toUpperCase())) {
						status.setText("Wrong Username or Password");
						}
					  //OVER
				}reader.close();
				} catch (FileNotFoundException e2) {
							e2.printStackTrace();
				}
			}
		});
				//For Exit Button
				Button btnExit=new Button("EXÝT");
				btnExit.setOnAction(e4->	stage.close());
				btnExit.getStyleClass().add("button-exit");
				
				
				
				//FAST REGÝSTRATÝON
				Button btnFastRegister =new Button("QUICK REGISTER");
				btnFastRegister.setOnAction(e->{
					RegisterFast registerFast=new RegisterFast();
					try {
						registerFast.start(stage);
			        } catch (Exception e11) {
			            e11.printStackTrace();
			        }
				});
		
				GridPane gridPane=new GridPane();
				
				//GridPane Operations
				gridPane.setPadding(new Insets(10,10,10,10));
				gridPane.setVgap(8);
				gridPane.setHgap(10);
				gridPane.setAlignment(Pos.CENTER);
				
				GridPane.setConstraints(luser,0,0);
				GridPane.setConstraints(tFUsername,1,0);
				GridPane.setConstraints(lPassword,0,1);
				GridPane.setConstraints(tFPassword,1,1);
				GridPane.setConstraints(btnadmin,0,3);
				GridPane.setConstraints(btnlogin,1,3);
				GridPane.setConstraints(btnExit,3,3);
				GridPane.setConstraints(btnFastRegister,2,3);
				gridPane.getChildren().addAll(luser,tFUsername,lPassword,tFPassword,btnadmin,btnlogin,btnFastRegister,btnExit);
				
				VBox vBox=new VBox();
				vBox.getChildren().add(status);
				
				
				
				//Screen Operations
				StackPane stackPane=new StackPane();
				stackPane.getChildren().add(login);
				BorderPane root=new BorderPane(); 
				root.setCenter(gridPane);
				root.setTop(stackPane);
				root.setBottom(vBox);
				
				Scene scene=new Scene(root,1200,800);
				stage.setScene(scene);
				stage.show();
				root.setId("loginroot");
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	}

}
