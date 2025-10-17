import java.util.Scanner;
public class cantNegativos{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aux=0, contador=0;
       	int[] vector= new int[10];
       	
       	System.out.println("Introduzca 10 numeros:");
		for(int i=0; i<10; i++)
			vector[i]=sc.nextInt();
				
		for(int i=0; i<10; i++)
			if (vector[i] < 0)
				contador++;
		
		System.out.println("Se ha introducido una cantidad de "+contador+" numeros negativos");
	}
}