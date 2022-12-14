package com.emailsender.emailsender.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.emailsender.emailsender.service.EmailSenderService;

@Service
public class EmailSenderServiceIMPL implements EmailSenderService{

	private final JavaMailSender mailSender;
	
	
	public EmailSenderServiceIMPL( JavaMailSender mailSender ) {
		this.mailSender = mailSender;
	}	
	
	@Override
	public void sendEmail(String to, String subject, String message) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("criacaoemaildetestecomjava@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);

		this.mailSender.send(simpleMailMessage);
		
	}

	
	
}
