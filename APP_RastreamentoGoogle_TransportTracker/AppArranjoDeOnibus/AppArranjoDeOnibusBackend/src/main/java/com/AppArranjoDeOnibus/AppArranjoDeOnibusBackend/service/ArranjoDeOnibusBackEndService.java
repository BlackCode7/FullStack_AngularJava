package com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.repository.ArranjoDeOnibusBackEndRepository;

@Service
public class ArranjoDeOnibusBackEndService {
	
	@Autowired
	private ArranjoDeOnibusBackEndRepository arranjoDeOnibusBackEndRepository;

}
