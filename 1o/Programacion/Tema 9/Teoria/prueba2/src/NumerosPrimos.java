import javax.swing.*;

public class NumerosPrimos {
    private JButton botonComprobar;
    private JPanel panel;

    public NumerosPrimos() {
        JFrame frame = new JFrame("VentanaPrincipal");

        // Establece el contenido del JFrame como el panel diseñado en el formulario
        frame.setContentPane(panel);

        // Define qué hacer cuando se cierre la ventana: terminar el programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 200); // Establece el tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        frame.setVisible(true); // Hace visible la ventana


        botonComprobar.addActionListener(e -> {
                String num = JOptionPane.showInputDialog(frame, "Introduce un numero: ");
                try {
                    if(Integer.parseInt(num)%2==0)
                        JOptionPane.showMessageDialog(frame, "Es par");
                    else if (Integer.parseInt(num)%2==1)
                        JOptionPane.showMessageDialog(frame, "Es impar");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,"No es un numero");
                }
            }
        );
    }
}
