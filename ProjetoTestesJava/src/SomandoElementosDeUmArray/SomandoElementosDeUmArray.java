package SomandoElementosDeUmArray;

public class SomandoElementosDeUmArray {
	
	static int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
	static int total = 0;

	public static void main(String[] args) {
		
		somandoElementosDeUmArray(array, total);
		
		int[] arrayBarra = { 0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1 };

		System.out.println("Grade de distribui??o");
		
		//Para cada elemento do array, gera saida de uma barra do grafico
		for( int counter = 0; counter < arrayBarra.length; counter++ ) {
			
			// Gera a saida do r?tulo da berra
			if( counter == 10 ) 
				System.out.printf("%5d: ", 100);
			else 
				System.out.printf("%02d-%02d: ", counter*10, counter*10+9);	
			//Imprime a barra de asteristico
			for( int stars = 0; stars < arrayBarra[counter]; stars++ ) 
				System.out.println("#");
			
			System.out.println();
			
		}
		
		
		
	}

	public static void somandoElementosDeUmArray( int[] array2, int paramTotal ) {	
		for ( int counter = 0; counter < array2.length; counter++ ) {
			paramTotal += array2[counter];
		}		
		System.out.printf("Total o valor de cada elemento %d%n", paramTotal);
	}

}
