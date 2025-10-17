public class CajaPlastico extends Caja {
    public CajaPlastico(int ancho, int alto, int fondo, String etiqueta) {
        super(ancho, alto, fondo, etiqueta);
    }

    @Override
    public double getVolumen() {
        return ancho*alto*fondo*0.9;
    }

    @Override
    public double getPrecio() {
        return 0.9*super.getPrecio();
    }
}
