import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JButton btnSaludar;
    private JPanel ventana;

    public VentanaPrincipal() {
        super("VentanaPrincipal");

        // Inicializamos los componentes
        ventana = new JPanel();
        btnSaludar = new JButton("Saludar");

        // Agregamos el botón al panel
        ventana.add(btnSaludar);

        // Establece el contenido del JFrame como el panel
        this.setContentPane(ventana);

        // Define qué hacer cuando se cierre la ventana: terminar el programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 200); // Establece el tamaño de la ventana

        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        this.setVisible(true); // Hace visible la ventana
    }


}
