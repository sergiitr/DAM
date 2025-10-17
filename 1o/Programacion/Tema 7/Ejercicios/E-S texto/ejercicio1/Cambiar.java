import java.io.*;

public class Cambiar {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java Cambiar viejoFichero nuevoFichero palabra");
            return;
        }
        
        String viejoFichero = args[0];
        String nuevoFichero = args[1];
        String palabra = args[2];
        
        int palabrasReemplazadas = 0;
        int totalPalabras = 0;
        
        String regex = "[\\s,;.!?(){}\\[\\]:\"'-]+";

        try (BufferedReader leerFichero = new BufferedReader(new FileReader(viejoFichero));
            BufferedWriter escribirFichero = new BufferedWriter(new FileWriter(nuevoFichero))) {
            String linea;
            while ((linea = leerFichero.readLine()) != null) {
                String[] palabrasEnLinea = linea.split(regex);
                StringBuilder nuevaLinea = new StringBuilder();
                
                for (String palabraEnLinea : palabrasEnLinea) {
                    totalPalabras++;
                    if (palabraEnLinea.equalsIgnoreCase(palabra)) {
                        palabrasReemplazadas++;
                        nuevaLinea.append(palabra.toUpperCase()).append(" ");
                    } else
                        nuevaLinea.append(palabraEnLinea).append(" ");
                }
                
                escribirFichero.write(nuevaLinea.toString().trim());
                escribirFichero.newLine();
            }
            
            escribirFichero.write("\nNúmero total de palabras: " + totalPalabras + "\n");
            escribirFichero.write("Número de palabras reemplazadas: " + palabrasReemplazadas + "\n");
            
            System.out.println("Proceso completado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}
