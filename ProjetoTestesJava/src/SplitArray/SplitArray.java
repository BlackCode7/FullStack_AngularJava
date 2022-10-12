package SplitArray;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

	public static void main(String[] args) {

		// como destrinchar strings 
		String texto = " Anderson, curso java, 80, 70, 60, 50 ";
		
		String[] valorArray = texto.split(",");
		
		System.out.println(valorArray[0]);
		System.out.println(valorArray[1]);
		System.out.println(valorArray[2]);
		System.out.println(valorArray[3]);

		//Convertendo Array para lista		
		List<String> list = Arrays.asList(valorArray);
		
		for (String valoirString : list) {
			System.out.println(valoirString);
		}
		
		//Converter uma lista para Array
		String[] conversaoArray = list.toArray(new String[5]);
		System.out.println(conversaoArray);
		
		for( int pos = 0; pos < conversaoArray.length; pos++ ) {
			System.out.println(conversaoArray[pos]);
		}
		
		
		
		
	}

}
