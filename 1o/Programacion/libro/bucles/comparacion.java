import java.util.Scanner;
public class comparacion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero1,intento,contador=1;
		System.out.println("Introduzca el numero secreto ");
		numero1=sc.nextInt();
		System.out.println("Introduzca un numero ");
		intento=sc.nextInt();
		while(numero1 != intento) {
			System.out.println("Has fallado");
			contador++;
			System.out.println("Introduzca un numero ");
			intento=sc.nextInt();
		}
		System.out.println("Has acertado");
		System.out.println("Has tardado "+contador+" intentos.");
	}   
}
