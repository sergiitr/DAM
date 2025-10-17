/*
 * Refuerzo 1
 * Ejercicio 1
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio1 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		double base, altura;
				
		System.out.println("Pon la base y la altura: ");
		base=sc.nextDouble();
		altura=sc.nextDouble();
		
			
		//Area
		double area = (base*altura)/2;
		
		//Perimetro
		double hipotenusa = Math.sqrt(base*base+altura*altura);
		double perimetro = base+altura+hipotenusa;
		
		//Resultado
		System.out.println("Area: "+area);
		System.out.println("Perimetro: "+perimetro);
	}
}
