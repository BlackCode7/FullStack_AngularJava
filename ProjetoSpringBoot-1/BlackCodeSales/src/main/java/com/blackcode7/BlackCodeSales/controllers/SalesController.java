package com.blackcode7.BlackCodeSales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackcode7.BlackCodeSales.entities.Sales;
import com.blackcode7.BlackCodeSales.services.SalesService;
import com.blackcode7.BlackCodeSales.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {
	
	@Autowired
	private SalesService salesSevice; 

	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<Sales> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable
			){
		return salesSevice.findSales(minDate, maxDate, pageable);
	}
	
	/* Envio de mensagem com twilio */
	public void notifySms( @PathVariable Long id ) {
		smsService.sendSMS(id);
	}
	
	
	
}
