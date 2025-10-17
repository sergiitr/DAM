
/**
 * @author Sergio Trillo Rodriguez
 */
import java.io.*;
import java.util.Scanner;

public class ResolucionPingGrepConFichero {
    public static void main(String[] args) {
        File archivoSalida = new File("/tmp/salida.out");
        
        ProcessBuilder pbPing = new ProcessBuilder("ping", "www.google.es", "-c2");
        ProcessBuilder pbGrep = new ProcessBuilder("grep", "rtt");
        pbPing.redirectOutput(archivoSalida);
        
        try {
            Process processPing = pbPing.start();
            processPing.waitFor();
            Process processGrep = pbGrep.start();
            Scanner inDesdeGrep = new Scanner(processGrep.getInputStream());
            while (inDesdeGrep.hasNextLine())
                System.out.println(inDesdeGrep.nextLine());
            
            inDesdeGrep.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
