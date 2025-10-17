/**
 * Ejercicio 1
 * @author Sergio Trillo Rodriguez
 */
import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class TRSergio1 {
    public static void main(String[] args) {
		//----------------------------------------------
		//    Declaración de variables y constantes
		//----------------------------------------------
        Scanner sc = new Scanner (System.in);
        // Variables constantes
        final double G=9.8;
        
        // Variables de entrada
        int h;
        // Variables de salida
		short t;
		long v;
		
		//----------------------------------------------
		//               Entrada de datos 
		//----------------------------------------------
		/**
		 * Introducimos el valor de la altura
		 */
		System.out.println("Introduzca el valor de la altura");
		h = sc.nextInt();
		
		//----------------------------------------------
		//                 Procesamiento 
		//----------------------------------------------
		/**
		 * Si la altura es positiva, guardamos el valor que salga de la raiz en t y en v
		 * Si la altura es negativa, guardaremos un valor auxiliar (-1) para alertar que la altura es negativa
		 */
		t = (h>=0) ? (short)Math.sqrt((2*h)/G) : (-1);
		v = (h>=0) ? (int)Math.sqrt(2*h*G)   : (-1);
		
		String resultado = (t>-1 && v>-1) ? "Un cuerpo que cae desde "+h+" metros tarda "+t+ " segundos en caer y llega al suelo con una velocidad de "+v+"m/s" : "Altura negativa";
		
		//----------------------------------------------
		//              Salida de resultados 
		//----------------------------------------------
		System.out.println(resultado);
        
        System.out.println ("Fin del programa.");           
    }
}
