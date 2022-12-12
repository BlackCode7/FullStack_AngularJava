package com.blackcode7.BlackCodeSales.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blackcode7.BlackCodeSales.entities.Sales;
import com.blackcode7.BlackCodeSales.repositories.SalesRepository;

@Service
public class SalesService {

	@Autowired
	private SalesRepository salesRepository;

	public Page<Sales> findSales(String minDate, String maxDate, Pageable pageable) {

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate); // pega data de 1 ano
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return salesRepository.findSales(min, max, pageable);

	}

}
