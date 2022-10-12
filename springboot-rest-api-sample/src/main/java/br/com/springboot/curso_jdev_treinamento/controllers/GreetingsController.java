package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;
import br.com.springboot.curso_jdev_treinamento.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/* Método para buscar por partes de uma palavra */
	@GetMapping( value = "buscarParteNome")//Usando o form-data do postman
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarParteNome( @RequestParam(name="name") String name ){//Aqui eu recebo os dados para salvar
		List<Usuario> usuario = usuarioRepository.buscarPorNome(name.strip().toUpperCase()); //.deleteById(idUser);//Aqui eu deleto o usuario do banco
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}	
	
	/* Método para deletar usuários */
	@DeleteMapping( value = "delete")
	@ResponseBody
	public ResponseEntity<String> deletaUsuario( @RequestParam Long idUser ){//Aqui eu recebo os dados para salvar
		usuarioRepository.deleteById(idUser);//Aqui eu deleto o usuario do banco
		return new ResponseEntity<String>("Usuario deletado com sucesso!", HttpStatus.OK);
	}
	
	/* Método para salvar */
	@PostMapping( value = "salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvausuario( @RequestBody Usuario usuario ){//Aqui eu recebo os dados para salvar
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}	
	
	/* Método para listar usuários */
	@GetMapping(value="listatodos")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listausuario(){
		List<Usuario> usuario = usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	
}
