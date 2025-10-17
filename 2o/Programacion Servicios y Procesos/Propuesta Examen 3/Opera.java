/**
 * @author Sergio Trillo Rodriguez
 */
import java.io.*;
import java.util.Scanner;

public class Opera {
    public static void main(String[] args) {
        try {
            // --- 1. Compilar RealizaOperacion.java ---
            ProcessBuilder pbCompile = new ProcessBuilder("javac", "RealizaOperacion.java");
            pbCompile.redirectErrorStream(true);
            Process procCompile = pbCompile.start();
            BufferedReader compileReader = new BufferedReader(new InputStreamReader(procCompile.getInputStream()));
            String line;
            while ((line = compileReader.readLine()) != null) 
                System.out.println(line);
            int compileExit = procCompile.waitFor();
            if (compileExit == 0) {
                // --- 2. Crear el jar ---
                ProcessBuilder pbJar = new ProcessBuilder("jar", "cfe", "RealizaOperacion.jar", "RealizaOperacion", "RealizaOperacion.class"  );
                pbJar.redirectErrorStream(true);
                Process procJar = pbJar.start();
                BufferedReader jarReader = new BufferedReader(new InputStreamReader(procJar.getInputStream()));
                while ((line = jarReader.readLine()) != null) 
                    System.out.println(line);
                int jarExit = procJar.waitFor();
                if (jarExit == 0) {
                    // --- 3. Leer operaciones hasta línea vacía ---
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Introduce operaciones (ejemplo: ( + 3 5 )). Enter vacío para terminar:");

                    boolean continuar = true;
                    while (continuar) {
                        System.out.print("> ");
                        String operacion = sc.nextLine().trim();
                        if (operacion.isEmpty()) {
                            System.out.println("Fin de entrada.");
                            continuar = false;
                        } else {
                            // --- 4. Ejecutar el jar con la operación ---
                            ProcessBuilder pbRun = new ProcessBuilder("java", "-jar", "RealizaOperacion.jar", operacion);
                            pbRun.redirectErrorStream(true);
                            Process procRun = pbRun.start();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(procRun.getInputStream()));
                            while ((line = reader.readLine()) != null) 
                                System.out.println(line);
                            procRun.waitFor();
                        }
                    }
                } else 
                    System.out.println("Error: No se pudo generar el JAR");  
            } else 
                System.out.println("Error: No se pudo compilar RealizaOperacion.java");
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
}
