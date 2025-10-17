import java.awt.*;
import javax.swing.*;

public class ejercicio5 {
    public static void main(String[] args) {
        // Crear la ventana usando AWT
        Frame awtFrame = new Frame("Ventana AWT");
        awtFrame.setSize(300, 200);  // Establecer tamaño de 300x200
        awtFrame.setLayout(new FlowLayout());  // Layout para centrar el contenido
        awtFrame.add(new Label("Esta es una ventana creada con AWT"));  // Añadir un mensaje
        awtFrame.setVisible(true);  // Hacer visible la ventana

        // Evento para cerrar la ventana AWT
        awtFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Crear la ventana usando Swing
        JFrame swingFrame = new JFrame("Ventana Swing");
        swingFrame.setSize(300, 200);  // Establecer tamaño de 300x200
        swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar al salir
        swingFrame.setLayout(new FlowLayout());  // Layout para centrar el contenido
        swingFrame.add(new JLabel("Esta es una ventana creada con Swing"));  // Añadir un mensaje
        swingFrame.setVisible(true);  // Hacer visible la ventana
    }
}