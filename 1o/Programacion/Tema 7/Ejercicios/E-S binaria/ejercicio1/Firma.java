import java.io.Serializable;

public class Firma implements Serializable {
    private String nombre;

    public Firma(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}