package Matrizes;

public class Matrizes {

	public static void main(String[] args) {
	
		/* Aqui � um array */
		int notasArray[] = new int[1];
		
		/* Aqui � uma matriz */
		int notas[][] = new int[3][3];
		
		notas[0][0] = 80;
		notas[0][1] = 90;
		notas[0][2] = 95;
		
		notas[1][0] = 41;
		notas[1][1] = 50;
		notas[1][2] = 35;
		
		notas[2][0] = 12;
		notas[2][1] = 16;
		notas[2][2] = 23;
		
		//Lendo as linhas da matriz
		for( int poslinha = 0; poslinha < notas.length; poslinha++ ) {
			System.out.println(notas[poslinha][1]);
			//Lendo as colunas
			for( int poscoluna = 0; poscoluna < notas[poslinha].length; poscoluna++ ) {
				System.out.println(notas[poslinha][poscoluna]);
			}			
		}
		
		System.out.println(notas);
		
	}
	
}
