import java.util.Scanner;
public class ejercicio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aforoMaximo, entradasVendidas;
		double precioEntrada, recaudacion=0.0;
		System.out.println("Introduzca el aforo maximo: ");
		aforoMaximo=sc.nextInt();
		
		System.out.println("Introduzca el precio de la entrada: ");
		precioEntrada=sc.nextDouble();
		
		System.out.println("Introduzca las entradas vendidas: ");
		entradasVendidas=sc.nextInt();
		
		if (entradasVendidas < aforoMaximo*0.2)
			System.out.println("Se cancela el evento, se le devolvera el dinero a los que hayan comprado las entradas");
		else if (entradasVendidas >= aforoMaximo*0.2 && entradasVendidas < aforoMaximo*0.5){
			System.out.println("Entradas a un 20% de descuento");
			recaudacion=entradasVendidas*precioEntrada*0.8;
		} else if (entradasVendidas > aforoMaximo) {
			System.out.println("Se han vendido mas entradas de la cuenta, las "+aforoMaximo+" primeras personas al llegar al recinto entran, el resto se le devuelve el dinero");
			recaudacion=aforoMaximo*precioEntrada;
		} else
			recaudacion=entradasVendidas*precioEntrada;
		
		System.out.println("La recaudación del evento es: "+recaudacion+"€");
	}
}
