import java.util.Scanner;
public class alturas{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int contadorAlturas=0, contadorEdad=0, contadorAltos=0, contadorMayoresEdad=0;
       	int[] v_alturas = new int[5];
       	int[] v_edad = new int[5];
       	
		/**
		 * Introducimos las alturas en el vector
		 */
       	System.out.println("Introduzca 5 alturas (en cms):");
		for(int i=0; i<5; i++)
			v_alturas[i]=sc.nextInt();
		
		/**
		 * Introducimos las edades en el vector
		 */
		System.out.println("Introduzca sus 5 edades:");
		for(int i=0; i<5; i++)
			v_edad[i]=sc.nextInt();
		
		for(int i=0; i<5; i++) {
			contadorAlturas+=v_alturas[i]; 	// Cada altura la introducimos en un auxiliar para despues la media
			contadorEdad+=v_edad[i];		// Cada edad la introducimos en un auxiliar para despues la media
			if (v_alturas[i]>=175)
				contadorAltos+=1;			// Sumamos los mas altos de 1.75m en el auxiliar
			if (v_edad[i]>=18)
				contadorMayoresEdad+=1;		// Sumamos los mayores de edad en este auxiliar
		}
		System.out.println("La edad media es "+(double)contadorEdad/5+" y la altura media es "+(double)(contadorAlturas/5)/100+"m");
		System.out.println("Hay "+contadorMayoresEdad+ " mayores de edad");
		System.out.println("Hay "+contadorAltos+ " que miden mas de 1.75");
	}
}
