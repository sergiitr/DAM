/**
 * Ejercicio 2
 * @author Sergio Trillo Rodriguez
 */
import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class TRSergio2 {

    public static void main(String[] args) {
		//----------------------------------------------
		//    Declaración de variables y constantes
		//----------------------------------------------
		Scanner sc = new Scanner (System.in);
		// Variables de entrada
		final String nombre;
		double altura;
		
		// Variables de salida
		double estimacion1,estimacion2,estimacion3;
		double diferencia1,diferencia2,diferencia3,diferenciaMedia;
		
		
		//----------------------------------------------
		//               Entrada de datos 
		//----------------------------------------------
		/**
		 * Introducimos por pantalla nombre y apellidos
		 */
		System.out.println("Introduzca el nombre y la altura del profesor: ");
		nombre=sc.nextLine();
		altura=sc.nextDouble();
		
		/**
		 * Introducimos las 3 estimaciones
		 */
		System.out.println("Introduzca las 3 estimaciones: ");
		estimacion1=sc.nextDouble();
		estimacion2=sc.nextDouble();
		estimacion3=sc.nextDouble();
		
		//----------------------------------------------
		//                 Procesamiento 
		//----------------------------------------------
		/**
		 * Conseguimos las 3 diferencias
		 * Conseguimos la media de las 3 diferencias
		 */
		diferencia1=Math.abs(100*(altura-estimacion1));
		diferencia2=Math.abs(100*(altura-estimacion2));
		diferencia3=Math.abs(100*(altura-estimacion3));
		
		diferenciaMedia=(diferencia1+diferencia2+diferencia3)/3;
		
		
		/**
		 * Si todos los valores son positivos sale el mensaje, si alguna de las estimaciones o la altura es negativa, sale un mensaje de error, dado que una altura no puede ser negativa
		 */
		String solucion = (altura>=1 && estimacion1>=1 && estimacion3>=1 && estimacion3>=1 ) ? "El profesor "+nombre+" mide "+altura+"m. La diferencia de la 1a estimacion es de "+(int)diferencia1+"cm, la de la 2a estimacion es de "+(int)diferencia2+"cm y de la 3a estimacion es de "+(int)diferencia3+"cm. Por lo tanto, el error absoluto medio es de "+(float)diferenciaMedia+"cm" : "Valores no validos";
		//----------------------------------------------
		//              Salida de resultados 
		//----------------------------------------------
		System.out.println(solucion);
		
		System.out.println ("Fin del programa.");
	}
}
