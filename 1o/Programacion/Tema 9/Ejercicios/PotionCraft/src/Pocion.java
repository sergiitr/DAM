import java.util.ArrayList;

public class Pocion implements Comparable<Pocion>, Comerciable {

    /***********
     * Atributos
     ***********/

    private String nombre; // Nombre de la poción.
    private Potencia potencia; // Potencia de la poción utilizando el enum Potencia.
    private String[] ingredientes; // Ingredientes de la poción utilizando un array de String.
    private double precio; // Precio de la poción.

    /*************
     * Constructor
     *************/

    /**
     * Constructor de la clase Pocion. Calcula el precio de la poción en base
     * a su potencia.
     * @param nombre Nombre de la poción.
     * @param potencia Potencia de la poción.
     * @param ingredientes Array de String con los ingredientes de la poción.
     */
    public Pocion(String nombre, Potencia potencia, String[] ingredientes){
        this.nombre = nombre;
        this.potencia = potencia;
        this.ingredientes = ingredientes;
        precio = PRECIO_BASE*potencia.getFactor();
    }

    /* *******
     * Métodos
     *********/

    /**
     * Añade la cadena " es útil" al toString() del objeto.
     * @return String con la descripción de la poción.
     */
    public String mostrarDescripcion(){
        return toString() + " es útil";
    }

    /**
     * Redondea el precio de la poción al entero más cercano.
     * @return int con el precio de la poción.
     */
    @Override
    public int vender() {
        return (int) Math.round(precio);
    }

    /**
     * Cambiar el precio de la poción al azar, aumentando o disminuyendo su precio
     * entre un 0% y un 50%.
     */
    @Override
    public void regatear() {
        System.out.println("Regateando poción");
        precio = precio*(0.5 + Math.random());
    }

    /**
     * Compara dos pociones por su potencia y, en caso de empate, por su nombre.
     * @param o Poción con la que se compara.
     * @return 1 si la poción actual va antes, -1 si va después y 0 si son iguales.
     */
    @Override
    public int compareTo(Pocion o){
        if (this.potencia.getFactor() < o.potencia.getFactor()){
            return 1;
        } else if (this.potencia.getFactor() > o.potencia.getFactor()){
            return -1;
        } else {
            if (this.nombre.compareTo(o.nombre) > 0){
                return 1;
            } else if (this.nombre.compareTo(o.nombre) < 0){
                return -1;
            } else{
                return 0;
            }
        }
    }

    /**
     * Muestra el nombre y la potencia de la poción.
     * @return String con el nombre y la potencia de la poción.
     */
    @Override
    public String toString() {
        return "Poción " + nombre + " " + potencia;
    }

    /**
     * Compara dos pociones por su nombre y potencia.
     * @param o Poción con la que se compara.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o){
        if (o instanceof Pocion){
            Pocion p = (Pocion) o;
            return (this.nombre.equals(p.nombre) && this.potencia.equals(p.potencia)) && this.potencia.equals(p.potencia);
        }
        return false;
    }

    /**
     * Devuelve el hashcode de la poción teniendo en cuenta su nombre
     * y potencia.
     * @return int con el hashcode de la poción.
     */
    @Override
    public int hashCode(){
        return nombre.hashCode() + potencia.hashCode();
    }
}
