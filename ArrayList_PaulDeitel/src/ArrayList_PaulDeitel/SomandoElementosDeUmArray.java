package ArrayList_PaulDeitel;

public class SomandoElementosDeUmArray {

	public static void main(String[] args) {

		// Cria um array de elementos
		int[] array = { 12,31,23,24,13,45,75,67,45,78,99,87,21,43 };

		// Criando um array vazio para receber a contagem
		int total = 0;
		
		// Iterando sobre o array e somando os elementos
		for ( int counter = 0; counter < array.length; counter++ ) {
			total += array[counter];
		}
		
		System.out.printf("Total de elementos somados no array: %d%n",total);
	
	}

}
