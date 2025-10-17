import java.lang.Math;
import java.util.Scanner;
public class ejercicio8 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		final int notaCorrecta=5;
		final int notaIncorrecta=-1;
		final int notaBlanco=0;
		
		int cantidadPreguntasCorrectas;
		int cantidadPreguntasIncorrectas;
		int cantidadPreguntasBlanco;
		
		System.out.println("Introduce la cantidad de preguntas correctas, incorrectas y en blanco ");
		cantidadPreguntasCorrectas=sc.nextInt();
    	cantidadPreguntasIncorrectas=sc.nextInt();
    	cantidadPreguntasBlanco=sc.nextInt();
    	
		double notaFinal= (double) (cantidadPreguntasCorrectas*notaCorrecta+cantidadPreguntasIncorrectas*notaIncorrecta+cantidadPreguntasBlanco*notaBlanco)/(cantidadPreguntasCorrectas+cantidadPreguntasIncorrectas+cantidadPreguntasBlanco);
		
		System.out.println("La nota final es de: "+notaFinal);
	}
}
