import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String texto = "";
        FileReader in = null;
        String rutaArchivo = "C:\\Users\\usuario\\Desktop\\Programacion\\Tema 7\\Teoria\\ejemplo2\\texto.txt";
        
        try {
            in = new FileReader(rutaArchivo);
            int caracter;
            while ((caracter = in.read()) != -1) { 
                texto += ((char) caracter);
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el archivo: " + ex.getMessage());
                }
            }
        }
        String[] cantPalabras;
        cantPalabras = texto.split(" ");

        System.out.println("Hay "+cantPalabras.length+" palabras");

        String[] cantLineas;
        cantLineas = texto.split("\n");

        System.out.println("Hay "+cantLineas.length+" lineas");
    }
}
