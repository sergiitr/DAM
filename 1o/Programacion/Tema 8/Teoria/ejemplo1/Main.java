// java -cp ./JAR/mysql-connector-j-9.3.0.jar ./Teoria/ejemplo1/Main.java
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            final String USUARIO="usuario";
            final String CONTRASENIA="usuario";
            Connection conexion;
            String url = "jdbc:mysql://localhost/academia";
            conexion = DriverManager.getConnection(url, USUARIO, CONTRASENIA);
            System.out.println("Conexión exitosa.");
            String sql = "SELECT * FROM alumnos";
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString("dni")+"\t"+rs.getString("nombre")+" "+rs.getString("fechaNacimiento")+" "+rs.getString("direccion")+" "+rs.getString("email"));   
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();

            
        }
    }
}
