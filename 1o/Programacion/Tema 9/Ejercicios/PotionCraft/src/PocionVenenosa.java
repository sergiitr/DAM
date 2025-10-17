public final class PocionVenenosa extends Pocion{
    private double danio;

    public PocionVenenosa(String nombre, Potencia potencia, String[] ingredientes){
        super(nombre, potencia, ingredientes);
        this.danio = 50*potencia.getFactor();
    }

    @Override
    public String mostrarDescripcion(){
        return super.mostrarDescripcion() + " para dañar a los enemigos";
    }
}
