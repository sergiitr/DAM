public class PocionVenenosa extends Pocion{
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
