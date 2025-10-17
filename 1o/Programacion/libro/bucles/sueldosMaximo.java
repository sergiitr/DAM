import java.util.Scanner;
public class sueldosMaximo{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, aux=0;

		/**
		 * Sera el numero del vector
		 */
		System.out.println("Introduzca el numero de salarios que quieras introducir ");
		n=sc.nextInt();
		int[] vector= new int[n];
       	
		/**
		 * Sacamos por pantalla todos los salarios
		 */
       	System.out.println("Introduzca los "+n+" salarios: ");
		for(int i=0; i<n; i++)
			vector[i]=sc.nextInt();
		

		/**
		 * Comparamos todos los salarios
		 * Cada vez q haya un maximo lo guardaremos en un auxiliar
		 */
		for(int i=0; i<n; i++)
			if (vector[i] >= aux)
				aux = vector[i];
		
		/**
		 * Mostramos por pantalla el salario maximo
		 */
		System.out.println("El salario mas alto es: "+aux+"€");
	}
}
