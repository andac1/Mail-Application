package transactions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.AllParameter;
import entity.UsersEntity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import updateDelete.DeleteUser;
import updateDelete.UpdateUser;

public class UserTransactions extends Application{

		 public ObservableList<UsersEntity> getSearch(TextField search, TableView<UsersEntity> table) throws IOException {
		        ObservableList<UsersEntity> list = FXCollections.observableArrayList();
		    	if(search.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "SEARCH field is Empty","SEARCH",JOptionPane.ERROR_MESSAGE,null);
				}
		        File fileInfo = new File("users.txt");
		        Scanner reader = new Scanner(fileInfo);
		        while (reader.hasNextLine()) {
		        	String name=reader.nextLine();
		            String surname=reader.nextLine();
		            String mail=reader.nextLine();
		            String password=reader.nextLine();
		            String date=reader.nextLine();
		            if (name.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) || surname.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) || mail.toUpperCase().trim().contains(search.getText().trim().toUpperCase())) {
		                list.add(new UsersEntity(name, surname, mail,password,date));
		            }
		        }
		        if (search.getText().trim().length() == 0) {
		            table.setItems( getValues());
		        }
		        reader.close();
		        return list;
		 }
	//tabloya verileri çekmek için getValues methodu
		 public ObservableList<UsersEntity> getValues()  {
			 File file=new File("users.txt");
			 ObservableList<UsersEntity> list=FXCollections.observableArrayList();
		        try {
		            Scanner reader=new Scanner(file);
		            while(reader.hasNextLine()){
			            String firstName=reader.nextLine();
			            String lastName=reader.nextLine();
			            String mail=reader.nextLine();
			            String password=reader.nextLine();
			            String date=reader.nextLine();;
			            list.add(new UsersEntity(firstName,lastName,mail,password,date));      
		            }
		            reader.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace(); 
		        }
		        return list; 
		 }
		 
		 @Override // Override the start method in the Application class
		 public void start(Stage stage) throws IOException {
			 stage.setTitle("USER");
			 
			 String username;
			 File Username =new File("username.txt");
				Scanner reader=new Scanner(Username);
				username=reader.nextLine();
				reader.close();
			TableView<UsersEntity> table = new TableView<UsersEntity>();
						 
			 	StackPane root=new StackPane();
				BorderPane border=new BorderPane();
				Button btnExit=new Button("EXIT");
				btnExit.getStyleClass().add("button-exit");
				
				// Top menu info labels
				Label i2name=new Label(username);
				HBox hboxtop=new HBox();
				
				HBox topmenu=new HBox();	
				topmenu.setAlignment(Pos.TOP_LEFT);
			 
			 AllParameter allParameter=new AllParameter();//allParameter Çaðýrýldý
			 
			 //START
				table.setEditable(true);
			 TableColumn<UsersEntity,String> column1 = new TableColumn<>("First Name");
				column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
				column1.setMinWidth(80); 
				TableColumn<UsersEntity,String> column2 = new TableColumn<>("Last Name");
				column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
				column2.setMinWidth(80); 
				TableColumn<UsersEntity,String> column3 = new TableColumn<>("MAÝL");
				column3.setCellValueFactory(new PropertyValueFactory<>("mail"));
				column3.setMinWidth(80); 
				TableColumn<UsersEntity,String> column4 = new TableColumn<>("PASSWORD");
				column4.setCellValueFactory(new PropertyValueFactory<>("password"));
				column4.setMinWidth(80); 
				TableColumn<UsersEntity,String> column5 = new TableColumn<>("Date");
				column5.setCellValueFactory(new PropertyValueFactory<>("date"));
				column5.setMinWidth(80); 
				//OVER
				//COLUMNLAR TABLOYA EKLENDÝ
				table.getColumns().addAll(column1,column2,column3,column4,column5);
				table.setItems(getValues());//VERÝLER TABLOYA ALINDI
				
		//BUTON ÝÞLEMLERÝ 
				//tablodan seçilen deðerleri textfieldlara yerleþtiren btninfo butonu
		       		Button btnInfo=new Button("GET INFO");
		       		btnInfo.setOnAction(e->{
						if(table.getSelectionModel().isEmpty()==false) {
						ObservableList<UsersEntity> observableList;
						observableList=table.getSelectionModel().getSelectedItems();
						UsersEntity users=observableList.get(0);
						allParameter.getNameinput().setText(users.getFirstName());
						allParameter.getSurnameinput().setText(users.getLastName());
						allParameter.getMailinput().setText(users.getMail());
						allParameter.getPasswordinput().setText(users.getPassword());
						}
						else {
							JOptionPane.showMessageDialog(null, "please select a USER","GET INFO",JOptionPane.INFORMATION_MESSAGE,null);
						}
					});
		       		
		       	//EXIT
					btnExit.setOnAction(e->{
						 stage.close();	 
					});
				
		       	//UPDATE BUTTON	
		       	 Button btnUpdate=new Button("UPDATE");
		       		btnUpdate.setOnAction(e->{
		       			UserInquiry userInquiry=new UserInquiry();
		       			userInquiry.inquiry();
						UpdateUser update=new UpdateUser();
						try {
							update.updateUser(table,allParameter.getNameinput(),allParameter.getSurnameinput()
									,allParameter.getMailinput(),allParameter.getPasswordinput());
							 table.getItems().removeAll();
								table.setItems(getValues());
		       			} catch (IOException e1) {
							e1.printStackTrace(); 
						} 
					});
		       		
		       	//CANCEL BUTONU
		    		Scene backScene=stage.getScene();
		    		Button btnCancel=new Button("CANCEL");
		    		btnCancel.setOnAction(e->{
		    			stage.setScene(backScene);
		    			stage.setResizable(false);
		    			stage.show();			
		    		});
		       		
		       		//Customer arama ALANI
		       		TextField tfSeacrh=new TextField ();
		       		tfSeacrh.setPromptText("NAME | SURNAME | MAIL");
		       		//aranan Customerlar tabloya geldikten sonra tüm Customerlarý geri çaðýrma alaný
		       		Button btnBvalue=new Button("BACK VALUE");
		       		btnBvalue.setOnAction(E->{
		       			table.setItems(getValues());	
		       		});
		       	//Customer arama BUTONU
		       		Button btnSearch=new Button("Search");
		       		btnSearch.setOnAction(e->{
		       		try {
						ObservableList<UsersEntity> list=getSearch(tfSeacrh,table);
						table.setItems(list);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		       		
		       		});
		       		
		       		
					//DELETE BUTONU
		       	 Button btnDelete=new Button("DELETE");
					btnDelete.setOnAction(e->{
						if(table.getSelectionModel().isEmpty()==false) {
							ObservableList<UsersEntity> observableList;
							observableList=table.getSelectionModel().getSelectedItems();
							UsersEntity customer=observableList.get(0);
							allParameter.getNameinput().setText(customer.getFirstName());
							allParameter.getSurnameinput().setText(customer.getLastName());
							allParameter.getMailinput().setText(customer.getMail());
							allParameter.getPasswordinput().setText(customer.getPassword());
							
						}
					
					DeleteUser delete=new DeleteUser();
		       			try {
							 delete.deleteUser(table,allParameter.getMailinput());
							 table.getItems().removeAll();
							table.setItems(getValues());
		       			} catch (IOException e1) {
							e1.printStackTrace();
						}
		       		});
		       		
					
		       		table.setEditable(false);
		       		//BUTTON OVER
				
				VBox vboxL=new VBox();
				vboxL.getChildren().addAll( 
						allParameter.getNameL(),
						allParameter.getNameinput(),
						allParameter.getSurnameL(),
						allParameter.getSurnameinput(),
						allParameter.getMailL(),
						allParameter.getMailinput(),
						allParameter.getPasswordL(),
						allParameter.getPasswordinput()
			 );
				HBox hboxTop=new HBox();
				hboxTop.getChildren().addAll(tfSeacrh,btnSearch,btnBvalue);
				HBox hbox=new HBox();
				hbox.getChildren().addAll(btnInfo,btnUpdate,btnDelete,btnCancel,btnExit);
				StackPane root2=new StackPane();
				BorderPane border2=new BorderPane();
				
				root.getChildren().addAll(border);
				
				border2.setBottom(hbox);
				border2.setCenter(table);
				border2.setLeft(vboxL);
				border2.setTop(hboxTop);
				
				border.setCenter(root2);//Center Content
				root2.getChildren().addAll(topmenu,border2);
				topmenu.getChildren().addAll(hboxtop);
				hboxtop.getChildren().addAll(i2name);
				
				
				 Scene scene = new Scene(root, 1200, 800);
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				 stage.setScene(scene);
				 stage.show();
		 }
}