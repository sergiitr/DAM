public class Taxi extends Vehiculos {
    public Taxi(String matricula, String modelo, int potenciaCV, int numeroLicencia) {
        super(matricula, modelo, potenciaCV);
        this.numeroLicencia = numeroLicencia;
    }
    
    public int getNumeroLicencia() {
        return numeroLicencia;
    }
    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    @Override
    public double getImpuestoCirculacion() {
        double impuestoCirculacionAct = super.impuestoCirculacion+super.impuestoCirculacion*0.1;
        return impuestoCirculacionAct;
    }

    @Override
    public String toString() {
        return "Taxi [impuestoCirculacion=" + impuestoCirculacion + ", matricula=" + matricula + ", modelo=" + modelo + ", potenciaCV=" + potenciaCV + "]";
    }

    private int numeroLicencia;
}
