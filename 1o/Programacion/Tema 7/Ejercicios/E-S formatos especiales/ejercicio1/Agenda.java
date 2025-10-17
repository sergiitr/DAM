public class Agenda {
    public Agenda(String nombre, String apellido, int tlfn, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tlfn = tlfn;
        this.mail = mail;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTlfn() {
        return tlfn;
    }

    public void setTlfn(int tlfn) {
        this.tlfn = tlfn;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agenda{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", tlfn=").append(tlfn);
        sb.append(", mail=").append(mail);
        sb.append('}');
        return sb.toString();
    }
    
    private String nombre;
    private String apellido;
    private int tlfn;
    private String mail;

}
