import java.lang.Math;
import java.util.Scanner;
public class ejercicio7 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int varA,varB,varAux;
		
		System.out.println("Introduce dos valores ");
    	varA=sc.nextInt();
    	varB=sc.nextInt();
		
		varAux = varA;
		varA=varB;
		varB=varAux;
		
		System.out.println("Los valores intercambiados son: "+varA+"  -  "+varB);
	}
}
