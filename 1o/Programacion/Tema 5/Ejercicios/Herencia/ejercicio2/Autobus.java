public class Autobus extends Vehiculos {
    public Autobus(int numeroPlazas, String matricula, String modelo, int potenciaCV) {
        super(matricula, modelo, potenciaCV);
        this.numeroPlazas = numeroPlazas;
    }
    
    public int getNumeroPlazas() {
        return numeroPlazas;
    }
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }
    
    @Override
    public double getImpuestoCirculacion() {
        double impuestoCirculacionAct = super.impuestoCirculacion+super.impuestoCirculacion*0.2;
        return impuestoCirculacionAct;
    }

    @Override
    public String toString() {
        return "Autobus [impuestoCirculacion=" + impuestoCirculacion + ", matricula=" + matricula + ", modelo=" + modelo + ", potenciaCV=" + potenciaCV + "]";
    }

    private int numeroPlazas;
}
