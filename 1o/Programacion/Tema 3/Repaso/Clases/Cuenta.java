class Cuenta {
    public Cuenta() {
    }
    
    public Cuenta(String titular) {
        this.titular = titular;
        this.cantidad=0;
    }

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public String getTitular() {
        return titular;
    }


    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    private String titular;
    private double cantidad;
}
