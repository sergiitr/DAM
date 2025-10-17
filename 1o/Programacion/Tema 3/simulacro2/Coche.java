import java.util.Scanner;

public class Coche {
    public Coche(String marca, String modelo, int anio, double kilometraje, double precio, double combustible, double capacidadTanque, Persona conductor) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.combustible = combustible;
        this.capacidadTanque = capacidadTanque;
        this.conductor = conductor;
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
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public double getKilometraje() {
        return kilometraje;
    }
    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getCombustible() {
        return combustible;
    }
    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }
    public double getCapacidadTanque() {
        return capacidadTanque;
    }
    public void setCapacidadTanque(double capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }
    public Persona getConductor() {
        return conductor;
    }
    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public int calcularAntiguedad() {
        return (2024-this.anio);
    }

    private double calcularConsumo(double kilometraje, double litros) {
        Scanner sc = new Scanner(System.in);
        double nuevoKM;
        double consumo= 100*(litros/(kilometraje-this.kilometraje));
        
        this.kilometraje = kilometraje;
        return consumo;
    }

    public void repostar (double litros) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double cantidad=0;
        
        if (litros+this.combustible>this.capacidadTanque) {
            cantidad=(this.capacidadTanque-this.combustible);
            System.out.println("Se ha recargado "+cantidad+"L");
        } else {
            cantidad=litros;
            System.out.println("Se ha recargado "+cantidad+"L");
        }
        System.out.println("Quieres ver su consumo?");
        respuesta = sc.nextLine();
        if (respuesta.toLowerCase().equals("si") || respuesta.toLowerCase().equals("sí")) {
            double nuevoKM;
            System.out.print("Introduzca nuevo kilometraje: ");
            nuevoKM=sc.nextDouble();
            System.out.println(calcularConsumo(nuevoKM,cantidad));
        }
    }
    public double depreciarValor() {
        if (calcularAntiguedad()>=2)
            return this.precio*0.8;
        else if (calcularAntiguedad()==1){
            return this.precio*0.9;
        } else {
            return this.precio;
        }
    }

    public void subirConductor (Persona conductor) {
        if (this.conductor ==null) {
            this.conductor=conductor;
            System.out.println("Se ha montado el conductor "+conductor.getNombre());
        }else
            System.out.println("Ya hay un conductor en el coche");
    }

    public void bajarConductor (Persona conductor) {
        if (this.conductor != null){
            this.conductor=null;
            System.out.println("Se va a bajar el conductor "+conductor.getNombre());
        } else
            System.out.println("No habia anteriormente un conductor en el coche");
    }

    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;
    private double precio;
    private double combustible;
    private double capacidadTanque;
    private Persona conductor;
}