import java.util.Scanner;
public class ejercicio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	for (int i=1; i<=100; i++) 
			if (i%3==0 && i%5==0) 
				System.out.println("El numero "+i+" es divisible entre 3 y entre 5 a la vez");
	}
}
