public class Ajedrez {
    public Ajedrez(int posicion, String nombre, String federacion, double elo ) {
        this.elo = elo;
        this.federacion = federacion;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFederacion() {
        return federacion;
    }

    public void setFederacion(String federacion) {
        this.federacion = federacion;
    }

    public double getElo() {
        return elo;
    }

    public void setElo(double elo) {
        this.elo = elo;
    }
    
    private int posicion;
    private String nombre;
    private String federacion;
    private double elo;
}