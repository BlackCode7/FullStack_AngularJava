package com.apptestAngularJava.ApptestBackEnd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apptestAngularJava.ApptestBackEnd.model.SeriePeito;
import com.apptestAngularJava.ApptestBackEnd.repository.SeriePeitoRepository;

@RestController
@RequestMapping(value = "/seriepeito")
public class SeriePeitoController {
	
	@Autowired
	private SeriePeitoRepository seriePeitoRepository;
	
	
	@CrossOrigin
	@GetMapping(value = "/buscaPorNomeSeriePeito", produces = "application/json")
	public ResponseEntity<List<SeriePeito>> buscaPartesNomeSerie(@RequestParam(name = "nome") String nomeSerie) {
		List<SeriePeito> busacaPorNomeSeriePeito = seriePeitoRepository.buscaPorNomeExercicio(nomeSerie.strip().toUpperCase());
		return new ResponseEntity<List<SeriePeito>>(busacaPorNomeSeriePeito, HttpStatus.OK);
	}
	
	
	/* Método para listar usuários */
	@CrossOrigin
	@GetMapping(value = "listatodosseriepeito", produces = "application/json")
	public ResponseEntity<List<SeriePeito>> listaTodasSeries() {
		List<SeriePeito> listaTodosSeriePeito = seriePeitoRepository.findAll();
		return new ResponseEntity<List<SeriePeito>>(listaTodosSeriePeito, HttpStatus.OK);
	}
	
	
	/* consulta por ID */
	@CrossOrigin
	@GetMapping(value = "/buscaporid/{id}", produces = "application/json")
	public ResponseEntity<SeriePeito> buscaPorID(@PathVariable(value = "id") Long id) {
		Optional<SeriePeito> buscaPorIdSeriePeito = seriePeitoRepository.findById(id);
		return new ResponseEntity<SeriePeito>(buscaPorIdSeriePeito.get(), HttpStatus.OK);
	}
	
	
	/* Salvando usuarios */
	@CrossOrigin
	@PostMapping(value = "salvaseriepeito", produces = "application/json")
	public ResponseEntity<SeriePeito> cadastraSeriePeito(@RequestBody SeriePeito seriePeito) {
		// Associando o papel com o usuário - do objetos pai para o filho -
		// referenciando
		/*
		 for (int pos = 0; pos < usuario.getNomeExercicio().size(); pos++) {
			usuario.getNomeExercicio().get(pos).setUsuario(usuario);
		 }
		 */	 
		SeriePeito seriePeitoSalvo = seriePeitoRepository.save(seriePeito);
		return new ResponseEntity<SeriePeito>(seriePeitoSalvo, HttpStatus.OK);
	}
	
	
	/* Deletar Usuários */
	@CrossOrigin
	@DeleteMapping(value = "/deleteseriepeito/{id}", produces = "application/text")
	public String deleteSeriePeito(@PathVariable("id") Long id) {
		seriePeitoRepository.deleteById(id);
		return "Ok Serie Peito deletado com sucesso!";
	}
	
	/* Atualiza usuarios */
	@CrossOrigin
	@PutMapping(value = "atualizaseriepeito", produces = "application/json")
	public ResponseEntity<SeriePeito> atualizarSeriePeito(@RequestBody SeriePeito seriePeito) {

		// Associando o papel com o usuário - do objetos pai para o filho -
		// referenciando
		/* for (int pos = 0; pos < usuario.getRole().size(); pos++) {
			usuario.getRole().get(pos).setUsuario(usuario);
		}*/		 

		SeriePeito atualSeriePeitoSalvo = seriePeitoRepository.save(seriePeito);
		return new ResponseEntity<SeriePeito>(atualSeriePeitoSalvo, HttpStatus.OK);
	}

}













