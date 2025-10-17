public class Vehiculos {
    public Vehiculos(String matricula, String modelo, int potenciaCV) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.potenciaCV = potenciaCV;
        this.impuestoCirculacion = 100;
    }
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getPotenciaCV() {
        return potenciaCV;
    }
    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }
    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }
    public void setImpuestoCirculacion(int impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculos{");
        sb.append("impuestoCirculacion=").append(impuestoCirculacion);
        sb.append(", matricula=").append(matricula);
        sb.append(", modelo=").append(modelo);
        sb.append(", potenciaCV=").append(potenciaCV);
        sb.append('}');
        return sb.toString();
    }

    protected int impuestoCirculacion;
    protected String matricula;
    protected String modelo;
    protected int potenciaCV;
}
