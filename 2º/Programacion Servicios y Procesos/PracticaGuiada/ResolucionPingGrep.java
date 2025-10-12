/**
 * @author Sergio Trillo Rodriguez
 */
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ResolucionPingGrep {
    public static void main(String[] args) {
        try {
            ProcessBuilder pbPing = new ProcessBuilder("ping", "www.google.es", "-c", "2");
            ProcessBuilder pbGrep = new ProcessBuilder("grep", "rtt");

            Process pPing = pbPing.start();
            Process pGrep = pbGrep.start();

            // Flujo desde ping hacia el padre
            Scanner pingOut = new Scanner(pPing.getInputStream());
            // Flujo del padre hacia grep
            PrintWriter haciaGrep = new PrintWriter(pGrep.getOutputStream(), true);

            // Envio línea a línea del ping hacia grep
            while (pingOut.hasNextLine()) {
                haciaGrep.println(pingOut.nextLine());
            }

            // Cierro flujo hacia grep
            haciaGrep.close();
            pingOut.close();

            // Recupero la salida del grep usando InputStream
            InputStream flujoGrep = pGrep.getInputStream();
            Scanner scGrep = new Scanner(flujoGrep);

            StringBuilder resultado = new StringBuilder();
            while (scGrep.hasNextLine()) {
                resultado.append(scGrep.nextLine()).append("\n");
            }
            scGrep.close();

            // Muestro la salida capturada
            System.out.println("Salida de grep capturada mediante pipe:");
            System.out.println(resultado);

            // Espero que los procesos terminen
            pPing.waitFor();
            pGrep.waitFor();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}