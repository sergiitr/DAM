import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculadora {
    private JPanel panel1;
    private JTextField Salida;
    private JButton num7;
    private JButton num0;
    private JButton botDiv;
    private JButton num8;
    private JButton num9;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton botMult;
    private JPanel panelCalc;
    private JButton num2;
    private JButton num3;
    private JButton botResta;
    private JButton botPunto;
    private JButton botIgual;
    private JButton botSuma;
    private JButton num1;

    /**
     * Método auxiliar para evaluar una expresión simple
     * @param expr
     * @return valor
     */
    private double calcular(JFrame frame, String expr) {
        try {
            expr = expr.replaceAll(" ", "");

            if (expr.isEmpty()) {
                return 0;
            }

            String[] tokens = expr.split("([+\\-*/])");

            if (tokens.length == 2) {
                String operador = expr.replaceAll("[0-9.]", "");

                double num1 = Double.parseDouble(tokens[0]);
                double num2 = Double.parseDouble(tokens[1]);

                switch (operador) {
                    case "+":
                        return num1 + num2;
                    case "-":
                        return num1 - num2;
                    case "*":
                        return num1 * num2;
                    case "/":
                        if (num2 != 0) {
                            return num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(frame, "División inválida, el divisor no puede ser 0");
                            return 0;
                        }
                    default:
                        JOptionPane.showMessageDialog(frame, "Operador no válido");
                        return 0;
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Expresión inválida");
                return 0;
            }
        } catch (Exception e) {
            Salida.setText("Error en la expresión");
            return 0;
        }
    }


    public Calculadora() {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        num7.addActionListener(e -> Salida.setText(Salida.getText() + "7"));
        num8.addActionListener(e -> Salida.setText(Salida.getText() + "8"));
        num9.addActionListener(e -> Salida.setText(Salida.getText() + "9"));
        botDiv.addActionListener(e -> Salida.setText(Salida.getText() + "/"));

        num4.addActionListener(e -> Salida.setText(Salida.getText() + "4"));
        num5.addActionListener(e -> Salida.setText(Salida.getText() + "5"));
        num6.addActionListener(e -> Salida.setText(Salida.getText() + "6"));
        botMult.addActionListener(e -> Salida.setText(Salida.getText() + "*"));

        num1.addActionListener(e -> Salida.setText(Salida.getText() + "1"));
        num2.addActionListener(e -> Salida.setText(Salida.getText() + "2"));
        num3.addActionListener(e -> Salida.setText(Salida.getText() + "3"));
        botResta.addActionListener(e -> Salida.setText(Salida.getText() + "-"));

        num0.addActionListener(e -> Salida.setText(Salida.getText() + "0"));
        botPunto.addActionListener(e -> Salida.setText(Salida.getText() + "."));
        botSuma.addActionListener(e -> Salida.setText(Salida.getText() + "+"));

        botIgual.addActionListener(e -> {
            double result=0;
            try {
                String expression = Salida.getText();
                result = calcular(frame, expression);
                Salida.setText(String.valueOf(result));
            } catch (Exception ex) {
                Salida.setText("Error acumulador");
            }
        });
    }
}
