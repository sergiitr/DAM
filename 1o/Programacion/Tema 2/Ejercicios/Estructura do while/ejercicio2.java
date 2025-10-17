/**
 * Ver si la contraseña es la misma o no
 * @author Sergio Trillo
 */
import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String contrasena;
		final String parametro="miContrasena";
		int i=1;
		/**
		 * Se hace el bucle hasta que la contraseña sea igual o los intentos lleguen a 3
		 */
		do {
			System.out.println("Introduzca una contraseña ");
			contrasena=sc.nextLine();
			if (contrasena.equals(parametro))
				System.out.println("La contraseña es correcta");
			else{
				System.out.println("Contraseña incorrecta");
				i++;
			}
		} while (!contrasena.equals(parametro) && i==3);
		/**
		 * Si se llega a los 3 intentos, se muestra el mensaje de que se ha salido por bloqueo
		 */
		if (i==3)
			System.out.println("Se ha intentado 3 veces, se ha bloqueado");
	}
}
