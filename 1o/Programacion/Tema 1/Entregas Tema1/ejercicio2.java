/*
 * Relacion 1
 * Ejercicio 2
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	final double cantidadTotal = 2000;
    	double cantidadEmbalse;
				
		System.out.println("Introduce la cantidad del embalse: ");
		cantidadEmbalse=sc.nextDouble();
		
		double cantidadRestante = cantidadTotal - cantidadEmbalse;
		double porcentaceLleno = (cantidadEmbalse/cantidadTotal)*100;
		System.out.println("Faltan "+cantidadRestante+" hectometros cubicos para llenar completamente el embalse");
		System.out.println("El embalse está a un "+porcentaceLleno+"% de su capacidad maxima");
		
		/**
		 * Si tiene un 95% de ocupacion o mas, se reduce aun 10%
		 * En caso contrario se mantiene
		 */
		if(porcentaceLleno>=95) {
			double vaciado=cantidadEmbalse*0.1;
			System.out.println("Se ha realizado una liberacion del 10% vaciando un total de "+vaciado+" hectometros cubicos");
			double cantFinal=cantidadEmbalse-vaciado;
			double porcFinal=cantFinal/cantidadTotal*100;
			System.out.println("En el embalse quedan ahora "+cantFinal+" hectómetros cúbicos, que representan un "+porcFinal+"% de su capacidad maxima");
		} else 
			System.out.println("No hace falta liberar agua");
		
		System.out.println("Fin del programa");
	}
}
