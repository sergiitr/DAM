import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String archivoCsv = "../Ficheros_actividades/ajedrez.csv";
        String archivoJson = "ajedrez.json";
        
        ArrayList<Ajedrez> jugadores = cargarDatosCsv(archivoCsv);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el país para filtrar los jugadores de ajedrez: ");
        String pais = scanner.nextLine().trim();

        ArrayList<Ajedrez> jugadoresFiltrados = filtrarPorPais(jugadores, pais);

        if (!jugadoresFiltrados.isEmpty()) {
            guardarComoJson(jugadoresFiltrados, archivoJson);
            System.out.println("Los jugadores de " + pais + " han sido guardados en " + archivoJson);
        } else
            System.out.println("No se encontraron jugadores de " + pais + ".");
        
    }

    /**
     * Función para cargar los datos del archivo CSV
     * @param archivoCsv
     * @return
     */
    private static ArrayList<Ajedrez> cargarDatosCsv(String archivoCsv) {
        ArrayList<Ajedrez> jugadores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                int posicion = Integer.parseInt(campos[0].trim());
                String nombre = campos[1].trim();
                String federacion = campos[2].trim();
                double elo = Double.parseDouble(campos[3].replace(",", ".").trim()); 
                jugadores.add(new Ajedrez(posicion, nombre, federacion, elo)); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jugadores;
    }

    /**
     * Función para filtrar jugadores por país
     * @param jugadores
     * @param pais
     * @return
     */
    private static ArrayList<Ajedrez> filtrarPorPais(ArrayList<Ajedrez> jugadores, String pais) {
        ArrayList<Ajedrez> jugadoresFiltrados = new ArrayList<>();
        for (Ajedrez jugador : jugadores)
            if (jugador.getFederacion().toLowerCase().contains(pais.toLowerCase())) 
                jugadoresFiltrados.add(jugador);
        
        return jugadoresFiltrados;
    }

    /**
     * Función para guardar la ArrayLista de jugadores en un archivo JSON
     * @param jugadoresFiltrados
     * @param archivoJson
     */
    private static void guardarComoJson(ArrayList<Ajedrez> jugadoresFiltrados, String archivoJson) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(archivoJson)) {
            gson.toJson(jugadoresFiltrados, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
