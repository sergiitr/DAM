public abstract class Caja {
    public Caja(int ancho, int alto, int fondo, String etiqueta) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.etiqueta = etiqueta;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getFondo() {
        return fondo;
    }
    public void setFondo(int fondo) {
        this.fondo = fondo;
    }
    public String getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public double getVolumen() {
        return ancho*alto*fondo;
    }

    public double getPrecio() {
        return 5;
    }

    protected int ancho;
    protected int alto;
    protected int fondo;
    private String etiqueta;
}
