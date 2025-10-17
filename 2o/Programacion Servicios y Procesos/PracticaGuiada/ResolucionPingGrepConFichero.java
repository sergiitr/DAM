/**
 * @author Sergio Trillo Rodriguez
 */
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class ResolucionPingGrepConFichero {
    public static void main(String[] args) {
        try {
            File fichero = new File("/tmp/salida.out");
            // Creo los procesos
            ProcessBuilder pbPing = new ProcessBuilder("ping", "www.google.es", "-c", "2");
            ProcessBuilder pbGrep = new ProcessBuilder("grep", "rtt");

            // Ping redirige salida al fichero
            pbPing.redirectOutput(fichero);
            Process pPing = pbPing.start();
            pPing.waitFor();

            // Grep lee desde el fichero
            pbGrep.redirectInput(fichero);
            Process pGrep = pbGrep.start();

            // Recupero la salida del grep mediante InputStream
            InputStream flujoGrep = pGrep.getInputStream();
            Scanner scGrep = new Scanner(flujoGrep);

            StringBuilder resultado = new StringBuilder();
            while (scGrep.hasNextLine()) {
                resultado.append(scGrep.nextLine()).append("\n");
            }
            scGrep.close();

            // Muestro la salida capturada
            System.out.println("Salida de grep capturada desde fichero:");
            System.out.println(resultado);

            pGrep.waitFor();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}