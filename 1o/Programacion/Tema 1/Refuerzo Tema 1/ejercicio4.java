/*
 * Refuerzo 1
 * Ejercicio 4
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio4 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int mayores,menores;
		System.out.println("Introduce la cantidad de alumnos mayores de 20 años");
		mayores=sc.nextInt();
		System.out.println("Introduce la cantidad de alumnos menores de 20 años");
		menores=sc.nextInt();
		
		final int cantidadAlumnos = mayores+menores;
		
		double porcMayores = (double)mayores/cantidadAlumnos*100;
		double porcMenores = (double)menores/cantidadAlumnos*100;
				
		System.out.println("El porcentaje de mayores de 20 años es de "+porcMayores+"%");
		System.out.println("El porcentaje de menores de 20 años es de "+porcMenores+"%");
	}
}
