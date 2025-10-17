public class ProductoGenerico implements Producto {
    public ProductoGenerico(String numReferencia, Alimentos alimentos, boolean tipoAlimento) {
        this.numReferencia = numReferencia;
        this.alimentos = alimentos;
        this.tipoProducto = tipoAlimento;
    }

    
    public String getNumReferencia() {
        return numReferencia;
    }


    public void setNumReferencia(String numReferencia) {
        this.numReferencia = numReferencia;
    }


    public Alimentos getAlimentos() {
        return alimentos;
    }


    public void setAlimentos(Alimentos alimentos) {
        this.alimentos = alimentos;
    }


    @Override
    public double precioFinal(){
        return 1;
    }

    @Override
    public double precioTotal() {
        return 0;
    }

    protected String numReferencia;
    protected Alimentos alimentos;
    protected boolean tipoProducto;
}
