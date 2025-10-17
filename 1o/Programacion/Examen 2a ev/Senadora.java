public class Senadora extends Pocion{
    
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
