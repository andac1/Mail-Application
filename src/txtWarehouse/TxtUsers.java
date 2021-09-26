package txtWarehouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entity.AllParameter;


public class TxtUsers extends AllParameter{
	public void addUsers(TxtUsers users) throws FileNotFoundException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
	    Date date1 = new Date();
	    
	    if(getNameinput().getLength()==0) 	 		{ 		JOptionPane.showMessageDialog(null,"NAME field is empty","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
	    else if(getNameinput().getLength()<2 ) 	     {		JOptionPane.showMessageDialog(null,"Your NAME can't be shorter than 2 letters","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
	    else if(getNameinput().getLength()>15) 	 {    	JOptionPane.showMessageDialog(null,"Your NAME can not be longer than 15 letters","NAME",JOptionPane.ERROR_MESSAGE,null );	 }
	   
	    else if(getSurnameinput().getLength()==0)  {		JOptionPane.showMessageDialog(null,"SURNAME field is empty","SURNAME",JOptionPane.ERROR_MESSAGE,null);    }
	    else if(getSurnameinput().getLength()<2)    {    	JOptionPane.showMessageDialog(null,"Your SURNAME can not be shorter than 2 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null); }
	    else if(getSurnameinput().getLength()>15)  {		JOptionPane.showMessageDialog(null,"Your SURNAME can not be longer than 15 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null );			 }
	    
	    else if(getMailinput().getLength()==0) 		   	  {	 	JOptionPane.showMessageDialog(null,"MAÝL field is empty","MAÝL",JOptionPane.ERROR_MESSAGE,null); 		}  
	    
	    else if(getPasswordinput().getLength()==0)  	{		JOptionPane.showMessageDialog(null,"PASSWORD field is empty","PASSWORD",JOptionPane.ERROR_MESSAGE,null); 		}  
	    else if((getMailinput().getText().contains("@user.com")==false)){
	    	JOptionPane.showMessageDialog(null,"Your T-Mail have to be in *****@user.com type","MAÝL",JOptionPane.ERROR_MESSAGE,null);
	    }
	    
	    else {
	    int flagU = 0; //kind of counter for missing equal values
	    File userF =new File("users.txt");
		Scanner userReader= new Scanner(userF);
		while (userReader.hasNextLine()) {
			
			String nameU = userReader.nextLine();
			String surnameU= userReader.nextLine();
			String mailU= userReader.nextLine(); 
			String passwordU= userReader.nextLine();
			String dateA= userReader.nextLine();
			
	    
			if(getMailinput().getText().equals(mailU)){
				flagU++;
				JOptionPane.showMessageDialog(null,"This email address has already taken before.","E-Mail",JOptionPane.ERROR_MESSAGE,null);
			}
		}userReader.close();
		if(flagU==0) {
		try {
		File file=new File("users.txt");
		BufferedWriter writer;
		writer=	new BufferedWriter(new FileWriter (file,true));
		 
		if(file.length()!=0) 
		writer.newLine();
		writer.write(users.getNameinput().getText());
		writer.newLine();
		writer.write(users.getSurnameinput().getText());
		writer.newLine();
		writer.write(users.getMailinput().getText());
		writer.newLine();
		writer.write(users.getPasswordinput().getText());
		writer.newLine();
		writer.write(dateFormat.format(date1));
		
		//Pop-up
		JOptionPane.showMessageDialog(null, "Adding Successful");	
		writer.close();
		creatUser();
	} catch (IOException e) {
		e.printStackTrace();
				}
	    	}
	    }
	}				
	public void creatUser() {
		File take=new File(getMailinput().getText()+"-take"+".txt");
		File send=new File(getMailinput().getText()+"-send"+".txt");
		try {
			if(take.createNewFile()&send.createNewFile()) {
				System.out.println("File Created now");
				}else {
				System.out.println("File Already Has Created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
