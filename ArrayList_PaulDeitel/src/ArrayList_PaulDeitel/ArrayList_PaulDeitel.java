package ArrayList_PaulDeitel;

public class ArrayList_PaulDeitel {

	public static void main(String[] args) {
		
		boolean booleano = true;
		int[] array = new int[12];
		int[] c; //Declara a variável de array
		c = new int[12]; //Cria o array; atribui à variável de array
		String b[] = new String[20]; //Cria array b, transforma para string
		
		if( booleano == true ) {
			
			for ( int couunt=1; couunt < array.length; couunt++ ) {
				System.out.printf("%5d%8d%n",couunt, array[couunt]);
			}
			
			for (int counter = 0; counter < array.length; counter++) {
				System.out.printf("%5d%8d%n", counter, array[counter]);
			}			
			
			for( int string=0; string < b.length; string++ ) {
				System.out.println(string);
			}
			
			for( int string = 0; string < c.length; string++ ) {
				System.out.println(string + "Array string b" + c[string]);
			}
		} else {
			System.out.println(b);
			System.out.println(c);
		}
		
		

	}

}
