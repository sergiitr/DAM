/**
 * @author Sergio Trillo Rodriguez
 */
import java.util.regex.*;
public class RealizaOperacion {
    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println("Error en los parámetros");
        else {
            // La operación viene como un solo String (ej: "( + 3 5 )")
            String operacion = String.join(" ", args).trim();
            // Expresión regular -> ( operador entero entero )
            Pattern p = Pattern.compile("^\\(\\s*([+\\-*:])\\s*(-?\\d+)\\s*(-?\\d+)\\s*\\)$");
            Matcher m = p.matcher(operacion);

            if (!m.matches())
                System.out.println("Error en los parámetros");
            else {
                try {
                    String operador = m.group(1);
                    int a = Integer.parseInt(m.group(2));
                    int b = Integer.parseInt(m.group(3));

                    if (operador.equals("+"))
                        System.out.println("Resultado: " + (a + b));
                    else if (operador.equals("-"))
                        System.out.println("Resultado: " + (a - b));
                    else if (operador.equals("*"))
                        System.out.println("Resultado: " + (a * b));
                    else if (operador.equals(":")) {
                        if (b == 0)
                            System.out.println("Error: división por cero");
                        else
                            System.out.println("Resultado: " + (a / b));
                    } else
                        System.out.println("Error en los parámetros");
                } catch (Exception e) {
                    System.out.println("Error en los parámetros");
                }
            }
        }
    }
}
