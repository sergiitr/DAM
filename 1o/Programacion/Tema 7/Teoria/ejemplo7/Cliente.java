public class Cliente {
    public Cliente(String DNI, String nombre, int tlfn) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.tlfn = tlfn;
    }
    
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTlfn() {
        return tlfn;
    }
    public void setTlfn(int tlfn) {
        this.tlfn = tlfn;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("DNI=").append(DNI);
        sb.append(", nombre=").append(nombre);
        sb.append(", tlfn=").append(tlfn);
        sb.append('}');
        return sb.toString();
    }

    private String DNI;
    private String nombre;
    private int tlfn;

}
