package ArrayList_PaulDeitel;

public class UtilizandoGr�ficosBarrasParaExibirDadosArrayGraficamente {

	public static void main(String[] args) 
	{
		int[] array = { 0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1 };

		System.out.println("Grade de Distribui��o");
		
		// para cada elemento de array, gera sa�da de uma barra do gr�fico
		for( int counter=0; counter<array.length; counter++ ) {
			
			// gera sa�da do r�tulo de barra ( "00-09: ", ..., "90-99: ", "100: ")
			if( counter == 10 ) 
				System.out.printf( "%5d: ", 100 );
			else 
				System.out.printf("%02d-%02d: ", 
						counter * 10, counter * 10 + 9);
			
			// imprime a barra de asteriscos
			for( int stars=0; stars < array[counter]; stars++ ) {
				System.out.println("*");
			}
			
			System.out.println();
			
		}
		
	}

}
