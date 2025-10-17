
public class Claustro {
    public Claustro(String nombre_centro_educativo) {
        this.nombre_centro_educativo = nombre_centro_educativo;
    }

    public void anadirProfesor(Profesor profesor) {
        int contadorAux=0;
        for (int i = 0; i < contador_profesores; i++) {
            if (this.profesores[i].DNI.equals(profesor.DNI)) {
                contadorAux++;
            }
        }
        if(contadorAux==0){
            this.profesores[contador_profesores]=profesor;
            contador_profesores++;
            System.out.println("Profesor añadido");
        } else {
            System.out.println("No se puede añadir ese profesor, DNI repetido");
        }
    }

    public void borrarProfesor(Profesor profesor) {
        for (int i=0; i<contador_profesores; i++) 
            if (this.profesores[i].DNI.equals(profesor.DNI)) {
                this.profesores[i]=null;
                System.out.println("Profesor borrado");
            }
        
        for (int i=0; i<contador_profesores-1; i++) 
            if (this.profesores[i] == null) {
                this.profesores[i]=this.profesores[i+1];
                this.profesores[i+1]=null;
            }
        
        contador_profesores-=1;
    }

    public void buscarPorDNI(String DNI) {
        for (int i=0; i<contador_profesores; i++)
            if (this.profesores[i].DNI.equals(DNI))
                System.out.println(this.profesores[i].toString());
    }

    public void listarProfesores() {
        for (int i=0; i<contador_profesores; i++) 
            System.out.println(this.profesores[i].toString());
    }

    public String getNombre_centro_educativo() {
        return nombre_centro_educativo;
    }

    public void setNombre_centro_educativo(String nombre_centro_educativo) {
        this.nombre_centro_educativo=nombre_centro_educativo;
    }

    public double edad_media() {
        int sumatorioEdad=0;
        for (int i=0; i<contador_profesores; i++) {
            sumatorioEdad += (2025-profesores[i].fechaNacimiento);
        }
        double edadMedia=sumatorioEdad / contador_profesores;
        return edadMedia;
    }
    
    public void profesorMasAntiguedad() {
        int anio_aux = Integer.MAX_VALUE;
        ProfesorTitular aux = null;
    
        for (int i = 0; i < contador_profesores; i++) {
            if (this.profesores[i] instanceof ProfesorTitular) {
                ProfesorTitular profesorTitular = (ProfesorTitular) this.profesores[i];
                int anioIncorporacion = profesorTitular.getAnio_incorporacion();
                if (anioIncorporacion < anio_aux) {
                    aux = profesorTitular;
                    anio_aux = anioIncorporacion;
                }
            }
        }
        
        if (aux != null) 
            System.out.println("El profesor más veterano es: " + aux.toString());
        else 
            System.out.println("No hay profesores para mostrar.");
    }
    
    
    public int profesoresPorEspecialidad(String especialidad) {
        int cont=0;
        for (int i=0; i<contador_profesores; i++)
            if (this.profesores[i].especialidad.equals(especialidad))
                cont++;
        
        return cont;
    }

    private String nombre_centro_educativo;
    private Profesor[] profesores=new Profesor[100];
    private int contador_profesores;
}
