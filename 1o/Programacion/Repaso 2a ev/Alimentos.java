public enum Alimentos {
    PRODUCTO_PANADERIA,
    ACEITE,
    LICOR;

    public IVA getAlimentos() {
        switch (this) {
            case PRODUCTO_PANADERIA: return IVA.SUPEREDUCIDO;
            case ACEITE: return IVA.REDUCIDO;
            case LICOR: return IVA.GENERAL;
            default: return IVA.GENERAL;
        }
    }
}
