/**
 * @author Sergio Trillo Rodriguez
 */
import java.util.regex.*;

public class RealizaOperacion {
    public static void main(String[] args) {
        boolean parametrosCorrectos = true;
        boolean divisionPorCero = false;
        int resultado = 0;

        if (args.length != 1)
            parametrosCorrectos = false;
        else {
            String operacion = args[0].trim();
            // Expresión regular: operador (+,-,*,:) seguido de dos enteros separados por espacios
            String regex = "([+\\-\\*:])\\s+(-?\\d+)\\s+(-?\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(operacion);

            if (!matcher.matches())
                parametrosCorrectos = false;
            else {
                String operador = matcher.group(1);
                int num1 = Integer.parseInt(matcher.group(2));
                int num2 = Integer.parseInt(matcher.group(3));

                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case ":":
                        if (num2 == 0) {
                            divisionPorCero = true;  // marcamos división por cero
                            parametrosCorrectos = false;
                        } else {
                            resultado = num1 / num2;
                        }
                        break;
                    default:
                        parametrosCorrectos = false;
                        break;
                }
            }
        }

        if (divisionPorCero) {
            System.out.println("Error: División por cero");
        } else if (parametrosCorrectos) {
            System.out.println(resultado);
        } else {
            System.out.println("Error en los parámetros");
        }
    }
}
