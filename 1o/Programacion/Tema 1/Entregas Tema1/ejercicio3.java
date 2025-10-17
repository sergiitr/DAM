/*
 * Relacion 1
 * Ejercicio 3
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio3 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	final double IVA = 0.21;
    	final double descuento50e = 0.05;
    	final double descuento100e = 0.10;
				
		int cantEntradasAdulto,cantEntradasInfantiles;
		System.out.println("Introduce las cant de entradas de adulto");
		cantEntradasAdulto=sc.nextInt();
		
		System.out.println("Introduce las cant de entradas de nino");
		cantEntradasInfantiles=sc.nextInt();
		
		System.out.println("Se compraran "+cantEntradasAdulto+" entradas de adulto y "+cantEntradasInfantiles+" infantiles");
		
		
		double precioSinIVA = (double) (cantEntradasAdulto*15+cantEntradasInfantiles*10);
		
		System.out.println("El coste de las entradas antes de aplicar descuentos es de "+precioSinIVA+"€");
		double precioConDescuento;
		/**
		 * Si el precio no supera los 50€ no tiene descuento
		 * Si oscila entre 50 y 99.99€ tiene un 5% de descuento
		 * Si vale 100€ o mas tiene un 10% de descuento
		 */
		if (precioSinIVA<50) {
			System.out.println("No se aplica descuento");
			precioConDescuento = precioSinIVA;
		} else if (precioSinIVA>=50 && precioSinIVA<100) {
			System.out.println("Se aplicara un descuento del 5%");
			precioConDescuento = precioSinIVA-precioSinIVA*descuento50e;
		} else {
			System.out.println("Se aplicara un descuento del 10%");
			precioConDescuento = precioSinIVA-precioSinIVA*descuento100e;
		}
		System.out.println("El importe sin IVA incluido es de "+precioConDescuento+"€");
		
		/**
		 * Se le añade el IVA
		 */
		double precioConIVA;
		precioConIVA=precioConDescuento+precioConDescuento*IVA;
		
		System.out.println("El importe IVA incluido es de  "+precioConIVA+"€");
		System.out.println("La cantidad final a pagar por el cliente es de "+(int)precioConIVA+"€");
		System.out.println("Fin del programa");
	}
}
