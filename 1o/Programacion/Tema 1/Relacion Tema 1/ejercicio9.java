import java.util.Scanner;
public class ejercicio9 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	// Variables
    	double r;
    	System.out.println("Introduzca el valor del radio");
    	r=sc.nextDouble();
    	if (r>0) {
        		final double PI = 3.14;
        		double resultado;
        		int area=1;
        		int longitud=2;
        		System.out.println("Que desea mostrar? Area (1) o longitud (2)?");
        		int valor=sc.nextInt();
        	if (valor==area) {
            	resultado=(PI*r*r);
            	System.out.println("El resultado del area es: "+resultado);
        	} else if (valor== longitud) {
            	resultado=(PI*r*2);
            	System.out.println("El resultado de la longitud es: "+resultado);
        	} else {
            		System.out.println("No se ha elegido la opcion correcta");
        	}
    	} else {
        		System.out.println("El radio es 0 o negativo");
    	}
	}
}
