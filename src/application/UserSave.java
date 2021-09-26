package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserSave {
	public void defaultAdmin() {
		File admin=new File("Admin.txt"); 
		try {
				// Default admin user
				BufferedWriter writer;
				writer=	new BufferedWriter(new FileWriter (admin,true));
				if(admin.length()!=0) 
				{writer.newLine();}
				writer.write("Admin");
				writer.newLine();
				writer.write("Admin");
				writer.newLine();
				writer.write("admin@admin.com");
				writer.newLine();
				writer.write("admin");
				writer.newLine();
				writer.write("00/00/0000-00:00");
				writer.close();
				// Default admin KULLANICISI
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
