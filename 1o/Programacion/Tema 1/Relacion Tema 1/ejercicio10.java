import java.util.Scanner;

public class ejercicio10 {
      public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	// Variables
    	double a = 1;
    	double b = 4;
    	double c = 1;
   	 
    	// Calculamos el valor de la raiz
    	double valorRaiz = Math.sqrt((b*b)-(4*a*c));
   	 
    	if (valorRaiz>0) {
        	if (a !=0) {
            	double x  = (-b+valorRaiz)/(2*a);
            	double x2 = (-b-valorRaiz)/(2*a);
            	System.out.println("Valor1: "+x);
            	System.out.println("Valor2: "+x2);
        	} else
            	System.out.println("El divisor es 0, no se puede dividir");
    	} else
        	System.out.println("El valor de la raiz es negativa, por tanto no hay solucion");
      }
}
