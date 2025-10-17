public class CajaCarton extends Caja {
    public CajaCarton(int ancho, int alto, int fondo, String etiqueta) {
        super(ancho, alto, fondo, etiqueta);
    }

    @Override
    public double getVolumen() {
        return ancho*alto*fondo*0.8;
    }

    @Override
    public double getPrecio() {
        return 0.8*super.getPrecio();
    }
}