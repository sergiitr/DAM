import java.util.ArrayList;

public class Coches {
    public Coches(String marca, String modelo, int cilindrada, double potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public static double cilindradaMedia(ArrayList<Coches> coches) {
        double totalCilindrada = 0;
        for (Coches coche : coches) {
            totalCilindrada += coche.getCilindrada();
        }
        return coches.size() > 0 ? totalCilindrada / coches.size() : 0;
    }

    public static double potenciaMedia(ArrayList<Coches> coches) {
        double totalPotencia = 0;
        for (Coches coche : coches) {
            totalPotencia += coche.getPotencia();
        }
        return coches.size() > 0 ? totalPotencia / coches.size() : 0;
    }

    private String marca;
    private String modelo;
    private int cilindrada;
    private double potencia;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coches{");
        sb.append("marca=").append(marca);
        sb.append(", modelo=").append(modelo);
        sb.append(", cilindrada=").append(cilindrada);
        sb.append(", potencia=").append(potencia);
        sb.append('}');
        return sb.toString();
    }
}
