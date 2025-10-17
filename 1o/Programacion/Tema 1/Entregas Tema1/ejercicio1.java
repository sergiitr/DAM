/*
 * Ejercicio 1
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio1 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		String palabra1, palabra2, palabra3;
				
		System.out.println("Escribe 3 palabras: ");
		palabra1=sc.nextLine();
		palabra2=sc.nextLine();
		palabra3=sc.nextLine();	
		
			
		String mensajeSalida=(palabra2.toLowerCase().charAt(0) ==palabra1.toLowerCase().charAt(palabra1.length()-1) && palabra3.toLowerCase().charAt(0) ==palabra2.toLowerCase().charAt(palabra2.length()-1) && palabra1.toLowerCase().charAt(0) ==palabra3.toLowerCase().charAt(palabra3.length()-1)) ? "Las palabras son circulares" : "Las palabras NO son circulares";
		System.out.println("El mensaje de salida es: "+mensajeSalida);
	}
}
