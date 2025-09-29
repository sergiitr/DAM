package com.iesvdc;

import java.text.Normalizer;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final int CARAS = 6;
    public static int[] numeros= new int[CARAS];
    public static void main( String[] args )
    {
        System.out.println( "Generando persona" );
        Persona p = new Persona(
            "Pepe", 
            "García",
            "pepe@sincorreo.com", 
            "12345", 
            Genero.OTRO);
        System.out.println(p.toString());

        System.out.println("Cargando datos de personas");
        ListaPersonas lp = new ListaPersonas();
        lp.loadData(
            "datos/nombre_mujeres.txt",
            "datos/nombre_hombres.txt",
            "datos/apellidos.txt",
            "datos/all_email.txt");
        lp.generaPersonas(1000000);
        for (Persona persona : lp.getPersonas()) {
            System.out.println("Persona: "+p.toString());
        }
        
        Arrays.fill(numeros, 0);
        
        /*for (int i=0; i<CARAS; i++) {
            numeros[i] = 0;
        }*/
        for (int i = 0; i < 1000; i++) {
            numeros[lp.dado(CARAS)]++;
        }
        for (int i=0; i<CARAS; i++) {
            System.out.printf(
                "Han salido %d números del número %d\n",
                numeros[i],
                i
            );
        }

        /*
        String cadena = "Canción alegría Barça";
        // cadena = cadena.replaceAll("[ç]", "c");
        cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        // cadena = "Canci´on alegr´ia Barcça";
        cadena = cadena.replaceAll("[^\\p{ASCII}]", "");
        
        System.out.println(cadena);
        */
    }
}
