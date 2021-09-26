package transactions;

import javax.swing.JOptionPane;

import entity.AllParameter;

public class UserInquiry extends AllParameter{
	//HATA AYIKLAMA ALANI
	public void inquiry() {
		 if(getNameinput().getLength()==0) 	 		{ 		JOptionPane.showMessageDialog(null,"NAME field is empty","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
		    else if(getNameinput().getLength()<2 ) 	     {		JOptionPane.showMessageDialog(null,"Your NAME can't be shorter than 2 letters","NAME",JOptionPane.ERROR_MESSAGE,null); 		}
		    else if(getNameinput().getLength()>15) 	 {    	JOptionPane.showMessageDialog(null,"Your NAME can not be longer than 15 letters","NAME",JOptionPane.ERROR_MESSAGE,null );	 }
		   
		    else if(getSurnameinput().getLength()==0)  {		JOptionPane.showMessageDialog(null,"SURNAME field is empty","SURNAME",JOptionPane.ERROR_MESSAGE,null);    }
		    else if(getSurnameinput().getLength()<2)    {    	JOptionPane.showMessageDialog(null,"Your SURNAME can not be shorter than 2 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null); }
		    else if(getSurnameinput().getLength()>15)  {		JOptionPane.showMessageDialog(null,"Your SURNAME can not be longer than 15 letters","SURNAME",JOptionPane.ERROR_MESSAGE,null );			 }
		    
		    else if(getMailinput().getLength()==0) 		   	  {	 	JOptionPane.showMessageDialog(null,"MAÝL field is empty","MAÝL",JOptionPane.ERROR_MESSAGE,null); 		}  
		    
		    else if(getPasswordinput().getLength()==0)  	{		JOptionPane.showMessageDialog(null,"PASSWORD field is empty","PASSWORD",JOptionPane.ERROR_MESSAGE,null); 		}  
		   		 
	}
}
