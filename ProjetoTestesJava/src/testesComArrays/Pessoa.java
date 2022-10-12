package testesComArrays;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	
	private Long id;
	private String nome;
	private String idade;
	
	List<Livro> listaLivro = new ArrayList<Livro>();
	
	public Pessoa() {
		super();
	}

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

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public List<Livro> getListaLivro() {
		return listaLivro;
	}

	public void setListaLivro(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", listaLivro=" + listaLivro + "]";
	}
		
}
