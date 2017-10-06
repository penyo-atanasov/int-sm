package com.email.dto;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

public class Email {
	
	@NotNull
	private String sender;
	@NotNull
	private String[] recipients;
	private String[] bcc;
	private String[] cc;
	@NotNull
	private String subject; 
	private String body="";
	
	public Email() {
		
	}
	
	public Email(String sender, String title, String body, String[] recipients, String[] bcc, String[] cc) {
		this.recipients = recipients;
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

	public String[] getRecipients() {
		return recipients;
	}

	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
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
		return "Email [sender=" + sender + ", recepients=" + Arrays.toString(recipients) + ", bcc="
				+ Arrays.toString(bcc) + ", cc=" + Arrays.toString(cc) + ", title=" + subject + ", body=" + body + "]";
	}
	
	
	
}
