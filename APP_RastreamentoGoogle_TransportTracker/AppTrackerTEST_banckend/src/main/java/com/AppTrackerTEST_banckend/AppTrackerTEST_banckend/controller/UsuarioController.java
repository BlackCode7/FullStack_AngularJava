package com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.model.UsuarioModel;
import com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.repository.UsuarioRepository;

@RestController
public class UsuarioController {
 
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/salvaUsuarios")
    public int saveUserIndex( @RequestBody List<UsuarioModel> usuarioModel ) {
        System.out.println( usuarioModel.toString());
        usuarioRepository.saveAll(usuarioModel);
        return usuarioModel.size();
    }
    
    @GetMapping("buscarTodosUsuarios")
    public Iterable<UsuarioModel> findAllUsuarioModel(){
        return usuarioRepository.findAll();
    }
    
    public List<UsuarioModel> findByNome( @PathVariable String nome ){
        return usuarioRepository.findUsuarioModels(nome);
    }
    
}
