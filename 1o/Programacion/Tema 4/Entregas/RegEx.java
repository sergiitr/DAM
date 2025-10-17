/**
 * RegEx Helper
 * @author Sergio Trillo
 */
import java.util.regex.*;

public class RegEx {
    /**
     * Método para validar el formato de un DNI (8 dígitos y una letra)
     * @param dni
     * @return true si es valido, false si no lo es
     */
    public static boolean validarDNI(String dni) {
        String regex = "\\d{8}[A-Za-z]";
        return Pattern.matches(regex, dni);
    }

    /**
     * Método para validar el formato de un pasaporte (3 letras y 6 dígitos)
     * @param pasaporte
     * @return true si es valido, false si no lo es
     */
    public static boolean validarPasaporte(String pasaporte) {
        String regex = "[A-Za-z]{3}\\d{6}";
        return Pattern.matches(regex, pasaporte);
    }

    /**
     * Método para validar el formato de un código IBAN de cuentas bancarias en España (ES más 22 dígitos)
     * @param iban
     * @return true si es valido, false si no lo es
     */
    public static boolean validarIBAN(String iban) {
        String regex = "ES\\d{2}(\\s|\\-)?\\d{4}(\\s|\\-)?\\d{4}(\\s|\\-)?\\d{2}(\\s|\\-)?\\d{10}";
        return Pattern.matches(regex, iban.replaceAll("[\\s\\-]", ""));
    }

    /**
     * Método para validar números de teléfonos en España (6, 7 o 9 seguido de 8 dígitos)
     * @param telefono
     * @return true si es valido, false si no lo es
     */
    public static boolean validarTlfnEspana(String telefono) {
        String regex = "(\\+34)?[6|7|9]\\d{8}";
        return Pattern.matches(regex, telefono.replaceAll("[\\s\\-]", ""));
    }

    /**
     * Método para validar fechas en formatos dd/mm/yyyy o dd-mm-yyyy
     * @param fecha
     * @return true si es valido, false si no lo es
     */
    public static boolean validarFechas(String fecha) {
        String regex = "\\d{2}[\\/\\-]\\d{2}[\\/\\-]\\d{4}";
        return Pattern.matches(regex, fecha);
    }

    public static void main(String[] args) {
        System.out.println("Validar DNI:");
        System.out.println("12345678Z: "+validarDNI("12345678Z"));
        System.out.println("1234A: "+validarDNI("1234A")); 

        System.out.println("\nValidar Pasaporte:");
        System.out.println("ABC123456: "+validarPasaporte("ABC123456"));
        System.out.println("A1C123: "+validarPasaporte("A1C123"));

        System.out.println("\nValidar IBAN:");
        System.out.println("ES9121000418450200051332: "+validarIBAN("ES9121000418450200051332"));      
        System.out.println("ES91 21 0004 1845 02 00051332: "+validarIBAN("ES91 21 0004 1845 02 00051332"));
        System.out.println("ES91-21-0004-1845-02-00051332: "+validarIBAN("ES91-21-0004-1845-02-00051332"));
        System.out.println("ES21: "+validarIBAN("ES21"));                     

        System.out.println("\nValidar Teléfono en España:");
        System.out.println("+34612345678: "+validarTlfnEspana("+34612345678"));
        System.out.println("612345678: "+validarTlfnEspana("612345678"));   
        System.out.println("812345678: "+validarTlfnEspana("812345678"));

        System.out.println("\nValidar Fechas:");
        System.out.println("10/10/2000: "+validarFechas("10/10/2000"));
        System.out.println("21-12-2001: "+validarFechas("21-12-2001"));
        System.out.println("21/12-2001: "+validarFechas("21/12-2001"));
        System.out.println("21/12-01: "+validarFechas("21/12-01"));
    }
}
