package ArrayList_PaulDeitel;

public class ArrayList_PaulDeitel_1 {

	public static void main(String[] args) {

		int[] array = { 32,32,4,59,87,84,671,2,54,813,74,05,63,418,64,50 };

		System.out.println("*****************");
		System.out.printf("%s%8s%n", "Index", "Counter");
		
		for( int coun=0; coun<array.length; coun++ ) {
			System.out.println("*****************");
			System.out.printf("%5d%8d%n",coun, array[coun]);
		}
		
	}

}
