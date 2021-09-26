package entity;

import javafx.beans.property.SimpleStringProperty;

public class MailEntity {
	//Attribute | Field
    private final SimpleStringProperty toWho;
    private final SimpleStringProperty topic;
    private final SimpleStringProperty mail;
    private final SimpleStringProperty Date;
    
  //constructor without parameters
    public MailEntity() {
		this.Date = new SimpleStringProperty();
		this.topic = new SimpleStringProperty();
		this.toWho = new SimpleStringProperty();
		this.mail = new SimpleStringProperty();
    	
    }
  //constructor with parameters
 public MailEntity(String toWho,String topic,String mail,String date) {
	this.Date = new SimpleStringProperty(date);
	this.topic = new SimpleStringProperty(topic);
	this.toWho = new SimpleStringProperty(toWho);
	this.mail = new SimpleStringProperty(mail);
    	
    }
    
    
    
    
    public String getToWho() {
		return toWho.get();
	}

	public String getTopic() {
		return topic.get();
	}

	public String getMail() {
		return mail.get();
	}

	public String getDate() {
		return Date.get();
	}

	
}
