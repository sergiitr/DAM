
public class Pocion implements Comerciable,Comparable<Pocion>{
    public Pocion(String nombre, Potencia potencia, String[] ingredientes) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.ingredientes = ingredientes;
        this.precio = PRECIO_BASE * potencia.getFactor(potencia);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Potencia getPotencia() {
        return potencia;
    }
    public void setPotencia(Potencia potencia) {
        this.potencia = potencia;
    }
    public String[] getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    public double getPrecio() {
        return precio;
    }

    @Override
    public void regatear() {
        this.precio = this.precio * (Math.random()+0.5);
    }

    @Override
    public int vender() {
        return (int)Math.round(this.precio);
    }

    /**
     * Hacemos el compare to
     */
    @Override
    public int compareTo(Pocion otraPocion) {
        if(this.precio<otraPocion.precio) {
            return 1;
        } else if (this.precio>otraPocion.precio) {
            return -1;
        } else {
            if (this.nombre.charAt(0)>otraPocion.nombre.charAt(0)){
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return "Pocion " + nombre + " " + potencia;
    }

    public String descripcion() {
        String desc = "Pocion " +nombre + " " + potencia+" es útil";
        return desc;
    }


    protected String nombre;
    protected Potencia potencia;
    protected String[] ingredientes;
    protected double precio;

}
