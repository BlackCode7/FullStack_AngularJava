package com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.repository;

import java.util.List;



import com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.model.UsuarioModel;

public interface UsuarioRepository {

    List<UsuarioModel> findUsuarioModels(String nome);

    void saveAll(List<UsuarioModel> usuarioModel);

    Iterable<UsuarioModel> findAll();
    
}
