import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "../Ficheros_actividades/jugadores.txt";
        ArrayList<Jugador> jugadores = new ArrayList<>();
        int _edad=0;
        double estatura=0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(" ");
                String nombre = campos[0].trim();
                int edad = Integer.parseInt(campos[1].trim());
                Double altura = Double.parseDouble(campos[2].trim()) ;
                jugadores.add(new Jugador(nombre, edad, altura));
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println(jugadores.get(i).toString());
        }


        for (int i = 0; i < jugadores.size(); i++) {
            _edad+=jugadores.get(i).edad;
        }

        double edadMedia = (double) _edad/jugadores.size();
        edadMedia=Math.round(edadMedia * 100.0) / 100.0;
        System.out.println("\nLa edad media es: "+edadMedia+" años");

        for (int i = 0; i < jugadores.size(); i++) {
            estatura+=jugadores.get(i).estatura;
        }

        double estaturaMedia = estatura/jugadores.size();
        estaturaMedia=Math.round(estaturaMedia * 100.0) / 100.0;
        System.out.println("La estatura media es: "+estaturaMedia+"m");
    }
}
