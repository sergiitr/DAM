import java.util.Random;
import java.util.Scanner;

public class wordle {
    public static void main(String[] args) {
        Random rd=new Random();
        Scanner sc=new Scanner(System.in);

        String introducirPalabra;
        int vidas=5;
        boolean correcto=false;  // Inicializamos en false, ya que no se ha acertado al principio.

        String[] vectorPalabrasOcultas={"array", "programacion", "vector", "bucles", "clases"};
        int aleatorio=rd.nextInt(0, vectorPalabrasOcultas.length);
        String palabraOcultaString=vectorPalabrasOcultas[aleatorio];
        char[] palabraOculta=new char[palabraOcultaString.length()];

        // Inicializamos la palabra oculta con guiones bajos
        for (int i=0; i<palabraOculta.length; i++) 
            palabraOculta[i]='_';
        
        System.out.println("Huecos Palabra oculta: ");
        for (int i=0; i<palabraOculta.length; i++) 
            System.out.print(palabraOculta[i]);
        System.out.println();
        // Aquí es donde entra el bucle principal
        do {
            int contAux=0;
            System.out.println("Te quedan " + vidas + " intentos");
            // Bucle para ingresar palabra hasta que tenga la longitud correcta
            do {
                System.out.print("Introduzca una palabra: ");
                introducirPalabra=sc.nextLine();
            } while (introducirPalabra.length() != palabraOculta.length);

            // Aquí es donde verificamos las letras
            for (int i=0; i<palabraOculta.length; i++) {
                if (palabraOcultaString.charAt(i) == introducirPalabra.charAt(i))
                    palabraOculta[i]=introducirPalabra.charAt(i);
                System.out.print(palabraOculta[i]);
            }
            System.out.println();

            // Verificamos si la palabra ha sido completamente adivinada
            contAux=0;
            for (int i=0; i<palabraOculta.length; i++) {
                if (palabraOculta[i] == '_')
                    contAux++;
            }

            // Si no quedan guiones bajos, es que se ha adivinado la palabra
            if (contAux == 0) {
                System.out.println("Has acertado la palabra!");
                correcto=true;
            }

            // Reducir vidas si la palabra no ha sido completamente adivinada
            if (contAux>0) {
                vidas--;
                if (vidas == 0) 
                    System.out.println("Se te acabaron las vidas. La palabra era: " + palabraOcultaString);
            }
        } while (vidas>0 && !correcto); 
    }
}
