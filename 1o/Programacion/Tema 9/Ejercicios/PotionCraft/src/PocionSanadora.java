public final class PocionSanadora extends Pocion{
    private double sanacion;

    public PocionSanadora(String nombre, Potencia potencia, String[] ingredientes){
        super(nombre, potencia, ingredientes);
        this.sanacion = 50*potencia.getFactor();
    }

    @Override
    public String mostrarDescripcion(){
        return super.mostrarDescripcion() + " para sanar a los enfermos";
    }
}
