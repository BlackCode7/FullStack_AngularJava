package com.AppTrackerTEST_banckend.AppTrackerTEST_banckend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document( indexName = "IndexUserTrackLover", shards = 1, replicas = 0, refreshInterval = "1s", createIndex = true )
public class UsuarioModel {

    @Id private Long id;
    private String nome;
    private String sobreNome;
    private int idade;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobreNome() {
        return sobreNome;
    }
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
}
