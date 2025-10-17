public enum Potencia {
    FUERTE(1.2), MEDIA(1), DEBIL(0.8);

    private double factor;

    private Potencia(double factor) {
        this.factor = factor;
    }
    
    public double getFactor() {
        return factor;
    }
}
