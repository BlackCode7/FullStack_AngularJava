package testesComArrays;

public class ExecucaoTestesComArrays {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Carlos");
		Livro livro = new Livro();
		livro.setTitulo("Game of thrones");
		pessoa.getListaLivro().add(livro) ; {}
		
		for ( Livro p: pessoa.getListaLivro() ) {
			System.out.println(pessoa.getNome()+" "+p);
		}
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Andre");
		Livro livro2 = new Livro();
		livro2.setTitulo("Blade Runner");
		pessoa2.getListaLivro().add(livro2);
		
		for( Livro L: pessoa2.getListaLivro() ) {
			System.out.println(pessoa2.getNome()+" "+L);
		}
		
		
		
		
		

	}

}
