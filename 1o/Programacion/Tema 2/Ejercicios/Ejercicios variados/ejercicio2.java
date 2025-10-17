import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double resultado;
		final double PI=3.14;
		String eleccion;
		System.out.println("Elija eleccion para calcular el area");
		eleccion = sc.nextLine();
		
		switch(eleccion.toLowerCase()) {
			case "circulo":
				double radio;
				System.out.println("Introduzca el radio");
				radio = sc.nextDouble();
				resultado=2*PI*radio;
				System.out.println("El area del circulo es: "+resultado);
				break;
			case "cuadrado":
				double lado;
				System.out.println("Introduzca el lado");
				lado = sc.nextDouble();
				resultado=lado*lado;
				System.out.println("El area del cuadrado es: "+resultado);
				break;
		}
	}
}
