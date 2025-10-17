import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "./../Ficheros_actividades/coches.csv";
        String rutaArchivoSalida = "./resultados.txt";
        ArrayList<Coches> coche = new ArrayList<>();

        ArrayList<Coches> Toyota = new ArrayList<>();
        ArrayList<Coches> Honda = new ArrayList<>();
        ArrayList<Coches> Ford = new ArrayList<>();
        ArrayList<Coches> Volkswagen = new ArrayList<>();
        ArrayList<Coches> Renault = new ArrayList<>();
        ArrayList<Coches> Nissan = new ArrayList<>();
        ArrayList<Coches> Chevrolet = new ArrayList<>();
        ArrayList<Coches> Hyundai = new ArrayList<>();
        ArrayList<Coches> Kia = new ArrayList<>();
        ArrayList<Coches> Mazda = new ArrayList<>();
        ArrayList<Coches> Subaru = new ArrayList<>();
        ArrayList<Coches> Audi = new ArrayList<>();
        ArrayList<Coches> BMW = new ArrayList<>();
        ArrayList<Coches> MercedesBenz = new ArrayList<>();
        ArrayList<Coches> Fiat = new ArrayList<>();
        ArrayList<Coches> Peugeot = new ArrayList<>();
        ArrayList<Coches> Citroen = new ArrayList<>();
        ArrayList<Coches> Opel = new ArrayList<>();
        ArrayList<Coches> Seat = new ArrayList<>();
        ArrayList<Coches> Mini = new ArrayList<>();
        ArrayList<Coches> Volvo = new ArrayList<>();
        ArrayList<Coches> Lexus = new ArrayList<>();
        ArrayList<Coches> Jaguar = new ArrayList<>();
        ArrayList<Coches> LandRover = new ArrayList<>();
        ArrayList<Coches> Porsche = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Para saltarse la cabecera

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                String marca = campos[0].trim();
                String modelo = campos[1].trim();
                int cilindrada = Integer.parseInt(campos[2].trim());
                double potencia = Double.parseDouble(campos[3].trim());

                Coches nuevoCoche = new Coches(marca, modelo, cilindrada, potencia);

                // Añadir el coche a la lista correspondiente según la marca
                switch (marca) {
                    case "Toyota" -> Toyota.add(nuevoCoche);
                    case "Honda" -> Honda.add(nuevoCoche);
                    case "Ford" -> Ford.add(nuevoCoche);
                    case "Volkswagen" -> Volkswagen.add(nuevoCoche);
                    case "Renault" -> Renault.add(nuevoCoche);
                    case "Nissan" -> Nissan.add(nuevoCoche);
                    case "Chevrolet" -> Chevrolet.add(nuevoCoche);
                    case "Hyundai" -> Hyundai.add(nuevoCoche);
                    case "Kia" -> Kia.add(nuevoCoche);
                    case "Mazda" -> Mazda.add(nuevoCoche);
                    case "Subaru" -> Subaru.add(nuevoCoche);
                    case "Audi" -> Audi.add(nuevoCoche);
                    case "BMW" -> BMW.add(nuevoCoche);
                    case "Mercedes-Benz" -> MercedesBenz.add(nuevoCoche);
                    case "Fiat" -> Fiat.add(nuevoCoche);
                    case "Peugeot" -> Peugeot.add(nuevoCoche);
                    case "Citroën" -> Citroen.add(nuevoCoche);
                    case "Opel" -> Opel.add(nuevoCoche);
                    case "Seat" -> Seat.add(nuevoCoche);
                    case "Mini" -> Mini.add(nuevoCoche);
                    case "Volvo" -> Volvo.add(nuevoCoche);
                    case "Lexus" -> Lexus.add(nuevoCoche);
                    case "Jaguar" -> Jaguar.add(nuevoCoche);
                    case "Land Rover" -> LandRover.add(nuevoCoche);
                    case "Porsche" -> Porsche.add(nuevoCoche);
                    default -> {
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoSalida))) {
            mostrarCochesYMedias("Toyota", Toyota, writer);
            mostrarCochesYMedias("Honda", Honda, writer);
            mostrarCochesYMedias("Ford", Ford, writer);
            mostrarCochesYMedias("Volkswagen", Volkswagen, writer);
            mostrarCochesYMedias("Renault", Renault, writer);
            mostrarCochesYMedias("Nissan", Nissan, writer);
            mostrarCochesYMedias("Chevrolet", Chevrolet, writer);
            mostrarCochesYMedias("Hyundai", Hyundai, writer);
            mostrarCochesYMedias("Kia", Kia, writer);
            mostrarCochesYMedias("Mazda", Mazda, writer);
            mostrarCochesYMedias("Subaru", Subaru, writer);
            mostrarCochesYMedias("Audi", Audi, writer);
            mostrarCochesYMedias("BMW", BMW, writer);
            mostrarCochesYMedias("Mercedes-Benz", MercedesBenz, writer);
            mostrarCochesYMedias("Fiat", Fiat, writer);
            mostrarCochesYMedias("Peugeot", Peugeot, writer);
            mostrarCochesYMedias("Citroën", Citroen, writer);
            mostrarCochesYMedias("Opel", Opel, writer);
            mostrarCochesYMedias("Seat", Seat, writer);
            mostrarCochesYMedias("Mini", Mini, writer);
            mostrarCochesYMedias("Volvo", Volvo, writer);
            mostrarCochesYMedias("Lexus", Lexus, writer);
            mostrarCochesYMedias("Jaguar", Jaguar, writer);
            mostrarCochesYMedias("Land Rover", LandRover, writer);
            mostrarCochesYMedias("Porsche", Porsche, writer);
        } catch (IOException ex) {
            System.err.println("Error al escribir el archivo: " + ex.getMessage());
        }
    }

    public static void mostrarCochesYMedias(String marca, ArrayList<Coches> coches, BufferedWriter writer) {
        if (!coches.isEmpty()) {
            try {
                double potenciaMedia = Math.round(Coches.potenciaMedia(coches)*100)/100;
                // Escribir solo la marca, cilindrada media y potencia media
                writer.write("Marca: " + marca + ", Cilindrada media: " + Coches.cilindradaMedia(coches) + ", Potencia media: " + potenciaMedia + "\n");
            } catch (IOException ex) {
                System.err.println("Error al escribir en el archivo: " + ex.getMessage());
            }
        }
    }
}
