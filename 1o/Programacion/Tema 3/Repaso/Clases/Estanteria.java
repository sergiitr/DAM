public class Estanteria {
    public Estanteria(){
    }
    public Estanteria(int librosGuardados) {
        this.librosGuardados = librosGuardados;
    }
    public Libros[] getLibros() {
        return libros;
    }

    public void setLibros(Libros[] libros) {
        this.libros = libros;
    }
    public String guardarLibro(Libro libro) {
        if(librosGuardados<CANT_LIBROS) {
            libros[librosGuardados]=libro;
        }
        return "Libro "+libro.titulo()+" guardado";
    }
    public boolean sacarLibro(Libro libro) {
        int auxiliar;
        
        for (int i=0; i<librosGuardados;i++) {
            if (libro.equals(this.libros[i])){
                this.libros[i]=null;
                auxiliar=i;
            }
        }
        for (int i=auxiliar; i<librosGuardados;i++) {
            this.libros[i] =this.libros[i+1];
        }
        librosGuardados-=1;

    }

    private final int CANT_LIBROS=10;
    private Libros[] libros=new Libros[CANT_LIBROS];
    private int librosGuardados;

    
}
