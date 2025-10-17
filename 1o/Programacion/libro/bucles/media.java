import java.util.Scanner;
public class media {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		/**
		 * Introducimos los numeros del vector
		 */
		System.out.println("Introduzca la cantidad de numeros que quieras introducir: ");
		n=sc.nextInt();
		
		int[] vector = new int[n];
		int cantPositivos=0, cantNegativos=0, cant0=0;
		
		System.out.println("Introduzca "+n+" numeros");
		
		/**
		 * Metemos los numeros en el vector
		 */
		for (int i=0;i<n;i++)
			vector[i]=sc.nextInt();
		
		/**
		 * Comparamos cada posicion del vector, y vemos si es positivo, negativo, ó 0
		 */
		for (int i=0;i<n;i++) {
			if(vector[i]>0)		
				cantPositivos++;
			else if(vector[i]==0)
				cant0++;
			else
				cantNegativos++;
		}
		
		/**
		 * Mostramos la cantidad de positivos, negativos y 0
		 */
		System.out.println("Cantidad positivos: "+cantPositivos);
		System.out.println("Cantidad 0: "+cant0);
		System.out.println("Cantidad negativos: "+cantNegativos);
	}   
}

