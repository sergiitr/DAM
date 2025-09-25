package proyecto;

import java.util.regex.Pattern;

public class Persona {
    private String nombre;
    private String apellidos;
    private String tlfn;
    private String email;
    private String empresa;
    private Genero genero;

    private final Pattern PATRON_EMAIL = Pattern.compile("^[A-Za-z0-9+,-._]+@[A-Za-z0-9-]+.[A-Za-z]{2,}$");
    private final Pattern PATRON_MOVIL = Pattern.compile("^[+]?[0-9]{5,12}");

    public Persona() { }

    public Persona(String nombre, String apellidos, String tlfn, String email, String empresa, Genero genero) {
        if (!PATRON_EMAIL.matcher(email).matches())
            throw new IllegalArgumentException("Correo con formato no valido");
        
        if (!PATRON_MOVIL.matcher(tlfn).matches())
            throw new IllegalArgumentException("Telefono con formato no valido");
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tlfn = tlfn;
        this.email = email;
        this.empresa = empresa;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        if (!PATRON_MOVIL.matcher(tlfn).matches())
            throw new IllegalArgumentException("Telefono con formato no valido");
        
        this.tlfn = tlfn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!PATRON_EMAIL.matcher(email).matches())
            throw new IllegalArgumentException("Correo con formato no valido");
        
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", tlfn=" + tlfn + ", email=" + email + ", empresa=" + empresa + ", genero=" + genero + "]";
    }
}
