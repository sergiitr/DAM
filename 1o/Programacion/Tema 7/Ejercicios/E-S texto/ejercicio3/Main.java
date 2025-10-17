import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String introNombre;
        String rutaArchivo = "../Ficheros_actividades/nombres.txt";

        ArrayList<String> nombres = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;            
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String nombre = campos[0].trim();
                nombres.add(nombre);
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }

        int opcion;
        do { 
            System.out.print("Introduce opcion (1 al 4): ");
            opcion = sc.nextInt();
        } while (opcion > 4 || opcion < 1);

        sc.nextLine(); // Consumir la nueva línea después de la lectura del número

        switch (opcion) {
            case 1:
                System.out.println("-----");
                System.out.println("Buscar el nombre:");
                System.out.print("Introduce el nombre que vas a buscar: ");
                introNombre = sc.nextLine();
                if (nombres.indexOf(introNombre) == -1)
                    System.out.println("Nombre no existe en el fichero");
                else
                    System.out.println("Nombre está en la lista en la posición " + nombres.indexOf(introNombre));
                System.out.println("-----");
                break;

            case 2:
                Random rd = new Random();
                int posicion = rd.nextInt(nombres.size());
                System.out.println("-----");
                System.out.println("El nombre de la posición " + posicion + " es: " + nombres.get(posicion));
                System.out.println("-----");
                break;

            case 3:
                int cantNombres;
                System.out.print("Introduce la cantidad de nombres del nuevo fichero: ");
                cantNombres = sc.nextInt();
                String salida="personas_";
                salida=salida.concat(Integer.toString(cantNombres));
                salida=salida.concat(".txt");

                try {
                    // Aquí se abre el archivo en modo escritura
                    FileWriter escritor = new FileWriter(salida); // true para agregar al final
                    BufferedWriter bufferEscritor = new BufferedWriter(escritor);

                    

                    // Escribir un salto de línea en el archivo
                    bufferEscritor.newLine();
                    for (int i = 0; i < cantNombres; i++) {
                        // Escribir la cadena en el archivo
                        bufferEscritor.write(nombres.get(i));
                        bufferEscritor.newLine();
                        
                    }
                    
                    bufferEscritor.close(); // Cerrar el buffer
                } catch (IOException e) {
                    System.out.println("Error al escribir en el archivo: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Salida");
        }
    }
}
