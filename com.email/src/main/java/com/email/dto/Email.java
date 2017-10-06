package com.email.dto;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

public class Email {
	
	@NotNull
	private String sender;
	@NotNull
	private String[] recepients;
	private String[] bcc;
	private String[] cc;
	@NotNull
	private String subject; 
	private String body="";
	
	public Email() {
		
	}
	
	public Email(String sender, String title, String body, String[] recepients, String[] bcc, String[] cc) {
		this.recepients = recepients;
		this.sender = sender;
		this.bcc = bcc;
		this.cc = cc;
		this.subject = title;
		this.body = body;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String[] getRecepients() {
		return recepients;
	}

	public void setRecepients(String[] recepients) {
		this.recepients = recepients;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setTitle(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [sender=" + sender + ", recepients=" + Arrays.toString(recepients) + ", bcc="
				+ Arrays.toString(bcc) + ", cc=" + Arrays.toString(cc) + ", title=" + subject + ", body=" + body + "]";
	}
	
	
	
}
