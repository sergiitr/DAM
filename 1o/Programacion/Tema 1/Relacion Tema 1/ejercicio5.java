import java.lang.Math;
import java.util.Scanner;
public class ejercicio5 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		double sueldoBase;
    	System.out.println("Introduce el sueldo base ");
    	sueldoBase=sc.nextDouble();
    	
    	final double comisiones = 0.3;
    	double sueldoTotal=sueldoBase+sueldoBase*comisiones;
    	
    	System.out.println("El sueldo total es: "+sueldoTotal);
	}
}
