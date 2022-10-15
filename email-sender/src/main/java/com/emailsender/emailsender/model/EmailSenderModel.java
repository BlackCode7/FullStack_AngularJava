package com.emailsender.emailsender.model;

public class EmailSenderModel {

	private String to;
	private String subject;
	private String message;
	public EmailSenderModel() {
		super();
	}
	public EmailSenderModel(String to, String subject, String message) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
