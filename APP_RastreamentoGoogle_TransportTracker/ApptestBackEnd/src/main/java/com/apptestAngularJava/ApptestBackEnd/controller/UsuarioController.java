package com.apptestAngularJava.ApptestBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apptestAngularJava.ApptestBackEnd.model.Usuario;
import com.apptestAngularJava.ApptestBackEnd.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	/* Método para listar usuários */
	@CrossOrigin
	@RequestMapping(value="/listatodos", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Usuario>> listausuario(){
		List<Usuario> usuario = repository.findAll();
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@GetMapping( value = "/buscaPorNome")
	public ResponseEntity<List<Usuario>> buscaPartesNome( @RequestParam(name="nome") String nome ){
		List<Usuario> usuario = repository.buscaPorNome(nome.strip().toUpperCase());
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	
}











