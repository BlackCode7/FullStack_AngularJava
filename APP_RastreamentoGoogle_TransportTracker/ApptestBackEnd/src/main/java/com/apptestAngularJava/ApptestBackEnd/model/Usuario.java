package com.apptestAngularJava.ApptestBackEnd.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@SequenceGenerator( name="seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	private String login;
	private String email;
	private String senha;
	
	@OneToMany( mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<SeriePeito> seriePeito = new ArrayList<SeriePeito>();
	
	
	@OneToMany( fetch = FetchType.EAGER )
	@JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint (columnNames = { "usuario_id", "role_id" }, name = "unique_role_user"),	
			joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false, foreignKey = @javax.persistence.ForeignKey( name = "usuario_fk", value = ConstraintMode.CONSTRAINT )),			
			inverseJoinColumns = @JoinColumn( name = "role_id", referencedColumnName = "id", updatable = false, table = "role", unique = false, foreignKey = @javax.persistence.ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))	
	private List<Role> roles; // Papeis do usuario	
	
	public List<SeriePeito> getNomeExercicio() {
		return seriePeito;
	}
	public void setNomeExercicio(List<SeriePeito> nomeExercicio) {
		this.seriePeito = nomeExercicio;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario() {}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
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
		return "Usuario [id=" + id + ", login=" + login + ", email=" + email + ", nomeSeriePeito=" + seriePeito
				+ ", role=" + "]";
	}	
	
	/* Autorização de usuários - ROLES_ADMIN, ROLE_GERENTE */	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return roles;
	}
	@Override
	public String getPassword() {
		return senha;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	

}
