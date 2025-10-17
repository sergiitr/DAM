import java.io.*;
import java.util.ArrayList;

public class Main {
    /**
     * Método para devolver la descripción de cada palabra clave
     * @param palabra
     */
    public static String getDescripcion(String palabra) {
        switch (palabra) {
            case "quijote":
                return "Quijote, protagonista de la novela";
            case "sancho":
                return "Sancho, el fiel escudero";
            case "cardenio":
                return "Cardenio, personaje al que Don Quijote y Sancho Panza se encontraron cuando iban por un bosque de Sierra Morena";
            case "dulcinea":
                return "Dulcinea, la dama de quien está enamorado el protagonista Don Quijote";
            case "rucio":
                return "Rucio, el burro de Sancho Panza";
            case "rocinante":
                return "Rocinante, el caballo de Don Quijote";
            case "fierabras":
                return "Fierabrás, según Don Quijote, poción mágica capaz de curar todas las dolencias del cuerpo humano";
            case "barataria":
                return "Barataria, ínsula de la que fue gobernador Sancho Panza";
            case "hamete":
                return "Hamete, supuesto historiador musulmán";
            default:
                return "Palabra desconocida";
        }
    }
    public static void main(String[] args) {
        String[] palabrasClave = {"quijote", "sancho", "cardenio", "dulcinea", "rucio", "rocinante", "fierabras", "barataria", "hamete"};
        
        ArrayList<String> listaPalabras = new ArrayList<>();
        ArrayList<Integer> listaContadores = new ArrayList<>();
        
        for (String palabra : palabrasClave) {
            listaPalabras.add(palabra);
            listaContadores.add(0);
        }
        
        String rutaArchivoEntrada = "../Ficheros_actividades/Quijote.txt";
        String rutaArchivoSalida = "informe_quijote.txt";
        
        String regex = "[\\s,;.!?(){}\\[\\]:\"'-]+";
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(regex);
                for (String palabra : palabras) {
                    palabra = palabra.trim().toLowerCase();  // Convertimos a minúsculas
                    
                    if (!palabra.isEmpty()) 
                        for (int i = 0; i < listaPalabras.size(); i++) 
                            if (listaPalabras.get(i).equals(palabra))
                                listaContadores.set(i, listaContadores.get(i) + 1);
                }
            } 
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
            return;
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoSalida))) {
            bw.write("Informe de menciones en El Quijote\n\n");
            for (int i = 0; i < listaPalabras.size(); i++) {
                String descripcion = getDescripcion(listaPalabras.get(i));
                int contador = listaContadores.get(i);
                bw.write(descripcion + " aparece " + contador + " veces.\n");
            }
            System.out.println("Informe generado correctamente.");
        } catch (IOException ex) {
            System.err.println("Error al generar el informe: " + ex.getMessage());
        }
    }

    
}
