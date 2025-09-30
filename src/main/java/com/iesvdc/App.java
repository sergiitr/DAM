package com.iesvdc;

/**
 * @author Sergio Trillo Rodriguez 
 *
 */
public class App {
    public static final int CARAS = 6;
    public static int[] numeros= new int[CARAS];

    public static void main( String[] args ) {
        System.out.println("Cargando datos de personas");
        ListaPersonas lp = new ListaPersonas();
        lp.loadData( "datos/nombre_mujeres.txt", "datos/nombre_hombres.txt", "datos/apellidos.txt", "datos/all_email.txt" );
        lp.generaPersonas(100); // generamos 100 pero mostraremos solo 10

        System.out.println("[");
        int total = Math.min(10, lp.getPersonas().size());
        for (int i = 0; i < total; i++) {
            Persona persona = lp.getPersonas().get(i);
            System.out.print("  {");
            System.out.print("\"nombre\":\"" + persona.getNombre() + "\",");
            System.out.print("\"apellidos\":\"" + persona.getApellidos() + "\",");
            System.out.print("\"dni\":\"" + persona.getDni() + "\",");
            System.out.print("\"email\":\"" + persona.getEmail() + "\",");
            System.out.print("\"telefono\":\"" + persona.getTelefono() + "\",");
            System.out.print("\"genero\":\"" + persona.getGenero() + "\",");
            System.out.print("\"fechaNacimiento\":\"" + persona.getFechaNacimiento() + "\"");
            System.out.print("}");
            if (i < total - 1) 
                System.out.println(",");
        }
        System.out.println("\n]");

    }
}
