
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String archivo = "apellidos.txt";
        String apellidos;
        BufferedReader bufferEntrada = null;
        Scanner scannerLectura = null;
        try {
            bufferEntrada = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = bufferEntrada.readLine()) != null) {
                String texto = "";
                scannerLectura = new Scanner(linea);
                while (scannerLectura.hasNextLine()) {
                    apellidos = scannerLectura.nextLine();
                    texto += apellidos + " ";
                }
                System.out.println(texto);
            }
        } catch (Exception e) {
            
        }

    }
}