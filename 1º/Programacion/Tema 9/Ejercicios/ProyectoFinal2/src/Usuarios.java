public class Usuarios {
    private String nombre;
    private int numero;
    private String correo;
    private String foto;

    public Usuarios(String nombre, int numero, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
        this.foto = "";
    }

    public Usuarios(String nombre, int numero, String correo, String foto) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
        this.foto = foto;
    }

    public String getNombre() { return nombre; }
    public int getNumero() { return numero; }
    public String getCorreo() { return correo; }
    public String getFoto() { return foto; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setFoto(String foto) { this.foto = foto; }
}