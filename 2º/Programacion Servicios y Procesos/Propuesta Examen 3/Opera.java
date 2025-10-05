/**
 * @author Sergio Trillo Rodriguez
 */
import java.io.*;
import java.util.Scanner;

public class Opera {
    /**
     * Método que comprueba si existe el jar
     * @param nombreJar
     * @return si existe el fichero Jar o no
     */
    private static boolean jarExiste(String nombreJar) {
        File jar = new File(nombreJar);
        return jar.exists();
    }

    /**
     * Método que compila RealizaOperacion.java y genera el jar
     * @return
     */
    private static boolean compilarYGenerarJar() {
        boolean exito = true;
        try {
            Process compilacion = Runtime.getRuntime().exec("javac RealizaOperacion.java");
            compilacion.waitFor();
            if (compilacion.exitValue() != 0) {
                System.out.println("Error al compilar RealizaOperacion.java");
                exito = false;
            } else {
                Process crearJar = Runtime.getRuntime().exec("jar cf RealizaOperacion.jar RealizaOperacion.class");
                crearJar.waitFor();
                if (crearJar.exitValue() != 0) {
                    System.out.println("Error al generar el jar");
                    exito = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Excepción al compilar/generar jar: " + e.getMessage());
            exito = false;
        }
        return exito;
    }

    /**
     * Método que ejecuta el jar con la operación
     */
    private static void ejecutarOperacion(String operacion) {
        try {
            Process proceso = new ProcessBuilder("java", "-jar", "RealizaOperacion.jar", operacion).redirectErrorStream(true).start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = br.readLine()) != null)
                    System.out.println(linea);
            }

            proceso.waitFor();
        } catch (Exception e) {
            System.out.println("Error al ejecutar el jar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una operación (+,-,*,:) con dos enteros (ej: '+ 2 3'): ");
        String operacion = sc.nextLine().trim();

        boolean jarListo = true;

        if (!jarExiste("RealizaOperacion.jar")) {
            jarListo = compilarYGenerarJar();
            if (!jarListo) 
                System.out.println("No se pudo generar el jar. Saliendo...");
        }

        if (jarListo)
            ejecutarOperacion(operacion);
    }
}
