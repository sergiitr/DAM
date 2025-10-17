public class Directivo extends Empleado {
    public Directivo(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Empleado "+nombre+" -> Directivo";
    }
}
