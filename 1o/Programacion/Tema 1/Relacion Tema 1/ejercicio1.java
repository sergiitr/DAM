import java.util.Scanner;

public class ejercicio1 {
      public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	// Variables
    	double a = 1;
    	double b = 4;
    	double c = 1;
		
		System.out.println("Introduzca los 3 valores");
		a=sc.nextDouble();
    	b=sc.nextDouble();
    	c=sc.nextDouble();
    	
    	double media = (a+b+c)/3;
		System.out.println("La media es: "+media);
   	 }
}
