import java.util.Scanner;
public class ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero1,numero2;
		System.out.println("Introduzca dos numeros");
		numero1=sc.nextInt();
    	numero2=sc.nextInt();
    	
    	int opciones;
    	System.out.println("Introduzca una opcion (1-5)");
		opciones=sc.nextInt();
    	
    	if (opciones==1) {
			int suma = numero1+numero2;
			System.out.println("La suma es: "+suma);
		} else if (opciones==2) {
			int resta = numero1-numero2;
			System.out.println("La resta es: "+resta);
		} else if (opciones==3) {
			double division = (double)numero1/numero2;
			System.out.println("La division es: "+division);
		} else if (opciones==4) {
			int multiplicacion = numero1*numero2;
			System.out.println("La multiplicacion es: "+multiplicacion);
		} else if (opciones==5)
			System.out.println("Salir");
		else
			System.out.println(opciones+" fuera de rango");
		System.out.println("Fin del programa");
	}   
}
