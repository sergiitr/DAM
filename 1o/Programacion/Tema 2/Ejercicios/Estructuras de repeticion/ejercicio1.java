import java.util.Scanner;
public class ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long numero, resultado=1;
		System.out.println("Introduzca un numero");
		numero=sc.nextLong();
    	if (numero<=0)
			System.out.println("No se puede hacer el factorial de "+numero);
		else {
			for (long i=numero; i>=1; i--)
				resultado=resultado*i;
			System.out.println("El factorial de "+numero+" es "+resultado);
		}
	}
}

