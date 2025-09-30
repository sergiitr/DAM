package com.iesvdc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
    // atributo con la lista "actual" de personas
    // esta es la información que me interesa
    private List<Persona> personas;
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    // atributos para el generador
    // es algo temporal para generar personas aleatorias
    private List<String> nombresMujer;
    private List<String> nombresHombre;
    private List<String> apellidos;
    private List<String> dominiosEmail;


    /**
     * Carga en una lista las líneas de un archivo
     * @param filename
     * @return
     */
    private List<String> loadStrings(String filename){
        Path pathArchivo = Paths.get(filename);
        if (!Files.exists(pathArchivo)) 
            throw new IllegalArgumentException( "El archivo: "+ filename +" no existe.");
        
        if (!Files.isReadable(pathArchivo))
            throw new IllegalArgumentException( "No tiene permiso para leer el archivo: " + filename );

        try {
            return Files.readAllLines(pathArchivo);
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo el archivo: " + filename, e);
        }
    }

    /**
     * Carga en memoria las listas de datos necesarias para generar personas.
     * Cada parámetro debe ser la ruta a un fichero de texto donde cada línea contiene un dato (nombre, apellido o dominio de email).
     * Si alguno de los archivos no existe o no se puede leer, se lanzará una excepción.
     *
     * @param nombreArchivoMujeres   ruta del archivo con nombres femeninos (uno por línea).
     * @param nombreArchivoHombres   ruta del archivo con nombres masculinos (uno por línea).
     * @param nombreArchivoApellidos ruta del archivo con apellidos (uno por línea).
     * @param nombreArchivoEmails    ruta del archivo con dominios de email (uno por línea).
     * 
     * @throws IllegalArgumentException si algún archivo no existe o no se puede leer.
     * @throws RuntimeException         si ocurre un error al leer el contenido de un archivo.
     */
    public void loadData(String nombreArchivoMujeres,  String nombreArchivoHombres, String nombreArchivoApellidos, String nombreArchivoEmails) {
        this.nombresMujer = loadStrings(nombreArchivoMujeres);
        this.nombresHombre = loadStrings(nombreArchivoHombres);
        this.apellidos = loadStrings(nombreArchivoApellidos);
        this.dominiosEmail = loadStrings(nombreArchivoEmails);
    }

    public int dado(int caras) { 
        return (int) Math.floor(Math.random()*(caras));
    }


    /**
     * Genera una lista de personas aleatorias y la almacena en el atributo personas.
     * Este método utiliza las listas de nombres, apellidos y dominios de email previamente cargadas mediante loadData para crear objetos Persona. 
     * Cada persona tendrá un nombre, apellidos, email, teléfono, género, DNI y fecha de nacimiento.
     * 
     * El número de personas a generar debe estar entre 1 y 1.000.000. 
     * Si las listas de datos no se han cargado previamente, se lanzará una excepción.
     * Si el número de personas está fuera del rango válido, se lanzará otra excepción.
     *
     * @param nPersonas el número de personas a generar. Debe estar entre 1 y 1.000.000.
     * 
     * @throws IllegalStateException    si las listas de datos (nombres, apellidos o emails) no han sido cargadas.
     * @throws IllegalArgumentException si {@code nPersonas} es menor que 1 o mayor que 1.000.000.
     */
    public void generaPersonas(int nPersonas){
        if(this.dominiosEmail == null || this.nombresHombre == null || this.nombresMujer == null || this.apellidos == null )
            throw new IllegalStateException(  "Generador de personas: primero hay que cargar las listas de datos");
        
        if (nPersonas<1 || nPersonas> 1000000)
            throw new IllegalArgumentException("El número de personas debe estar entre 1 y un millón.");
        
        this.personas = new ArrayList<Persona>();
        for (int i = 0; i < nPersonas; i++) 
            personas.add(generaPersona());  
    }

    /**
     * Crea y devuelve una persona aleatoria.
     * Este método genera una persona con:
     * - Apellidos combinando dos apellidos aleatorios de la lista cargada.
     * - DNI válido con letra.
     * - Fecha de nacimiento aleatoria.
     * - Género seleccionado al azar entre los definidos en la enumeración Genero.
     * - Nombre acorde al género (masculino, femenino o aleatorio si es otro/neutral).
     * - Email generado a partir del nombre y apellidos.
     * - Teléfono aleatorio dentro de un rango válido.
     * 
     * @return p, el objeto Persona completamente inicializado listo para usar.
     */
    Persona generaPersona(){
        Persona p = new Persona();
        p.setApellidos( apellidos.get(dado(apellidos.size())) + " " + apellidos.get(dado(apellidos.size())) );
        p.setDni(generarDni());
        p.setFechaNacimiento(generarFechaNacimiento());

        Genero[] generos = Genero.values();
        p.setGenero(generos[dado(generos.length)]);
        switch (p.getGenero()) {
            case MASCULINO:
                p.setNombre( nombresHombre.get(dado(nombresHombre.size()) ));
                break;
            case FEMENINO:
                p.setNombre( nombresMujer.get(dado(nombresMujer.size())) );
                break;
            default:
                int numeroNombre = dado( nombresMujer.size()+nombresHombre.size() );                
                p.setNombre( numeroNombre < nombresMujer.size() ? nombresMujer.get(numeroNombre) : nombresHombre.get(numeroNombre-nombresMujer.size()) );
                break;
        }
        p.setEmail(generaEmail(p));
        p.setTelefono( String.valueOf( 600000000+ dado(200000000)));
        return p;
    }


    private String generarDni() {
        int numero = (int)(Math.random() * 100_000_000); 
        char letra = LETRAS_DNI.charAt(numero % 23);
        return String.format("%08d%c", numero, letra);
    }

    private String generarFechaNacimiento() {
        int anio = 1970 + (int)(Math.random() * (2005 - 1970 + 1));
        int mes = 1 + (int)(Math.random() * 12);
        int diaMax = java.time.Month.of(mes).length(java.time.Year.isLeap(anio));
        int dia = 1 + (int)(Math.random() * diaMax);
        java.time.LocalDate fecha = java.time.LocalDate.of(anio, mes, dia);
        return fecha.toString(); // yyyy-MM-dd
    }



    /**
     * Email un substring con 1 primera letras del nombre y tres primeras letras de los dos apellidos.
     * Todas las letras en minúscula. Se quitan los acentos y los caracteres especiales se cambian, ejemplo:
     * - ñ -> n
     * - ç -> c
     */
    private String generaEmail(Persona p){
        String email;
        String nombre = p.getNombre();
                
        String[] apellidos = Normalizer.normalize( p.getApellidos(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").split(" ");

        email = nombre.substring(0,1);
        for (String apellido : apellidos)
            email+=apellido.substring(0, 3);
        
        email+=dominiosEmail.get(dado(dominiosEmail.size()));
        return email;
    }

    public List<Persona> getPersonas() { return this.personas; }

    public void setPersonas(List<Persona> personas) { this.personas = personas; }

    public List<String> getNombresMujer() { return this.nombresMujer; }

    public void setNombresMujer(List<String> nombresMujer) { this.nombresMujer = nombresMujer; }

    public List<String> getNombresHombre() { return this.nombresHombre; }

    public void setNombresHombre(List<String> nombresHombre) { this.nombresHombre = nombresHombre; }

    public List<String> getApellidos() { return this.apellidos; }

    public void setApellidos(List<String> apellidos) { this.apellidos = apellidos; }

    public List<String> getDominiosEmail() { return this.dominiosEmail; }

    public void setDominiosEmail(List<String> dominiosEmail) { this.dominiosEmail = dominiosEmail; }
}
