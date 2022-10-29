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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apptestAngularJava.ApptestBackEnd.model.Usuario;
import com.apptestAngularJava.ApptestBackEnd.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository userRepository;

	/* Deletar Usuários */
	@CrossOrigin
	@DeleteMapping(value = "/deletausuario/{id}", produces = "application/text")
	public String deletarusuario(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return "Ok usuário deletado com sucesso!";
	}

	/* Atualiza usuarios */
	@CrossOrigin
	@PutMapping(value = "atualizausuario", produces = "application/json")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {

		// Associando o papel com o usuário - do objetos pai para o filho -
		// referenciando
		/* for (int pos = 0; pos < usuario.getRole().size(); pos++) {
			usuario.getRole().get(pos).setUsuario(usuario);
		}*/
		 

		Usuario atualUsuarioSalvo = userRepository.save(usuario);
		return new ResponseEntity<Usuario>(atualUsuarioSalvo, HttpStatus.OK);
	}

	/* Salvando usuarios */
	@CrossOrigin
	@PostMapping(value = "salvausuario", produces = "application/json")
	public ResponseEntity<Usuario> cadastrarusuario(@RequestBody Usuario usuario) {

		// Associando o papel com o usuário - do objetos pai para o filho -
		// referenciando
		/*
		 for (int pos = 0; pos < usuario.getNomeExercicio().size(); pos++) {
			usuario.getNomeExercicio().get(pos).setUsuario(usuario);
		 }
		 */
		 		

		Usuario usuarioSalvo = userRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}

	/* consulta por ID */
	@CrossOrigin
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> buscaPorID(@PathVariable(value = "id") Long id) {
		Optional<Usuario> buscaPorIdUsuario = userRepository.findById(id);
		return new ResponseEntity<Usuario>(buscaPorIdUsuario.get(), HttpStatus.OK);
	}

	/* Método para listar usuários */
	@CrossOrigin
	@GetMapping(value = "/listatodos", produces = "application/json")
	public ResponseEntity<List<Usuario>> listausuario() {
		List<Usuario> listaTodosUsuario = userRepository.findAll();
		return new ResponseEntity<List<Usuario>>(listaTodosUsuario, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping(value = "/buscaPorNome", produces = "application/json")
	public ResponseEntity<List<Usuario>> buscaPartesNome(@RequestParam(name = "nome") String nome) {
		List<Usuario> busacaPorNomeUsuario = userRepository.buscaPorNome(nome.strip().toUpperCase());
		return new ResponseEntity<List<Usuario>>(busacaPorNomeUsuario, HttpStatus.OK);
	}

}
