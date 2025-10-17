/*
 * Refuerzo 1
 * Ejercicio 4
 * Sergio Trillo Rodriguez
 */

import java.lang.Math;
import java.util.Scanner;
public class ejercicio5 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int dinero;
		System.out.println("Introduzca la cantidad de dinero (en euros): ");
		dinero=sc.nextInt();
		
		int billete500,billete200,billete100,billete50,billete20,billete10,billete5,moneda2,moneda1;
		
		billete500=(int)dinero/500;
		dinero=dinero-billete500*500;
		
		billete200=(int)dinero/200;
		dinero=dinero-billete200*200;
		
		billete100=(int)dinero/100;
		dinero=dinero-billete100*100;
		
		billete50=(int)dinero/50;
		dinero=dinero-billete50*50;
		
		billete20=(int)dinero/20;
		dinero=dinero-billete20*20;
		
		billete10=(int)dinero/10;
		dinero=dinero-billete10*10;
		
		billete5=(int)dinero/5;
		dinero=dinero-billete5*5;
		
		moneda2=(int)dinero/2;
		dinero=dinero-moneda2*2;
		
		moneda1=(int)dinero/1;
		dinero=dinero-moneda1*1;
		
		System.out.println("----CANTIDAD DE BILLETES----");
		System.out.println("Billetes 500:"+billete500);
		System.out.println("Billetes 200:"+billete200);
		System.out.println("Billetes 100:"+billete100);
		System.out.println("Billetes 50:"+billete50);
		System.out.println("Billetes 20:"+billete20);
		System.out.println("Billetes 10:"+billete10);
		System.out.println("Billetes 5:"+billete5);
		System.out.println("Monedas 2:"+moneda2);
		System.out.println("Monedas 1:"+moneda1);
	}
}
