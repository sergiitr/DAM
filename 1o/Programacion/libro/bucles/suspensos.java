import java.util.Scanner;
public class suspensos{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aux=0, contador=0;
       	int[] vector= new int[5];
       	
       	System.out.println("Introduzca 5 calificaciones:");
		for(int i=0; i<5; i++)
			vector[i]=sc.nextInt();
				
		for(int i=0; i<5; i++)
			if (vector[i] < 5)
				contador++;
		
		if (contador >= 1)
			System.out.println("Hay "+contador+" suspensos que equivale a un "+(contador*100/5)+"%");
		else
			System.out.println("No hay suspensos");
	}
}
