import java.util.Scanner;
public class ejercicio4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	int cantFilas;
       	
       	System.out.println("Introduzca el numero de lineas: ");
       	cantFilas=sc.nextInt();
       	
       	
       	for (int i=0; i<=cantFilas; i++) {
			for (int k=0; k<i; k++) 
				System.out.print('*');
			System.out.println();
		}
	}
}
