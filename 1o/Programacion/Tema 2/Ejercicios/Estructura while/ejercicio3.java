import java.util.Scanner;
public class ejercicio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabras="";
		
		while( palabras.toLowerCase().compareTo("salir") != 0 ) {
			System.out.println("Introduzca una palabra: ");
			palabras=sc.nextLine();
		}
	}
}
