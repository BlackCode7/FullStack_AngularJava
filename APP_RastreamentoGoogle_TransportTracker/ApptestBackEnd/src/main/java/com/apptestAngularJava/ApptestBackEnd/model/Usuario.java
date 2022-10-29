package com.apptestAngularJava.ApptestBackEnd.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator( name="seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	private String nome;
	private String email;
	
	@OneToMany( mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<SeriePeito> seriePeito = new ArrayList<SeriePeito>();
	
	//@OneToMany( mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL )
	//private List<Role> role = new ArrayList<Role>();
		
	public List<SeriePeito> getNomeExercicio() {
		return seriePeito;
	}
	public void setNomeExercicio(List<SeriePeito> nomeExercicio) {
		this.seriePeito = nomeExercicio;
	}
	
	public Usuario() {}	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<SeriePeito> getNomeSeriePeito() {
		return seriePeito;
	}

	public void setNomeSeriePeito(List<SeriePeito> nomeSeriePeito) {
		this.seriePeito = nomeSeriePeito;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((seriePeito == null) ? 0 : seriePeito.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (seriePeito == null) {
			if (other.seriePeito != null)
				return false;
		} else if (!seriePeito.equals(other.seriePeito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", nomeSeriePeito=" + seriePeito
				+ ", role=" + "]";
	}

}
