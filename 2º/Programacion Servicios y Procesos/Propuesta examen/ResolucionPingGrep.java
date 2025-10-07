
/**
 * @author Sergio Trillo Rodriguez 
 */
import java.io.*;
import java.util.Scanner;

public class ResolucionPingGrep {
    public static void main(String[] args) {
        try {
            ProcessBuilder pbPing = new ProcessBuilder("ping", "www.google.es", "-c2");
            ProcessBuilder pbGrep = new ProcessBuilder("grep", "rtt");
            Process processPing = pbPing.start();
            Process processGrep = pbGrep.start();

            Scanner scannerPing = new Scanner(processPing.getInputStream());
            PrintWriter outParaGrep = new PrintWriter(processGrep.getOutputStream());
            while (scannerPing.hasNextLine()) {
                String linea = scannerPing.nextLine();
                outParaGrep.println(linea);
            }
            outParaGrep.close();

            Scanner inDesdeGrep = new Scanner(processGrep.getInputStream());
            while (inDesdeGrep.hasNextLine())
                System.out.println(inDesdeGrep.nextLine());

            scannerPing.close();
            inDesdeGrep.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
