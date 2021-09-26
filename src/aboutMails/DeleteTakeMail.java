package aboutMails;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.MailEntity;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DeleteTakeMail {
	//Delete Take Mail
	public void deleteMail(TableView<MailEntity> table,TextField Who) throws IOException {
		if(table.getSelectionModel().getSelectedItems().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No USER to DELETE was selected","USER",JOptionPane.ERROR_MESSAGE,null);
		}
		else {
			JOptionPane.showMessageDialog(null, "DELETE sucessfull","DELETE",JOptionPane.INFORMATION_MESSAGE,null);
		ArrayList<String> list = new ArrayList<>();
		
		 String username;
		 File Username =new File("username.txt");
			Scanner readers;
			
				readers = new Scanner(Username);
				username=readers.nextLine();
				readers.close();
				
		File file = new File(username+"-take"+".txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			int flag = 0; //kind of counter for missing equal values
			String toWho = reader.nextLine();
			String topic = reader.nextLine();
			String mail= reader.nextLine();
			String date= reader.nextLine();
			
			if(Who.getText().equals(toWho)) {
				flag++;
			}
			if (flag == 0) {
			System.out.println(flag);
				  list.add(toWho);
				  list.add(topic);
				  list.add(mail); 
				  list.add(date);
				  }
		}
		reader.close();
		writetoFile(list);
	}
}
	public void writetoFile(ArrayList<String> list) throws IOException {
		//Writing ArrayList to file
		 String username;
		 File Username =new File("username.txt");
			Scanner readers;
			
				readers = new Scanner(Username);
				username=readers.nextLine();
				readers.close();
				
		File file = new File(username+"-take"+".txt");
		
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
