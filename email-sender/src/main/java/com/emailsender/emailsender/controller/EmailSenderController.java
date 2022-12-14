package com.emailsender.emailsender.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emailsender.emailsender.resource.EmailMessage;
import com.emailsender.emailsender.service.EmailSenderService;

@RestController
public class EmailSenderController {
	
	private EmailSenderService emailSenderService;

	public void EmailController( EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}
	
	
	@PostMapping("/emailEnvio")
	public ResponseEntity sendEmail( @RequestBody EmailMessage emailMessage) {
		this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
		return ResponseEntity.ok("Sucesso");
	}
	
	
}
