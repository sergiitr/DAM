import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LibroDeFirmas {
    private static final String FICHERO = "firmas.dat";
    private ArrayList<Firma> firmas = new ArrayList<>();

    /**
     * Método para cargar las firmas desde el archivo binario
     */
    public void cargarFirmas() {
        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(FICHERO))) {
            while (true) {
                try {
                    Firma firma = (Firma) flujoEntrada.readObject();
                    firmas.add(firma);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Error al leer el archivo");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo abrir el archivo, creando uno nuevo...");
        }
    }

    /**
     * Método para guardar las firmas en el archivo binario
     */
    public void guardarFirmas() {
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            for (Firma firma : firmas) 
                flujoSalida.writeObject(firma);

        } catch (IOException e) {
            System.out.println("Error al guardar las firmas");
        }
    }

    /**
     * Método para mostrar todas las firmas
     */
    public void mostrarFirmas() {
        if (firmas.isEmpty()) {
            System.out.println("No hay firmas registradas.");
        } else {
            System.out.println("Firmas registradas:");
            for (Firma firma : firmas) {
                System.out.println(firma);
            }
        }
    }

    /**
     * Método para añadir una nueva firma
     * @param nombre
     */
    public void añadirFirma(String nombre) {
        // Comprobamos si el nombre ya está en la lista
        for (Firma firma : firmas) {
            if (firma.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("La firma ya está registrada.");
                return;
            }
        }
        // Si no está repetido, añadimos la nueva firma
        firmas.add(new Firma(nombre));
        System.out.println("Firma añadida con éxito.");
    }
}
