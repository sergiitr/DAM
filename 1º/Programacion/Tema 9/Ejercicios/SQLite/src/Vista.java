import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Vista {
    public static String URL = "jdbc:sqlite:chinook.db";
    private JButton verArtistas;
    private JButton verAlbumArtista;
    private JButton insertarAlbum;
    private JButton actualizarAlbum;
    private JButton eliminarAlbum;
    private JPanel panel1;

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
                            return false;
                            //System.out.println("Error al ejecutar SQL: " + e.getMessage());
                        }
                    }
                }
                System.out.println("SQL ejecutado exitosamente.");
            } catch (SQLException e) {
                return false;
                //System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        } catch (IOException e) {
            return false;
           // System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return true;
    }

    public Vista() {
        Scanner sc = new Scanner(System.in);

        JFrame frame = new JFrame("panel1");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        verArtistas.addActionListener(e -> {
            try {
                // Ejecutar script SQL si es necesario
                ejecutarSQLDesdeArchivo("chinook.sql");

                Connection conexion = DriverManager.getConnection(URL);
                String sql = "SELECT * FROM artists";
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                StringBuilder mensajeCompleto = new StringBuilder();
                while (resultSet.next()) {
                    mensajeCompleto.append(resultSet.getInt("ArtistId")).append(" - ").append(resultSet.getString("Name")).append("\n");
                }

                JOptionPane.showMessageDialog(frame, mensajeCompleto.toString());
                System.out.println(mensajeCompleto);

                conexion.close();
            } catch (SQLException ex2) {
                System.out.println("Error al hacer el select: " + ex2.getMessage());
            }
        });

        verAlbumArtista.addActionListener(e -> {
            try{
                ejecutarSQLDesdeArchivo("chinook.sql");
                Connection conexion = DriverManager.getConnection(URL);
                String nombreArtista = JOptionPane.showInputDialog(null, "Introduce nombre del artista: ");


                String sql = "SELECT albums.AlbumId, albums.Title FROM albums,artists WHERE albums.ArtistId=artists.ArtistId AND artists.Name='"+nombreArtista+"'";
                StringBuilder mensajeCompleto = new StringBuilder();
                int albumID;
                String tituloAlbum;
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    albumID=rs.getInt("AlbumId");
                    tituloAlbum=rs.getString("Title");
                    System.out.println(albumID + "\t" + tituloAlbum);
                    mensajeCompleto.append(albumID).append(" - ").append(tituloAlbum).append("\n");
                }
                JOptionPane.showMessageDialog(frame, mensajeCompleto.toString());
            } catch (SQLException ex2) {
                System.out.println("Error al hacer el select: " + ex2.getMessage());
            }
        });

        eliminarAlbum.addActionListener(e -> {
            try {
                ejecutarSQLDesdeArchivo("chinook.sql");
                Connection conexion = DriverManager.getConnection(URL);
                String nombreAlbum=JOptionPane.showInputDialog(null, "Introduce nombre del album que quieras eliminar: ");
                try {
                    String sql = "DELETE FROM albums WHERE Title='"+nombreAlbum+"'";
                    Statement statement = conexion.createStatement();
                    statement.executeUpdate(sql);
                } catch (SQLException ex) {
                    System.out.println("Error al hacer el select");
                    ex.printStackTrace();
                }
            } catch (SQLException ex2) {
                System.out.println("Error al hacer el select: " + ex2.getMessage());
            }
        });

        actualizarAlbum.addActionListener(e -> {
            try {
                ejecutarSQLDesdeArchivo("chinook.sql");
                Connection conexion = DriverManager.getConnection(URL);
                String nuevoNombre=JOptionPane.showInputDialog(null, "Introduce el nuevo nombre del album : ");
                String antiguoNombre=JOptionPane.showInputDialog(null, "Introduce el del album que quieras actualizar : ");

                try {
                    String sql = "UPDATE albums SET Title='"+nuevoNombre+"' WHERE Title='"+antiguoNombre+"'";
                    Statement statement = conexion.createStatement();
                    statement.executeUpdate(sql);
                } catch (SQLException ex) {
                    System.out.println("Error al hacer el select");
                    ex.printStackTrace();
                }

            } catch (SQLException e3) {
                System.out.println("Conexion no exitosa");
            }
        });
    }
}
