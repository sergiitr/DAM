import java.util.ArrayList;
import java.util.Collections;
enum Potencia {
    FUERTE, MEDIA, DEBIL;

    public double getFactor(Potencia potencia) {
        if(potencia==DEBIL)
            return  0.8;
        else if (potencia==MEDIA)
            return 1;
        else
            return 1.2;
    }
}

interface Comerciable {
    public final int PRECIO_BASE=50;
    public int vender();
    public void regatear();
}


class Pocion implements Comerciable,Comparable<Pocion>{
    public Pocion(String nombre, Potencia potencia, String[] ingredientes) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.ingredientes = ingredientes;
        this.precio = PRECIO_BASE * potencia.getFactor(potencia);
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
     * Hacemos el compareTo
     * Lo haremos de mayor a menor
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

class PocionVenenosa extends Pocion{
    /**
     * Constructor PocionVenenosa
     * @param nombre
     * @param potencia
     * @param ingredientes
     */
    public PocionVenenosa(String nombre, Potencia potencia, String[] ingredientes) {
        super(nombre, potencia, ingredientes);
        this.danio = 50*potencia.getFactor(potencia);
    }

    @Override
    public String descripcion() {
        String desc = super.descripcion()+" para dañar a los enemigos";
        return desc;
    }

    private double danio;
}
class Senadora extends Pocion{
    /**
     * Constructor senadora
     * @param nombre
     * @param potencia
     * @param ingredientes
     */
    public Senadora(String nombre, Potencia potencia, String[] ingredientes) {
        super(nombre, potencia, ingredientes);
        this.sanacion = 50*potencia.getFactor(potencia);
    }

    @Override
    public String descripcion() {
        String desc = super.descripcion()+" para sanar a los enfermos";
        return desc;
    }
    private double sanacion;
}


public class TSergio {
    /**
     * Codigo para mostrar el inventario de pociones
     * @param inventario
     */
    public static void mostrarInventario(ArrayList<Pocion> inventario) {
        System.out.println("Nuestras pociones son: "+inventario);

        int contadorVenenosa=0, contadorSenadora=0;

        // Contamos cuantas pociones hay de cada tipo
        for (int i = 0; i < inventario.size(); i++) {
            if(inventario.get(i).nombre.toLowerCase().equals("venenosa")){
                contadorVenenosa++;
            } else if(inventario.get(i).nombre.toLowerCase().equals("senadora")){
                contadorSenadora++;
            }
        }
        System.out.println("\nHay "+contadorVenenosa+" venenosa y " +contadorSenadora+" senadora");
    }


    public static void main(String[] args) {
        String[] ingredientesSenadora = new String[2];
        ingredientesSenadora[0] = "Romero druidico";
        ingredientesSenadora[1] = "Terraria";

        String[] ingredientesPocionVenenosa = new String[2];
        ingredientesPocionVenenosa[0] = "Seta apestosa";
        ingredientesPocionVenenosa[1] = "Terraria";

        ArrayList<Pocion> inventario = new ArrayList<>();
        inventario.add(new Senadora("Senadora", Potencia.FUERTE, ingredientesSenadora));
        inventario.add(new Senadora("Senadora", Potencia.DEBIL, ingredientesSenadora));
        inventario.add(new Senadora("Senadora", Potencia.MEDIA, ingredientesSenadora));

        inventario.add(new PocionVenenosa("Venenosa", Potencia.DEBIL, ingredientesPocionVenenosa));
        inventario.add(new PocionVenenosa("Venenosa", Potencia.FUERTE, ingredientesPocionVenenosa));
        
        Collections.shuffle(inventario);

        mostrarInventario(inventario);
        System.out.println();
        System.out.println(inventario.get(0).descripcion());
        System.out.println("Regateando...");
        inventario.get(0).regatear();
        System.out.println("Venta: "+inventario.get(0).vender());
        inventario.remove(0);

        System.out.println(inventario.get(0).descripcion());
        System.out.println("Regateando...");
        inventario.get(0).regatear();
        System.out.println("Venta: "+inventario.get(0).vender());
        inventario.remove(0);

        System.out.println(inventario.get(0).descripcion());
        System.out.println("Regateando...");
        inventario.get(0).regatear();
        System.out.println("Venta: "+inventario.get(0).vender());
        inventario.remove(0);
        
        
        inventario.sort(null);
        System.out.println("\n");
        mostrarInventario(inventario);
        
    }
}