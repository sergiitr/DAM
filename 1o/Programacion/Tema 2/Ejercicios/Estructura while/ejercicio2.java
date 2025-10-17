import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int contador=0, sumador=0,numero1=0;
		
		while(numero1>=0) {
			System.out.println("Introduzca un numero: ");
			numero1=sc.nextInt();
			if (numero1>=0){
				contador++;
				sumador+=numero1;
			}
		}
    	
    	double media = (double)sumador/contador;
    	System.out.println("La media es: "+media);
	}
}
