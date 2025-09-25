package proyecto;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
    private List<Persona> personas;
    private List<String> nombreMujer;
    private List<String> nombreHombre;
    private List<String> apellidos;
    private List<String> dominiosEmail;

    public ListaPersonas() {  }

    private List<String> loadStrings (String fileName) throws IllegalAccessException {
        List<String> lista = new ArrayList<String>();
        Path pathArchivo = Paths.get(fileName);
    
        if(!Files.exists(pathArchivo)) 
            throw new IllegalAccessException("El archivo no existe");
        
        if (!Files.isReadable(pathArchivo)) 
            throw new IllegalAccessException("No tienes permiso de lectura");
        
        return lista;
    }

    public void loadData(String nombrearchivoMujeres, String nombrearchivoHombres, String nombrearchivoApellidos,  String nombrearchivoEmail) {
        try {
            this.nombreMujer = loadStrings(nombrearchivoMujeres);
            this.nombreHombre = loadStrings(nombrearchivoHombres);
            this.apellidos = loadStrings(nombrearchivoApellidos);
            this.dominiosEmail = loadStrings(nombrearchivoEmail);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void generaPersonas(int npersonas) {
        if (this.dominiosEmail == null || this.nombreHombre == null || this.nombreMujer == null || this.apellidos == null)
            throw new IllegalStateException("Generador de personas: primero hay que cargar la lista de datos");
        
        if (npersonas<1 || npersonas>1000000)
            throw new IllegalStateException("El numero de persoans debe ser entre 1 y 1M");
        
        this.personas = new ArrayList<Persona>();

        for (int i = 0; i < npersonas; i++) {
            personas.add(generaPersonas());
        }
    }

    Persona generaPersonas() {
        Persona p = new Persona();
        p.setApellidos(apellidos.get(dado(apellidos.size())) + " " + apellidos.get(dado(apellidos.size())) );
        
        Genero[] gen = Genero.values();
        p.setGenero(gen[dado(gen.length)]);

        switch (p.getGenero()) {
            case MASCULINO:
                p.setNombre(nombreHombre.get( dado(nombreHombre.size())));
                break;
            case FEMENINO:
                p.setNombre(nombreMujer.get(dado(nombreMujer.size())));
                break;
            default:
                int numeroNombre = dado (nombreMujer.size() + nombreHombre.size());
                p.setNombre(
                    numeroNombre<nombreMujer.size() ?
                    nombreMujer.get(numeroNombre) :
                    nombreHombre.get(numeroNombre-nombreMujer.size())
                );
                break;
        }
        /**
         * Email con 3 primeras letras del nombre y los apellidos completo
         * Todas las letras en minuscula. Se quitan los acentos y los caracteres especiales se cambian
         *      ç -> c
         *      ñ -> n
         */

        return p;
    }

    public int dado (int caras) {
        return (int) Math.floor(Math.random()*(caras-1));
    }
}
