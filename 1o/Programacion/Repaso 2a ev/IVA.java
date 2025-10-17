public enum IVA {
    GENERAL,
    REDUCIDO,
    SUPEREDUCIDO;

    public double getIVA() {
        switch (this) {
            case GENERAL: return 0.21;
            case REDUCIDO: return 0.1;
            case SUPEREDUCIDO: return 0.04;
            default: return 0.21;
        }
    }

    
}
