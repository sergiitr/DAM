import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Agenda> personas = new ArrayList<>();
        String agenda = "";  // Mover esta declaración aquí

        do {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("--- Menu ---");
            System.out.println("1.- Añadir contacto");
            System.out.println("2.- Mostrar contacto");
            System.out.println("3.- Eliminar contacto por tlfn");
            System.out.println("4.- Crear fichero de contactos JSON");
            System.out.println("5.- Guardar copia de seguridad");
            System.out.println("6.- Cargar contactos desde copia de seguridad");
            System.out.println("7.- Guardar CSV y salir");
            System.out.print("\nIntroduzca opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    String nombre, apellido, mail;
                    int numero;
                    System.out.print("Introduce nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Introduce apellido: ");
                    apellido = sc.nextLine();
                    System.out.print("Introduce mail: ");
                    mail = sc.nextLine();
                    System.out.print("Introduce tlfn: ");
                    numero = sc.nextInt();
                    sc.nextLine();
                    int contador = 0;
                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i).getTlfn() == numero) {
                            contador++;
                        }
                    }
                    if (contador == 0) {
                        Agenda a1 = new Agenda(nombre, apellido, numero, mail);
                        personas.add(a1);
                    } else {
                        System.out.println("No se ha podido añadir el contacto");
                    }
                    break;
                case 2:
                    System.out.println("Las personas son: " + personas);
                    break;
                case 3:
                    int borrarNumero;
                    System.out.print("Introduce el numero que quieres eliminar: ");
                    borrarNumero = sc.nextInt();
                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i).getTlfn() == borrarNumero) {
                            personas.remove(i);
                        }
                    }
                    break;
                case 4:
                    break;
                case 5:
                    agenda = gson.toJson(personas);
                    try (FileWriter writer = new FileWriter("agenda_CS.json")) {
                        writer.write(agenda);
                        System.out.println("Datos exportados correctamente a agenda_CS.json");
                    } catch (IOException e) {
                        System.err.println("Error al escribir en el archivo: " + e.getMessage());
                    }
                    break;
                case 6:
                    try (FileReader reader = new FileReader("agenda_CS.json")) {
                        personas = gson.fromJson(reader, new com.google.gson.reflect.TypeToken<ArrayList<Agenda>>(){}.getType());
                        System.out.println("Copia de seguridad restaurada");
                        System.out.println(personas);
                    } catch (IOException e) {
                        System.err.println("Error al leer el archivo de copia de seguridad: " + e.getMessage());
                    }
                    break;
                case 7:
                    String _agenda = gson.toJson(personas);
                    try (FileWriter writer = new FileWriter("agenda.json")) {
                        writer.write(_agenda);
                        System.out.println("Datos exportados correctamente a agenda.json");
                    } catch (IOException e) {
                        System.err.println("Error al escribir en el archivo: " + e.getMessage());
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 7);
    }
}
