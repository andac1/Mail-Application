package updateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import entity.AdminsEntity;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UpdateAdmin {
	 private static int counter;
		public void updateAdmin(TableView<AdminsEntity> table,TextField newName,TextField newSurname,
	    										TextField newMail,TextField newPassword) throws IOException{    	

			ObservableList<AdminsEntity> observableList;
			observableList=table.getSelectionModel().getSelectedItems();
			AdminsEntity admin=observableList.get(0);
			if(table.getSelectionModel().getSelectedItems().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No ADMÝN to UPDATE was selected","ADMÝN",JOptionPane.ERROR_MESSAGE,null);
			}
			// else if(rDeleteCAdd(javafxEntity.getTfRoom().getText())) {
			   // }
			else if(newName.getText().isEmpty()==true) {
				JOptionPane.showMessageDialog(null, "Please write to new NAME","NAME",JOptionPane.ERROR_MESSAGE,null);
			}
			else if(newPassword.getText().isEmpty()==true) {
				JOptionPane.showMessageDialog(null, "Please write to new Password","PASSWORD",JOptionPane.ERROR_MESSAGE,null);
			}
			else if(newSurname.getText().isEmpty()==true) {
				JOptionPane.showMessageDialog(null, "Please write to new SURNAME","SURNAME",JOptionPane.ERROR_MESSAGE,null);
			}
			else if(newMail.getText().isEmpty()==true) {
				JOptionPane.showMessageDialog(null, "Please write to new Mail","MAÝL",JOptionPane.ERROR_MESSAGE,null);
			}
		
			else {
				JOptionPane.showMessageDialog(null, "UPDATE sucessfull","UPDATE",JOptionPane.INFORMATION_MESSAGE,null);
	        ArrayList<String> list=new ArrayList<>();
	        File file=new File("Admin.txt");
	        Scanner reader=new Scanner(file);
	        while(reader.hasNextLine()){
	            int flag =0;//kind of counter for missing equal values	
	            String name = reader.nextLine(); 
				String surname = reader.nextLine();
				String mail= reader.nextLine();
				String password= reader.nextLine();
				String date= reader.nextLine();
				
	            if(admin.getPassword().equals(password)){
	                list.add(newName.getText());
	                list.add(newSurname.getText());
	                list.add(newMail.getText());
	                list.add(newPassword.getText());
	                list.add(date);
	                flag++;
	            }     
	            if(flag==0){
	          	  list.add(name);
				  list.add(surname);
				  list.add(mail); 
				  list.add(password); 
				  list.add(date);
	            }
	        }
	        reader.close();
	        writetoFile(list);
	    }
	}
	    public void writetoFile(ArrayList<String> list)throws IOException{
	    
	    	//Writing ArrayList to file
	    	File file=new File("Admin.txt");
	        BufferedWriter writer =new BufferedWriter(new FileWriter(file));
	        for(int i=0;i<list.size();i++){
	            writer.write(list.get(i));
	            if((list.size()-1)!=i){
	                writer.newLine();
	            }
	        }
	        writer.close();
	    }
	 
	    //Getter & Setter For Counter
		public static int getCounter() {
			return counter;
		}
}
