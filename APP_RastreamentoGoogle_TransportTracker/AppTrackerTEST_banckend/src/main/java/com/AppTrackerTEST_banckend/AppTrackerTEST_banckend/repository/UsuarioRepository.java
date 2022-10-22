package com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.model.UsuarioModel;

public interface UsuarioRepository extends ElasticsearchRepository<UsuarioModel, String> {

    List<UsuarioModel> findUsuarioModels(String nome);
    
}
