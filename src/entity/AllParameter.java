package entity;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AllParameter {

	
	private static Label mailLabel=new Label("To Who");
	private static TextField tFWho=new TextField();
	private static Label topicLabel=new Label("Topic");
	private static TextField tFTopic=new TextField();
	private static Label bodyLabel=new Label("Budy");
	private static TextArea tAbody=new TextArea();
	
	

	private static TextField nameinput=new TextField();
	private static TextField surnameinput=new TextField();
	private static TextField mailinput=new TextField();
	private static TextField passwordinput=new TextField();
	
	private static Label nameL= new Label("|NAME");
	private static Label surnameL= new Label("|SURNAME");
	private static Label mailL= new Label("|Creat Mail Adress");
	private static Label passwordL= new Label("|Password");
	
	public TextField getNameinput() {
		return nameinput;
	}
	public static void setNameinput(TextField nameinput) {
		AllParameter.nameinput = nameinput;
	}
	public TextField getSurnameinput() {
		return surnameinput;
	}
	public static void setSurnameinput(TextField surnameinput) {
		AllParameter.surnameinput = surnameinput;
	}
	public TextField getMailinput() {
		return mailinput;
	}
	public static void setMailinput(TextField mailinput) {
		AllParameter.mailinput = mailinput;
	}
	public TextField getPasswordinput() {
		return passwordinput;
	}
	public static void setPasswordinput(TextField passwordinput) {
		AllParameter.passwordinput = passwordinput;
	}
	public static Label getNameL() {
		return nameL;
	}
	public static void setNameL(Label nameL) {
		AllParameter.nameL = nameL;
	}
	public static Label getSurnameL() {
		return surnameL;
	}
	public static void setSurnameL(Label surnameL) {
		AllParameter.surnameL = surnameL;
	}
	public static Label getMailL() {
		return mailL;
	}
	public static void setMailL(Label mailL) {
		AllParameter.mailL = mailL;
	}
	public static Label getPasswordL() {
		return passwordL;
	}
	public static void setPasswordL(Label passwordL) {
		AllParameter.passwordL = passwordL;
	}
	public static Label getMailLabel() {
		return mailLabel;
	}
	public static void setMailLabel(Label mailLabel) {
		AllParameter.mailLabel = mailLabel;
	}

	public static TextField gettFWho() {
		return tFWho;
	}
	public static void settFWho(TextField tFWho) {
		AllParameter.tFWho = tFWho;
	}
	public static TextField gettFTopic() {
		return tFTopic;
	}
	public static void settFTopic(TextField tFTopic) {
		AllParameter.tFTopic = tFTopic;
	}
	public static Label getTopicLabel() {
		return topicLabel;
	}
	public static void setTopicLabel(Label topicLabel) {
		AllParameter.topicLabel = topicLabel;
	}
	public static Label getBodyLabel() {
		return bodyLabel;
	}
	public static void setBodyLabel(Label bodyLabel) {
		AllParameter.bodyLabel = bodyLabel;
	}
	public static TextArea gettAbody() {
		return tAbody;
	}
	public static void settAbody(TextArea tAbody) {
		AllParameter.tAbody = tAbody;
	}


	
}
