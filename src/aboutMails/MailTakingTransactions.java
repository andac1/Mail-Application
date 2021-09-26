package aboutMails;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

import entity.AllParameter;
import entity.MailEntity;
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
import javafx.stage.Stage;

public class MailTakingTransactions {
	 public ObservableList<MailEntity> getSearch(TextField search, TableView<MailEntity> table) throws IOException {
	        ObservableList<MailEntity> list = FXCollections.observableArrayList();
	    	if(search.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "SEARCH field is Empty","SEARCH",JOptionPane.ERROR_MESSAGE,null);
			}
	        File fileInfo = new File("Admin.txt");
	        Scanner reader = new Scanner(fileInfo);
	        while (reader.hasNextLine()) {
	        	String toWho=reader.nextLine();
	            String topic=reader.nextLine();
	            String mail=reader.nextLine();
	            String date=reader.nextLine();
	            if (toWho.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) || topic.toUpperCase().trim().contains(search.getText().trim().toUpperCase()) 
	            		|| mail.toUpperCase().trim().contains(search.getText().trim().toUpperCase())) {
	                list.add(new MailEntity(toWho,topic,mail,date));
	            }
	        }
	        if (search.getText().trim().length() == 0) {
	            table.setItems( getValues());
	        }
	        reader.close();
	        return list;
	 }
//tabloya verileri çekmek için getValues methodu
	 public ObservableList<MailEntity> getValues() throws FileNotFoundException{
		 String username;
		 File Username =new File("username.txt");
			Scanner readers;
			
				readers = new Scanner(Username);
				username=readers.nextLine();
				readers.close();
			
		 File file=new File(username+"-take"+".txt");
		 ObservableList<MailEntity> list=FXCollections.observableArrayList();
	        try {
	            Scanner reader=new Scanner(file);
	            while(reader.hasNextLine()){
	            	String toWho=reader.nextLine();
		            String topic=reader.nextLine();
		            String mail=reader.nextLine();
		            String date=reader.nextLine();
		            list.add(new MailEntity(toWho,topic,mail,date));      
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace(); 
	        }
	        return list; 
	 }
	 
	 
	 public void start(Stage stage) throws IOException {
		 stage.setTitle("MAÝL SCREEN");
		 
		 String username;
		 File Username =new File("username.txt");
			Scanner reader=new Scanner(Username);
			username=reader.nextLine();
			reader.close();
		TableView<MailEntity> table = new TableView<MailEntity>();
					 
		 	StackPane root=new StackPane();
			BorderPane border=new BorderPane();
			Button btnExit=new Button("EXIT");
			btnExit.getStyleClass().add("button-exit");
			
			// Top menu bilgi
			Label mail=new Label(username);
			HBox hboxtop=new HBox();
			
			HBox topmenu=new HBox();	
			topmenu.setAlignment(Pos.TOP_LEFT);
		 
		 AllParameter allParameter=new AllParameter();//allParameter Çaðýrýldý ve özellikleri tanýmlandý 
		 
			//TableColumn
		 	table.setEditable(true);
		 	TableColumn<MailEntity,String> column1 = new TableColumn<>("To Who");
			column1.setCellValueFactory(new PropertyValueFactory<>("toWho"));
			column1.setMinWidth(80); 
			TableColumn<MailEntity,String> column2 = new TableColumn<>("Topic");
			column2.setCellValueFactory(new PropertyValueFactory<>("topic"));
			column2.setMinWidth(80); 
			TableColumn<MailEntity,String> column3 = new TableColumn<>("MAÝL");
			column3.setCellValueFactory(new PropertyValueFactory<>("mail"));
			column3.setMinWidth(80); 
			TableColumn<MailEntity,String> column4 = new TableColumn<>("Date");
			column4.setCellValueFactory(new PropertyValueFactory<>("date"));
			column4.setMinWidth(80); 
			//OVER
			//Columnlar tabloya eklendi
			table.getColumns().addAll(column1,column2,column3,column4);
			table.setItems(getValues());//VERÝLER TABLOYA ALINDI
			
			
	        //Button olaylarý Baþlangýç
	       		//MAÝL arama ALANI
	       		TextField tfSeacrh=new TextField ();
	       		tfSeacrh.setPromptText("NAME | SURNAME | ID");
	       		
	       		//aranan MAÝLLER tabloya geldikten sonra geri çaðýrma alaný
	       		Button btnBACK=new Button("BACK VALUE");
	       		btnBACK.setOnAction(E->{
	       			try {
						table.setItems(getValues());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
	       		});
	       	//MAÝL  arama BUTONU
	       		Button btnSearch=new Button("Search");
	       		btnSearch.setOnAction(e->{
	       		try {
					ObservableList<MailEntity> list=getSearch(tfSeacrh,table);
					table.setItems(list);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	       		
	       		});
	       		
	    		//EXIT
	    			btnExit.setOnAction(e->{
	    				 stage.close();	 
	    			});
	       		
	       	 	//CANCEL BUTONU
	    		Scene backScene=stage.getScene();
	    		Button btnCancel=new Button("CANCEL");
	    		btnCancel.setOnAction(e->{
	    			stage.setScene(backScene);
	    			stage.setResizable(false);
	    			stage.show();			
	    		});
	       		
				//DELETE BUTONU
	       	 Button btnDelete=new Button("DELETE");
	       		btnDelete.setOnAction(e->{
					if(table.getSelectionModel().isEmpty()==false) {
						//tablodan seçilen deðeri al
						ObservableList<MailEntity> observableList;
						observableList=table.getSelectionModel().getSelectedItems();
						MailEntity admin=observableList.get(0);
						//Bir mail oluþturuldu ve bu maile tablodan seçilen deðerler verildi
						allParameter.gettFWho().setText(admin.getToWho());
						allParameter.gettFTopic().setText(admin.getTopic());
					}
				
			DeleteTakeMail delete=new DeleteTakeMail();
	       			try {
						 delete.deleteMail(table,allParameter.gettFWho());
						 table.getItems().removeAll();
						table.setItems(getValues());
	       			} catch (IOException e1) {
						e1.printStackTrace();
					}
	       		});
	       		
				
	       		table.setEditable(false);
	       		//BUTTON OVER
			
			
			HBox hboxTop=new HBox();
			hboxTop.getChildren().addAll(tfSeacrh,btnSearch,btnBACK);
			HBox hbox=new HBox();
			hbox.getChildren().addAll(btnDelete,btnCancel,btnExit);
			StackPane root2=new StackPane();
			BorderPane border2=new BorderPane();
			root.getChildren().addAll(border);
			
			
			
			
			root2.getChildren().addAll(topmenu,border2);
			border.setCenter(root2);
			topmenu.getChildren().addAll(hboxtop);
			hboxtop.getChildren().addAll(mail);
			
			border2.setBottom(hbox);
			border2.setCenter(table);
			border2.setTop(hboxTop);
			 Scene scene = new Scene(root, 1200, 800);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			 stage.setScene(scene); // scene ekrana koyuldu
			 stage.show(); // ekran açýldý
	 }
}
