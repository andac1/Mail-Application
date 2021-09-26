package entity;

import javafx.beans.property.SimpleStringProperty;

public class UsersEntity {
	//Attribute | Field
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty mail;
    private final SimpleStringProperty password; 
    private final SimpleStringProperty date;
   

	//constructor without parameters
    public UsersEntity(){
    	this.firstName = new SimpleStringProperty();
    	this.lastName = new SimpleStringProperty();
    	this.mail = new SimpleStringProperty();
    	this.password = new SimpleStringProperty();
		this.date = new SimpleStringProperty();
    }
  //constructor with parameters
    public UsersEntity(String fName, String lName, String mail,String password,String date) {
    	this.firstName = new SimpleStringProperty(fName);
    	this.lastName = new SimpleStringProperty(lName);
    	this.mail = new SimpleStringProperty(mail);
    	this.password = new SimpleStringProperty(password);
		this.date = new SimpleStringProperty(date);
    }
	//Getter & Setter
    //FirstName
    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
    //LastName    
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String fName) {
        lastName.set(fName);
    }
	public String getMail() {
		return mail.get();
	}
	 public void setMail(String fName) {
	        mail.set(fName);
	    }
	public String getPassword() {
		return password.get();
	}
	 public void setPassword(String fName) {
	        password.set(fName);
	    }
	public String getDate() {
		return date.get();
	}
	 public void setDate(String fName) {
	        date.set(fName);
	    }
}
