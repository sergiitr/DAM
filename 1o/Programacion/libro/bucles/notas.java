import java.util.Scanner;
public class notas{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cantAprubados=0, cantSuspensos=0, cantCondicionales=0;
       	double[] vector= new double[6];
       	
		/**
		 * Vamos introduciendo las 6 notas
		 */
       	System.out.println("Introduzca 6 notas:");
		for(int i=0; i<6; i++){
			do {
				System.out.print("Introduzca la "+(i+1)+" nota :");
				vector[i]=sc.nextDouble();
			} while(vector[i]<0);
		}

		/**
		 * Vamos comparando las 6 notas viendo si estan aprobados, suspensos, o suspensos condicionales
		 * Cada condicion, vamos aumentando en 1 
		 */
		for(int i=0; i<6; i++){
			if (vector[i]>=5)
				cantAprubados++;
			else if (vector[i]>=4 && vector[i]<5)
				cantCondicionales++;
			else
				cantSuspensos++;
		}
		
		/**
		 * Mostramos la cantidad de cada nota
		 */
		System.out.println("Aprobados: "+cantAprubados);
		System.out.println("Condicionales: "+cantCondicionales);
		System.out.println("Suspenso: "+cantSuspensos);
	}
}
