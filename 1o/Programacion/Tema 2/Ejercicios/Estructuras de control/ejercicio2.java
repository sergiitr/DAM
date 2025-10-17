import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int anio;
		System.out.println("Introduzca el año");
		anio=sc.nextInt();
    	
    	if (anio%4==0 && anio%100==0 && anio%400==0)
			System.out.println("Año bisiesto");
		else if (anio%4==0 && anio%100==0 && anio%400!=0)
			System.out.println("Año no bisiesto");
		else if (anio%4==0)
			System.out.println("Año bisiesto");
		else
			System.out.println("No bisiesto");
		System.out.println("Fin del programa");
	}   
}
