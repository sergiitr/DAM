public class Alimento extends ProductoGenerico{
    public Alimento(String numReferencia, Alimentos alimentos, boolean tipoAlimento, Alimentos tipoDeAlimento) {
        super(numReferencia, alimentos, tipoAlimento);
        this.tipoDeAlimento = tipoDeAlimento;
    }
    
    public Alimentos getTipoDeAlimento() {
        return tipoDeAlimento;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alimento:").append(super.numReferencia);
        sb.append("Alimentario=").append(super.tipoProducto);
        sb.append("tipoDeAlimento=").append(tipoDeAlimento);
        return sb.toString();
    }
    
    protected Alimentos tipoDeAlimento;
}
