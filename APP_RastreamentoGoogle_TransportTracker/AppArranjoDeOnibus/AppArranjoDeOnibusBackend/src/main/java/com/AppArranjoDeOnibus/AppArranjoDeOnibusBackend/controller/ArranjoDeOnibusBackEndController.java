package com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.model.ArranjoDeOnibusModel;
import com.AppArranjoDeOnibus.AppArranjoDeOnibusBackend.repository.ArranjoDeOnibusBackEndRepository;

// http://localhost:8272/AppArranjoDeOnibusBackend/arranjodeonibus/buscaTodosDoArranjo

@RestController
@RequestMapping(value = "/arranjodeonibus")
public class ArranjoDeOnibusBackEndController {
	
	@Autowired
	private ArranjoDeOnibusBackEndRepository ArranjoRepository;
	
	@DeleteMapping( value = "/deletaArranjo", produces = "application/json")
	public String deletaArranjo( @PathVariable("id") Integer id ) {
		ArranjoRepository.deleteById(id);
		return "Arranjo deletado com sucesso!";
	}
	
	@PutMapping( value = "/atualizaArranjo", produces = "application/json")
	public ResponseEntity<ArranjoDeOnibusModel> atualizaArranjoPUT(
			@RequestBody ArranjoDeOnibusModel arranjo){		
		ArranjoDeOnibusModel atualizaArranjo = ArranjoRepository.save(arranjo);		
		return new ResponseEntity<ArranjoDeOnibusModel>(atualizaArranjo, HttpStatus.OK);
	}
	
	// Busca por todos do arranjo
	@GetMapping( value = "/buscaTodosDoArranjo", produces = "application/json" )
	public ResponseEntity<List<ArranjoDeOnibusModel>> buscaTodosDoArranjo(){		
		List<ArranjoDeOnibusModel> buscaTodosDoArranjo = ArranjoRepository.findAll();		
		return new ResponseEntity<List<ArranjoDeOnibusModel>>(buscaTodosDoArranjo, HttpStatus.OK);
	}
	
	// Busca por id do arranjo
	@GetMapping( value = "/{id}", produces = "application/json")
	public ResponseEntity<ArranjoDeOnibusModel> buscaArranjoPorIdGET(
			@PathVariable( value = "id" ) Integer id ){		
		Optional<ArranjoDeOnibusModel> buscaArranjoPorId = ArranjoRepository.findById(id);		
		return new ResponseEntity<ArranjoDeOnibusModel>(buscaArranjoPorId.get(), HttpStatus.OK);
	}

	// Salvando todos publicadores do arranjo de onibus
	@PostMapping( value = "salvaArranjo", produces = "application/json" )
	public ResponseEntity<ArranjoDeOnibusModel> cadastraTodosPOST(
			@RequestBody ArranjoDeOnibusModel arranjo ){
		// instancia do modelo arranjo      salvado com repository        
		ArranjoDeOnibusModel arranjoSalvo = ArranjoRepository.save(arranjo);		
		return new ResponseEntity<ArranjoDeOnibusModel>(arranjoSalvo, HttpStatus.OK);
	}
	
	
}
