import java.lang.Math;
import java.util.Scanner;
public class ejercicio3 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	final double descuento=0.15;
    	double precio;
    	System.out.println("Introduce la cantidad: ");
    	precio=sc.nextDouble();
    	
    	double precioFinal = precio-precio*descuento;
    	System.out.println("El precio despues del descuento es "+precioFinal+"€");
	}   
}
