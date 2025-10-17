import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "juramento.txt";
        try {
            Scanner sc = new Scanner(System.in);
            FileWriter escritor = new FileWriter(nombreArchivo);
            BufferedWriter bufferEscritor = new BufferedWriter(escritor);
            char caracter;
            do { 
                caracter = sc.nextLine().charAt(0);
                bufferEscritor.write(caracter);
            } while (caracter != ',');
            
            // Escribir un salto de línea en el archivo
            bufferEscritor.newLine();
            String cadenaLinea2;
            do {
                cadenaLinea2 = sc.nextLine();
                // Escribir un carácter en el archivo
                bufferEscritor.write(cadenaLinea2);
                if (cadenaLinea2.charAt(cadenaLinea2.length()-1) == ',')
                    bufferEscritor.newLine();
            } while (cadenaLinea2.charAt(cadenaLinea2.length()-1) != '.');
            
            bufferEscritor.newLine();
            // Vaciar el búfer de salida, escribiendo en el archivo los caracteres pendientes
            bufferEscritor.flush();
            // Cerrar el BufferedWriter
            bufferEscritor.close(); // iría en el bloque finally
            System.out.println("Texto añadido al archivo correctamente.");
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    } 
}
