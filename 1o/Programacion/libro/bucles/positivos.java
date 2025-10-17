import java.util.Scanner;
public class positivos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero1;
		System.out.println("Introduzca un numero ");
		numero1=sc.nextInt();
		while(numero1 != 0) {
			if (numero1>0)
				System.out.println("Es positivo");
			else 
				System.out.println("Es negativo");
			
			System.out.println();
			System.out.println("Introduzca un numero ");
			numero1=sc.nextInt();
		}
	}   
}
