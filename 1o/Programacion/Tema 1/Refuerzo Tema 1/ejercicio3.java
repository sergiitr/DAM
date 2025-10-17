/*
 * Refuerzo 1
 * Ejercicio 3
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio3 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int gb;
		System.out.println("Introduce el tamaño en GB");
		gb=sc.nextInt();
		
		int bits = gb*1024*1024*8;
				
		System.out.println(gb+"GB son equivalentes a "+bits+" bits");
	}
}
