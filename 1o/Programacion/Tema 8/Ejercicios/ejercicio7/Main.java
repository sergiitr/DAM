import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static String URL = "jdbc:sqlite:chinook.db";
    public static Scanner sc = new Scanner(System.in);
    
    /**
     * Abrir conexion de la base de datos
     * @param archivoSQL
     */
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
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return true;
    }

    /**
     * Ver album por Artista
     */
    public static void verAlbunesArtista() {
        
        try {
            Connection conexion = DriverManager.getConnection(URL);
            try{
                String nombreArtista;
                System.out.print("Introduce nombre artista: ");
                nombreArtista = sc.nextLine();

                String sql = "SELECT albums.AlbumId, albums.Title FROM albums,artists WHERE albums.ArtistId=artists.ArtistId AND artists.Name='"+nombreArtista+"'";
                
                int albumID;
                String tituloAlbum;
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    albumID=rs.getInt("AlbumId");
                    tituloAlbum=rs.getString("Title");
                    System.out.println(albumID + "\t" + tituloAlbum);
                }
                
                conexion.close();
            }  catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
            
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }

    }

    /**
     * Ver Artistas
     */
    public static void verArtista() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            try{
                String sql = "SELECT * FROM artists";
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("ArtistId") + "\t" + resultSet.getString("Name"));
                }
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    /**
     * Insertar nuevo Album
     */
    public static void insertarAlbum() {
        Scanner sc = new Scanner(System.in);
        try {
            Connection conexion = DriverManager.getConnection(URL);
            try {
                String titulo;
                int idArtista;

                System.out.print("Introduce Titulo: ");
                titulo=sc.nextLine();
                
                System.out.print("Introduce el ID del artista: ");
                idArtista=sc.nextInt();

                sc.nextLine();

                String sql = "INSERT INTO albums(Title,ArtistId) VALUES('"+titulo+"', "+idArtista+")";
                Statement statement = conexion.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
            
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    /**
     * Eliminar Album
     */
    public static void eliminarAlbum() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            String nombreAlbum;
            System.out.print("Introduce nombre album que quieras eliminar: ");
            nombreAlbum=sc.nextLine();
            try {
                String sql = "DELETE FROM albums WHERE Title='"+nombreAlbum+"'";
                Statement statement = conexion.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    /**
     * Actualizar Alum
     */
    public static void actualizarAlbum() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            String nuevoNombre, antiguoNombre;
            System.out.print("Introduce album q quieras actualizar nombre: ");
            nuevoNombre=sc.nextLine();
            System.out.print("Introduce nuevo nombre: ");
            antiguoNombre=sc.nextLine();
            try {
                String sql = "UPDATE albums SET Title='"+nuevoNombre+"' WHERE Title='"+antiguoNombre+"'";
                Statement statement = conexion.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
            
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    

    public static void main(String[] args) {
        
        if (ejecutarSQLDesdeArchivo("chinook.sql") == true)
            ejecutarSQLDesdeArchivo("chinook.sql"); 
        else
            System.out.println("Se ha cargado anteriormente");
        int opcion;
        try {
            do { 
                Connection conexion = DriverManager.getConnection(URL);
    
                System.out.println("1.- Ver artistas");
                System.out.println("2.- Ver albunes");
                System.out.println("3.- Insertar albun");
                System.out.println("4.- Actalizar album");
                System.out.println("5.- Eliminar album");
                System.out.println("6.- Salir");
    
                do {
                    System.out.print("Introduce opcion: ");
                    opcion = sc.nextInt();
                } while (opcion < 1 || opcion > 6);
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        verArtista();
                        break;
                    case 2:
                        verAlbunesArtista();
                        break;
                    case 3:
                        insertarAlbum();
                        break;
                    case 4:
                        actualizarAlbum();
                        break;
                    case 5:
                        eliminarAlbum();
                        break;
                    case 6:
                        System.out.println("Final del programa");
                        break;
                }
            } while (opcion!=6);
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }          
    }
}
