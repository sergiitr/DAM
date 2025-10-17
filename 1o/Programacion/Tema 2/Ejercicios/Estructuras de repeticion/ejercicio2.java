import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero, resultado=1, aux;
		System.out.println("Introduzca un numero");
		numero=sc.nextInt();
    	
    	System.out.println("La tabla de multiplicar del "+numero+" es:");
    	for (int i=0; i<=10; i++) {
			aux=i*numero;
			System.out.println(numero+"x"+i+"="+aux);
		}
	}
}
