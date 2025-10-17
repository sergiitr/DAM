import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

import com.google.gson.*;
import java.io.*;


public class Vista {
    private JPanel panel1;
    private JTextArea nombre1;
    private JTextArea tlfn1;
    private JTextArea correo1;
    private JTextArea nombre2;
    private JTextArea tlfn2;
    private JTextArea correo2;
    private JTextArea nombre3;
    private JTextArea tlfn3;
    private JTextArea correo3;
    private JTextArea nombre4;
    private JTextArea tlfn4;
    private JTextArea correo4;
    private JButton agregarContacto;
    private JLabel fotoLabel;
    private JButton subirFotoButton;
    private JLabel nombre;
    private JLabel telefono;
    private JLabel correo;
    private JButton eliminarContacto;
    private JButton exportar;
    private JPanel datos;
    private JButton insertarJson;
    private JButton btnEditarUsuario;


    private boolean fotoYaSubida = false;
    private JTextArea contactoActual;
    private final Map<JTextArea, ImageIcon> fotosPorContacto = new HashMap<>();

    public static String URL = "jdbc:sqlite:usuarios.db";

    public static boolean ejecutarSQLDesdeArchivo(String archivoSQL) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoSQL))) {
            StringBuilder sqlCompleto = new StringBuilder();
            String linea;

            try (Connection conexion = DriverManager.getConnection(URL)) {
                Statement stmt = conexion.createStatement();

                while ((linea = br.readLine()) != null) {
                    sqlCompleto.append(linea).append("\n");

                    if (linea.trim().endsWith(";")) {
                        try {
                            stmt.execute(sqlCompleto.toString());
                            sqlCompleto.setLength(0);
                        } catch (SQLException e) {
                            System.out.println("Error al ejecutar SQL: " + e.getMessage());
                            sqlCompleto.setLength(0);
                        }
                    }
                }
                System.out.println("SQL ejecutado exitosamente.");
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }
        return true;
    }

    public Vista() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("¡Conexión exitosa!");
            ejecutarSQLDesdeArchivo("usuarios.sql");
            System.out.println("SQL exitosa!");
            JFrame frame = new JFrame("Agenda Contactos");
            frame.setContentPane(panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(650, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            subirFotoButton.setVisible(false);

            cargarContactosDesdeDB(conexion);

            agregarContacto.addActionListener(e -> {
                if (fotoYaSubida) {
                    JOptionPane.showMessageDialog(null, "Solo se puede subir la foto después de ingresar los datos del nuevo contacto.");
                    return;
                }

                String _nombre = JOptionPane.showInputDialog(null, "Introduce nombre del artista:");
                if (_nombre == null || _nombre.trim().isEmpty()) return;

                String _tlfn = JOptionPane.showInputDialog(null, "Introduce número del artista:");
                if (_tlfn == null || _tlfn.trim().isEmpty()) return;

                String _correo = JOptionPane.showInputDialog(null, "Introduce correo del artista:");
                if (_correo == null || _correo.trim().isEmpty()) return;

                int telefonoInt;
                try {
                    telefonoInt = Integer.parseInt(_tlfn.trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El teléfono debe ser un número válido.");
                    return;
                }

                try {
                    if (insertarContactoSiVacio(nombre1, tlfn1, correo1, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;
                    if (insertarContactoSiVacio(nombre2, tlfn2, correo2, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;
                    if (insertarContactoSiVacio(nombre3, tlfn3, correo3, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;
                    if (insertarContactoSiVacio(nombre4, tlfn4, correo4, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;

                    JOptionPane.showMessageDialog(null, "No hay más espacio para nuevos contactos.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar contacto en base de datos: " + ex.getMessage());
                }
            });

            subirFotoButton.addActionListener(e -> {
                if (contactoActual == null) return;

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecciona una foto");
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File imagen = fileChooser.getSelectedFile();
                    String rutaImagen = imagen.getAbsolutePath();

                    ImageIcon original = new ImageIcon(rutaImagen);
                    Image escalada = original.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon iconoFinal = new ImageIcon(escalada);

                    fotosPorContacto.put(contactoActual, iconoFinal);
                    fotoLabel.setIcon(iconoFinal);

                    subirFotoButton.setVisible(false);
                    fotoYaSubida = true;

                    String nombreContacto = contactoActual.getText().trim();
                    insertarRutaFotoBD(conexion, nombreContacto, rutaImagen);

                    contactoActual = null;
                }
            });

            eliminarContacto.addActionListener(e -> {
                if (contactoActual == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un contacto para eliminar.");
                    return;
                }

                String nombreContacto = contactoActual.getText().trim();
                if (nombreContacto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El contacto no tiene un nombre válido.");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este contacto?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        String sql = "DELETE FROM usuarios WHERE nombre = ?";
                        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                            pstmt.setString(1, nombreContacto);
                            int rowsAffected = pstmt.executeUpdate();
                            if (rowsAffected > 0)
                                JOptionPane.showMessageDialog(null, "Contacto eliminado con éxito.");
                            else 
                                JOptionPane.showMessageDialog(null, "No se encontró el contacto en la base de datos.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el contacto: " + ex.getMessage());
                    }

                    contactoActual.setText("");
                    if (contactoActual == nombre1) {
                        tlfn1.setText("");
                        correo1.setText("");
                    } else if (contactoActual == nombre2) {
                        tlfn2.setText("");
                        correo2.setText("");
                    } else if (contactoActual == nombre3) {
                        tlfn3.setText("");
                        correo3.setText("");
                    } else if (contactoActual == nombre4) {
                        tlfn4.setText("");
                        correo4.setText("");
                    }

                    fotoLabel.setIcon(null);
                    fotosPorContacto.remove(contactoActual);
                    fotoYaSubida = false;
                    contactoActual = null;
                }
            });

            exportar.addActionListener(e -> {
                ArrayList<Usuarios> us = new ArrayList<>();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};
                JTextArea[] telefonos = {tlfn1, tlfn2, tlfn3, tlfn4};
                JTextArea[] correos = {correo1, correo2, correo3, correo4};

                for (int i=0; i<4; i++) {
                    String nombre = nombres[i].getText().trim();
                    String telefono = telefonos[i].getText().trim();
                    String correo = correos[i].getText().trim();

                    if (!nombre.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
                        String rutaFoto = "";
                        ImageIcon icon = fotosPorContacto.get(nombres[i]);
                        if (icon != null) {
                            try  {
                                String sql = "SELECT foto FROM usuarios WHERE nombre = ?";
                                try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                                    pstmt.setString(1, nombre);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        if (rs.next()) 
                                            rutaFoto = rs.getString("foto");
                                    }
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Error al obtener ruta de foto: " + ex.getMessage());
                            }
                        }

                        try {
                            int telefonoInt = Integer.parseInt(telefono);
                            us.add(new Usuarios(nombre, telefonoInt, correo,rutaFoto));
                        } catch (NumberFormatException ex) {
                            System.out.println("Número inválido para contacto: " + nombre);
                        }
                    }
                }

                String usuariosJSON = gson.toJson(us);

                try (FileWriter fw = new FileWriter("usuarios.json")) {
                    fw.write(usuariosJSON);
                    JOptionPane.showMessageDialog(null, "Contactos exportados correctamente a 'usuarios.json'.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar archivo JSON: " + ex.getMessage());
                }
            });

            insertarJson.addActionListener(e -> {
                Gson gson = new Gson();
                try (Reader reader = new FileReader("usuarios.json")) {
                    Usuarios[] usuarios = gson.fromJson(reader, Usuarios[].class);

                    JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};
                    JTextArea[] telefonos = {tlfn1, tlfn2, tlfn3, tlfn4};
                    JTextArea[] correos = {correo1, correo2, correo3, correo4};

                    int insertados = 0;

                    for (Usuarios u : usuarios) {
                        boolean insertado = false;
                        for (int i = 0; i < 4; i++) {
                            if (isEmpty(nombres[i])) {
                                nombres[i].setText(u.getNombre());
                                telefonos[i].setText(String.valueOf(u.getNumero()));
                                correos[i].setText(u.getCorreo());

                                try (PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO usuarios (nombre, numero, correo, foto) VALUES (?, ?, ?, ?)")) {
                                    pstmt.setString(1, u.getNombre());
                                    pstmt.setInt(2, u.getNumero());
                                    pstmt.setString(3, u.getCorreo());
                                    pstmt.setString(4, "");
                                    pstmt.executeUpdate();
                                }
                                insertados++;
                                insertado = true;
                                break;
                            }
                        }
                        if (!insertado) {
                            JOptionPane.showMessageDialog(null, "No hay espacio para más contactos. Solo se insertaron " + insertados + " de " + usuarios.length);
                            break;
                        }
                    }

                    if (insertados > 0) {
                        JOptionPane.showMessageDialog(null, insertados + " contactos insertados desde JSON.");
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo JSON: " + ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos: " + ex.getMessage());
                }
            });

            btnEditarUsuario.addActionListener(e -> {
                editarUsuario();
            });

            datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
            setupNombreClickListeners();

        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    private void editarUsuario() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            String[] opciones = {"Contacto 1", "Contacto 2", "Contacto 3", "Contacto 4"};
            int seleccion = JOptionPane.showOptionDialog(null, "¿Qué contacto deseas editar?", "Editar Usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == -1)
                return;

            JTextArea nombre = null, tlfn = null, correo = null;

            switch (seleccion) {
                case 0 -> { nombre = nombre1; tlfn = tlfn1; correo = correo1; }
                case 1 -> { nombre = nombre2; tlfn = tlfn2; correo = correo2; }
                case 2 -> { nombre = nombre3; tlfn = tlfn3; correo = correo3; }
                case 3 -> { nombre = nombre4; tlfn = tlfn4; correo = correo4; }
            }

            if (nombre.getText().trim().isEmpty() && tlfn.getText().trim().isEmpty() && correo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este contacto está vacío y no se puede editar.",  "Contacto Vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JTextField nuevoNombre = new JTextField(nombre.getText());
            JTextField nuevoTelefono = new JTextField(tlfn.getText());
            JTextField nuevoCorreo = new JTextField(correo.getText());

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Nombre:"));
            panel.add(nuevoNombre);
            panel.add(new JLabel("Teléfono:"));
            panel.add(nuevoTelefono);
            panel.add(new JLabel("Correo:"));
            panel.add(nuevoCorreo);

            int result = JOptionPane.showConfirmDialog(null, panel, "Editar Contacto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String nombreNuevo = nuevoNombre.getText();
                String telefonoNuevo = nuevoTelefono.getText();
                String correoNuevo = nuevoCorreo.getText();

                nombre.setText(nombreNuevo);
                tlfn.setText(telefonoNuevo);
                correo.setText(correoNuevo);

                try {
                    PreparedStatement stmt = conexion.prepareStatement("UPDATE usuarios SET nombre = ?, numero = ?, correo = ? WHERE id = ?" );
                    stmt.setString(1, nombreNuevo);
                    stmt.setString(2, telefonoNuevo);
                    stmt.setString(3, correoNuevo);
                    stmt.setInt(4, seleccion + 1);
                    stmt.executeUpdate();
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar en la base de datos: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    private void insertarRutaFotoBD(Connection conexion, String nombre, String rutaImagen) {
        try {
            String sql = "UPDATE usuarios SET foto = ? WHERE nombre = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, rutaImagen);
                pstmt.setString(2, nombre);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la ruta de la foto: " + ex.getMessage());
        }
    }

    private boolean insertarContactoSiVacio(JTextArea nombreArea, JTextArea tlfnArea, JTextArea correoArea, String nombre, String telefono, String correo, Connection conexion, int telefonoInt) throws SQLException {
        if (isEmpty(nombreArea)) {
            nombreArea.setText(nombre);
            tlfnArea.setText(telefono);
            correoArea.setText(correo);
            contactoActual = nombreArea;
            subirFotoButton.setVisible(true);

            String sql = "INSERT INTO usuarios (nombre, numero, correo, foto) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setInt(2, telefonoInt);
                pstmt.setString(3, correo);
                pstmt.setString(4, "");
                pstmt.executeUpdate();
            }
            return true;
        }
        return false;
    }

    private void cargarContactosDesdeDB(Connection conexion) {
        JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};
        JTextArea[] telefonos = {tlfn1, tlfn2, tlfn3, tlfn4};
        JTextArea[] correos = {correo1, correo2, correo3, correo4};

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre, numero, correo, foto FROM usuarios LIMIT 4")) {

            int index = 0;
            while (rs.next() && index < 4) {
                String nombre = rs.getString("nombre");
                int numero = rs.getInt("numero");
                String correo = rs.getString("correo");
                String rutaFoto = rs.getString("foto");

                nombres[index].setText(nombre);
                telefonos[index].setText(String.valueOf(numero));
                correos[index].setText(correo);

                if (rutaFoto != null && !rutaFoto.trim().isEmpty()) {
                    ImageIcon original = new ImageIcon(rutaFoto);
                    Image escalada = original.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    fotosPorContacto.put(nombres[index], new ImageIcon(escalada));
                }

                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void setupNombreClickListeners() {
        JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};
        JTextArea[] telefonos = {tlfn1, tlfn2, tlfn3, tlfn4};
        JTextArea[] correos = {correo1, correo2, correo3, correo4};

        for (int i = 0; i < nombres.length; i++) {
            int index = i;
            nombres[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    contactoActual = nombres[index];
                    datos.removeAll();

                    ImageIcon icon = fotosPorContacto.get(nombres[index]);
                    if (icon != null)
                        fotoLabel.setIcon(icon);
                    else
                        fotoLabel.setIcon(null);

                    datos.add(fotoLabel);

                    JLabel nombreLabel = new JLabel("Nombre: " + nombres[index].getText());
                    JLabel telefonoLabel = new JLabel("Teléfono: " + telefonos[index].getText());
                    JLabel correoLabel = new JLabel("Correo: " + correos[index].getText());

                    nombreLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
                    telefonoLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                    correoLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

                    datos.add(nombreLabel);
                    datos.add(telefonoLabel);
                    datos.add(correoLabel);

                    datos.revalidate();
                    datos.repaint();
                }
            });
        }
    }

    private boolean isEmpty(JTextArea area) {
        return area.getText().trim().isEmpty();
    }

    private void createUIComponents() {
        fotoLabel = new JLabel();
        fotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fotoLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

}
