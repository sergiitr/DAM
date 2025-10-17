import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "./datos.csv";
        ArrayList<Persona> personas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Para saltarse la cabecera
            
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String nombre = campos[0].trim();
                int edad = Integer.parseInt(campos[1].trim());
                String ciudad = campos[2].trim();
                personas.add(new Persona(nombre, edad, ciudad));
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }

        
        personas.sort(null);
        System.out.println("Listado de personas ordenado por edad:");
        System.out.println(personas);
        
    }
}
