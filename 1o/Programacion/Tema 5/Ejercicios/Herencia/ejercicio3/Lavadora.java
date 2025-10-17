class Lavadora extends Electrodomestico {
    public Lavadora(double precio, String marca, double potencia) {
        super("Lavadora",marca, potencia);
        this.aguaCaliente = false;
        this.precio = precio;
    }

    public Lavadora(String marca, double potencia, double precio, boolean aguaCaliente) {
        super("Lavadora", marca, potencia);
        this.precio = precio;
        this.aguaCaliente = aguaCaliente;
    }
    
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public boolean isAguaCaliente() {
        return aguaCaliente;
    }
    public void setAguaCaliente(boolean aguaCaliente) {
        this.aguaCaliente = aguaCaliente;
    }
    
    @Override
    public double getConsumo(int hora) {
        if (this.aguaCaliente==false)
            return hora*potencia;
        else 
            return hora *(potencia+potencia*0.2);
    }
    
    @Override
    public String toString() {
        return "Lavadora [precio=" + precio + ", aguaCaliente=" + aguaCaliente + ", tipo=" + tipo + ", marca=" + marca + ", potencia=" + potencia + "]";
    }

    private double precio;
    private boolean aguaCaliente;
}
