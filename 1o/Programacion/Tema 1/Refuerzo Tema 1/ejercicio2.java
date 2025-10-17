/*
 * Refuerzo 1
 * Ejercicio 2
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		double consumo,precioGasolina,kms;
		System.out.println("Introduce el consumo del coche");
		consumo=sc.nextDouble();
		
		System.out.println("Introduce el precio de la gasolina");
		precioGasolina=sc.nextDouble();
		
		System.out.println("Cuantos km necesita hacer");
		kms=sc.nextDouble();
		
		double precioTrayecto= kms*(consumo/100)*precioGasolina;
				
		System.out.println("El precio del trayecto es: "+precioTrayecto+"€");
	}
}
