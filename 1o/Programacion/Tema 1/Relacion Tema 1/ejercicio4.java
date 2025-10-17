import java.lang.Math;
import java.util.Scanner;
public class ejercicio4 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	double descuento;
    	System.out.println("Introduce el descuento (entre 0 y 1): ");
    	descuento=sc.nextDouble();
    	if (descuento <= 1 && descuento >= 0) {
			double precio;
			System.out.println("Introduce la cantidad: ");
			precio=sc.nextDouble();
			
			double precioFinal = precio-precio*descuento;
			System.out.println("El precio despues del descuento es "+precioFinal);
    	} else
			System.out.println("Descuento no valido");
	}   
}
