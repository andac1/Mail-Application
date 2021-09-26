package txtWarehouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.AllParameter;

public class TxtAdmins extends AllParameter{
	public void addAdmins(TxtAdmins admins) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
	    Date date1 = new Date();
	    
	    	    
	    if(getNameinput().getLength()==0) 	 		{ 		JOptionPane.showMessageDialog(null,"NAME field is empty","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
	    else if(getNameinput().getLength()<2 ) 	     {		JOptionPane.showMessageDialog(null,"Your NAME can't be shorter than 2 letters","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
	    else if(getNameinput().getLength()>15) 	 {    	JOptionPane.showMessageDialog(null,"Your NAME can not be longer than 15 letters","NAME",JOptionPane.ERROR_MESSAGE,null );	 }
	   
	    else if(getSurnameinput().getLength()==0)  {		JOptionPane.showMessageDialog(null,"SURNAME field is empty","SURNAME",JOptionPane.ERROR_MESSAGE,null);    }
	    else if(getSurnameinput().getLength()<2)    {    	JOptionPane.showMessageDialog(null,"Your SURNAME can not be shorter than 2 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null); }
	    else if(getSurnameinput().getLength()>15)  {		JOptionPane.showMessageDialog(null,"Your SURNAME can not be longer than 15 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null );			 }
	    
	    else if(getMailinput().getLength()==0) 		   	  {	 	JOptionPane.showMessageDialog(null,"MAÝL field is empty","MAÝL",JOptionPane.ERROR_MESSAGE,null); 		}  
	    else if((getMailinput().getText().contains("@admin.com")==false)){
	    	JOptionPane.showMessageDialog(null,"Your T-Mail have to be in *****@admin.com type","MAÝL",JOptionPane.ERROR_MESSAGE,null);
	    }

	    else if(getPasswordinput().getLength()==0)  	{		JOptionPane.showMessageDialog(null,"PASSWORD field is empty","PASSWORD",JOptionPane.ERROR_MESSAGE,null); 		}  
	    
	    
	    
	    else {
	    int flagA = 0; //kind of counter for missing equal values
	    File adminF =new File("Admin.txt");
		Scanner adminReader= new Scanner(adminF);
		while (adminReader.hasNextLine()) {
			
			String nameA = adminReader.nextLine();
			String surnameA = adminReader.nextLine();
			String mailA= adminReader.nextLine(); 
			String passwordA= adminReader.nextLine();
			String dateA= adminReader.nextLine();
			
	    
			if(getMailinput().getText().equals(mailA)){
				flagA++;
				JOptionPane.showMessageDialog(null,"This email address has already taken before.","E-Mail",JOptionPane.ERROR_MESSAGE,null);
			}
		}adminReader.close();
		if(flagA==0) {
		File file=new File("Admin.txt");
		BufferedWriter writer;
		writer=	new BufferedWriter(new FileWriter (file,true));
		 
		if(file.length()!=0) 
		writer.newLine();
		writer.write(admins.getNameinput().getText());
		writer.newLine();
		writer.write(admins.getSurnameinput().getText());
		writer.newLine();
		writer.write(admins.getMailinput().getText());
		writer.newLine();
		writer.write(admins.getPasswordinput().getText());
		writer.newLine();
		writer.write(dateFormat.format(date1));
		//Pop-up
		JOptionPane.showMessageDialog(null, "Adding Successful");
		creatAdmin();
		writer.close();
			}
	    }
	}
public void creatAdmin() {
		File take=new File(getMailinput().getText()+"-take"+".txt");
		File send=new File(getMailinput().getText()+"-send"+".txt");
		try {
			if(take.createNewFile()&send.createNewFile()) {
				System.out.println("File Created now");
				// Default admin user
				}else {
				System.out.println("File Already Has Created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
