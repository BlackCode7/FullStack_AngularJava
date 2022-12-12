package com.blackcode7.BlackCodeSales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.blackcode7.BlackCodeSales.entities.Sales;
import com.blackcode7.BlackCodeSales.repositories.SalesRepository;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {
	
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SalesRepository salesRepository;
	
	public void sendSMS( Long saleId ) {
		
		Sales sales = salesRepository.findById(saleId).get();
		String date = sales.getDate().getMonth() + "/" + sales.getDate().getYear();
		
		String msg = " O Vendedor " + sales.getSellerName()+ " Foi destaque em " 
					 + date + " Com um total de R$ " 
					 + String.format("%.2f", sales.getAmount());
		
		Twilio.init(twilioSid, twilioKey);
		
		PhoneNumber to = new PhoneNumber( twilioPhoneTo );
		PhoneNumber from = new PhoneNumber( twilioPhoneFrom );
		
		Message message = Message.creator(to, from, msg).create();
		
		System.out.println(message.getSid());
		
	}

}
