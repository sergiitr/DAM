/**
 * 
 * Ejercicio 3
 * 
 * @author Sergio Trillo Rodriguez
 */
import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class TRSergio3 {
    public static void main(String[] args) {
		//----------------------------------------------
		//    Declaración de variables y constantes
		//----------------------------------------------
		Scanner sc = new Scanner (System.in);
		// Variables constantes
		final int suma=180;
		// Variables de salida
		int angulo1,angulo2,angulo3;
		
		/**
		 * Se le asigna un angulo random a angulo1 y a angulo2
		 */
		angulo1 = new java.util.Random().nextInt(180)+1;
		angulo2 = new java.util.Random().nextInt(180)+1;
		
		//----------------------------------------------
		//                 Procesamiento 
		//----------------------------------------------
		/**
		 * Conseguimos el valor de angulo3 haciendo la suma de los otros dos angulos, y éstos restandoselos a 180
		 */
		angulo3 = suma-(angulo1+angulo2);
		
		//----------------------------------------------
		//              Salida de resultados 
		//----------------------------------------------
		/**
		 * Si el angulo 3 es negativo o 0, no hay triangulo
		 * Si el angulo 3 es positivo y mayor de 0, muestra los 3 angulos del triangulo
		 */
		String resultado = (angulo3<=0) ? "Con los angulos "+angulo1+" angulos y "+angulo2+" angulos no se puede formar un triangulo":"Angulo1: "+angulo1+" grados \\ Angulo 2: "+angulo2+" grados \\ Angulo 3: "+angulo3+" grados";
		System.out.println(resultado);
    }
}
