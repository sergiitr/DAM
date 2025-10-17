import java.util.Scanner;

public class ejercicio2 {
    /**
     * Obtenemos la cantidad de letras de un string
     * @param cadena
     * @return contador
     */
    public static int obtenerNumeroDeLetras(String cadena) {
        int contador=0;
        for(int i=0; i<cadena.length();i++){
            if (Character.isLetter(cadena.charAt(i)) ) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Saber si empieza por vocal
     * @param cadena
     * @return true si empieza en vocal, false si no
     */
    public static boolean empiezaPorVocal(String cadena) {
        return cadena.charAt(0)=='a' || cadena.charAt(0)=='e' || cadena.charAt(0)=='i' || cadena.charAt(0)=='o' || cadena.charAt(0)=='u';
    }

    /**
     * Saber si acaba por vocal
     * @param cadena
     * @return true si acaba en vocal, false si no
     */
    public static boolean acabaPorVocal(String cadena) {
        int ultimoCaracter = cadena.length()-1;
        return cadena.charAt(ultimoCaracter)=='a' || cadena.charAt(ultimoCaracter)=='e' || cadena.charAt(ultimoCaracter)=='i' || cadena.charAt(ultimoCaracter)=='o' || cadena.charAt(ultimoCaracter)=='u';
    }

    /**
     * Cantidad de vocales que hay en una cadena
     * @param cadena
     * @return
     */
    public static int cantidadVocales(String cadena) {
        int cantidad=0;
        int longCadena = cadena.length();

        for (int i = 0; i < longCadena; i++)
            if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o' || cadena.charAt(i) == 'u') 
                cantidad+=1;

        return cantidad;
    }

    /**
     * Saber si una letra esta en el string
     * @param letra
     * @param cadena
     * @return true si existe, false si no
     */
    public static boolean contieneLetra(char letra, String cadena) {
        int longitud=cadena.length();
        for (int i=0; i<longitud;i++) 
            if(cadena.charAt(i)==letra) 
                return true;

        return false;
    }

    /**
     * Saber si una cadena es palindromo
     * @param cadena
     * @return true si es, false si no
     */
    public static boolean esPalindromo(String cadena) {
        int longitud=cadena.length();
        for (int i=0; i<(int)longitud/2; i++)
            if (cadena.charAt(i) != cadena.charAt(longitud-(i+1))) 
                return false;
            
        return true;
    }


    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;

        System.out.print("Introduzca la frase: ");
        frase=sc.nextLine();

        frase=frase.toLowerCase();
        frase=frase.replace(" ", "");

        int cantLetras=obtenerNumeroDeLetras(frase);
        System.out.println("Hay "+cantLetras+" letras");

        if(empiezaPorVocal(frase)==true) 
            System.out.println("Empieza por vocal");
        else 
            System.out.println("No empieza por vocal");

        if(acabaPorVocal(frase)==true) 
            System.out.println("Acaba por vocal");
        else
            System.out.println("No acaba por vocal");
        
        System.out.println("Hay un total de "+cantidadVocales(frase)+" vocales");

        if (esPalindromo(frase) == true)
            System.out.println("Es palindromo");
        else
            System.out.println("No es palindromo");

        char letra;
        do { 
            System.out.print("Introduzca letra: ");
            letra = sc.nextLine().charAt(0);
        } while (!Character.isLetter(letra));
        
        if (contieneLetra(letra, frase) == true) {
            System.out.println("Contiene la letra");
        } else
            System.out.println("No contiene la letra");
    }
}
