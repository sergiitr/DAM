import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            String URL = "jdbc:sqlite:libros.db";
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");

            try{
                Statement stmt = conexion.createStatement();
                // Leer datos
                String sql = "SELECT * FROM libros";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getString("Autor") + "\t" + rs.getString("Titulo") + "\t" +
                                       rs.getString("ISBN") + "\t" + rs.getString("Editorial"));
                }
                
                conexion.close();
            }  catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
}
