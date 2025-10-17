public class AceiteOliva extends Alimento implements Comparable<Alimento> {
    public AceiteOliva(String numReferencia, Alimentos alimentos, boolean tipoAlimento, Alimentos tipoDeAlimento, IVA ivaAplicado, String marca, double precioSinIVA) {
        super(numReferencia, alimentos, tipoAlimento, tipoDeAlimento);
        this.ivaAplicado = ivaAplicado;
        this.marca = marca;
        this.precioSinIVA = precioSinIVA;
    }

    public IVA getIvaAplicado() {
        return ivaAplicado;
    }
    public String getMarca() {
        return marca;
    }
    public double getPrecioSinIVA() {
        return precioSinIVA;
    }
    @Override
    public double precioFinal(){
        double precioFinal=this.precioSinIVA+this.precioSinIVA*ivaAplicado.getIVA();
        return precioFinal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Alimento: ").append(super.numReferencia);
        if (super.tipoProducto==true)
            sb.append(", Alimentario=").append("Si");
        else
            sb.append(", Alimentario=").append("No");
        sb.append(", tipoDeAlimento=").append(super.tipoDeAlimento);
        sb.append(", ").append(marca);
        sb.append(", Precio sin IVA: ").append(precioSinIVA+"€");
        sb.append(", Precio con IVA: ").append(precioFinal()+"€");
        sb.append(", Precio total: ").append(precioTotal()+"€");
        sb.append("} ");
        return sb.toString();
    }

    @Override
    public int compareTo(Alimento otroALimento) {
        if (this.precioFinal() > otroALimento.precioFinal())
            return 1;
        else if (this.precioFinal() < otroALimento.precioFinal())
            return -1;
        else 
            return 0;
    }


    @Override
    public double precioTotal() {
        this.preciototal+=precioFinal();
        return this.preciototal;
    }

    private double preciototal;
    private IVA ivaAplicado;
    private String marca;
    private double precioSinIVA;

}
