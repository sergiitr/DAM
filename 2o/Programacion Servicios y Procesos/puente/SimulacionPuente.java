/**
 * Ejercicio Puente
 * @author Sergio Trillo Rodriguez
 */

import java.util.Random;

/**
 * Clase Puente
 */
class Puente {
    private int cochesEnPuente = 0;
    private int pesoActual = 0;
    private final int MAX_COCHES = 3;
    private final int MAX_PESO = 5000;

    /**
     * Se comprueba si un coche puede pasar o no por el puente
     * @param coche
     * @return true si el coche puede pasar, false si no puede pasar
     */
    public synchronized boolean sePermitePaso(Coche coche) {
        int peso = coche.getPesoCoche();
        while (cochesEnPuente >= MAX_COCHES || pesoActual + peso > MAX_PESO) {
            try {
                System.out.println("Coche " + coche.getId() + " (" + peso + " kg) espera. Puente: " + cochesEnPuente + " coches, " + pesoActual + " kg.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        cochesEnPuente++;
        pesoActual += peso;
        System.out.println("Coche " + coche.getId() + " entra al puente. Peso actual: " + pesoActual + " kg.");
        return true;
    }

    
    /**
     * Llamado cuando un coche termina de cruzar
     * @param coche
     */
    public synchronized void finalizarPaso(Coche coche) {
        cochesEnPuente--;
        pesoActual -= coche.getPesoCoche();
        System.out.println("Coche " + coche.getId() + " sale del puente. Peso actual: " + pesoActual + " kg.");
        notifyAll();
    }
}

/**
 * Clase Coche
 * Extiende de la clase Thread
 */
class Coche extends Thread {
    private static int contador = 0;
    private final int id;
    private final int pesoCoche;
    private final int tiempoCruce;
    private final int tiempoLlegada;
    private final Puente puente;
    private final Random rand = new Random();

    public Coche(Puente puente) {
        this.puente = puente;
        this.id = ++contador;
        this.pesoCoche = rand.nextInt(1201) + 800;
        this.tiempoCruce = rand.nextInt(41) + 10;
        this.tiempoLlegada = rand.nextInt(30) + 1;
    }

    public int getPesoCoche() { return pesoCoche; }

    @Override
    public void run() {
        try {
            Thread.sleep(tiempoLlegada * 1000L);
            System.out.println("Coche " + id + " llega al puente (" + pesoCoche + " kg).");
            puente.sePermitePaso(this);
            Thread.sleep(tiempoCruce * 1000L);
            puente.finalizarPaso(this);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getIdCoche() { return id; }
}

public class SimulacionPuente {
    public static void main(String[] args) {
        Puente puente = new Puente();
        int numCoches = 10;
        for (int i = 0; i < numCoches; i++)
            new Coche(puente).start();
    }
}
