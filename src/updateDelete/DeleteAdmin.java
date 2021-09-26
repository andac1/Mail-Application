package updateDelete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.AdminsEntity;
import entity.AllParameter;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DeleteAdmin extends AllParameter{
	//Delete Admin Class
			public void deleteAdmin(TableView<AdminsEntity> table,TextField Mail) throws IOException {
				if(table.getSelectionModel().getSelectedItems().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No ADMÝN to DELETE was selected","ADMÝN",JOptionPane.ERROR_MESSAGE,null);
				}
				else {
					JOptionPane.showMessageDialog(null, "DELETE sucessfull","DELETE",JOptionPane.INFORMATION_MESSAGE,null);
				ArrayList<String> list = new ArrayList<>();
				File file = new File("Admin.txt");
				Scanner reader = new Scanner(file);
				while (reader.hasNextLine()) {
					int flag = 0; //kind of counter for missing equal values
					String name = reader.nextLine();
					String surname = reader.nextLine();
					String mail= reader.nextLine(); 
					String password= reader.nextLine();
					String date= reader.nextLine();
					
					if(Mail.getText().equals(mail)) {
						flag++;
						boolean result;
						File delete1=new  File(getMailinput().getText()+"-take"+".txt");
						File delete2=new  File(getMailinput().getText()+"-send"+".txt");
						result=delete1.delete();
						result=delete2.delete();	
					}
					if (flag == 0) {
					System.out.println(flag);
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
			public void writetoFile(ArrayList<String> list) throws IOException {
				//Writing ArrayList to file
				File file = new File("Admin.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for (int i = 0; i < list.size(); i++) {
					writer.write(list.get(i));
					if ((list.size() - 1) != i) {
						writer.newLine();
					}
				}
				writer.close();
			}
}
