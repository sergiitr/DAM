import java.lang.Math;
import java.util.Scanner;
public class ejercicio6 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		double parcial1,parcial2,parcial3;
		System.out.println("Introduce la nota de los 3 parciaes ");
    	parcial1=sc.nextDouble();
    	parcial2=sc.nextDouble();
    	parcial3=sc.nextDouble();
    	
    	double totalParciales=((parcial1+parcial2+parcial3)/3)*0.55;
    	
    	double examenFinal;
    	System.out.println("Introduce la nota del final ");
    	examenFinal=sc.nextDouble();
    	
    	examenFinal = examenFinal*0.3;
    	
    	double trabajoFinal;
    	System.out.println("Introduce la nota del final ");
    	trabajoFinal=sc.nextDouble();
    	
    	trabajoFinal = trabajoFinal*0.15;
    	
    	
    	double notaFinal=totalParciales+examenFinal+trabajoFinal;
    	
    	System.out.println("El nota final es: "+notaFinal);
	}
}
