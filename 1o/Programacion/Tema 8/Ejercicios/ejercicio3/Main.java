// java -cp ./JAR/mysql-connector-j-9.3.0.jar ./Teoria/ejemplo1/Main.java
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            final String USUARIO="usuario";
            final String CONTRASENIA="usuario";
            Connection conexion;
            String url = "jdbc:mysql://localhost/academia";
            conexion = DriverManager.getConnection(url, USUARIO, CONTRASENIA);
            System.out.println("Conexión exitosa.");
            String dni;
            System.out.print("Introduzca el DNI: ");    // 01234567K javi y dos asig
            dni=sc.nextLine();
            String sql = "(SELECT alumno.dni, CONCAT(alumno.nombre, ' ', alumno.apellidos) AS NombreAlumno,  COUNT(matricula.idAsignatura) AS totalAsignaturas, 'Aleatorio' AS tipo " +
                         " FROM alumno JOIN matricula ON alumno.dni = matricula.dniAlumno  GROUP BY alumno.dni ORDER BY RAND() LIMIT 1) " +
                         " UNION ALL (SELECT dni, CONCAT(nombre, ' ', apellidos), NULL, 'MasJoven' FROM alumno ORDER BY fechaNacimiento DESC LIMIT 1) " +
                         " UNION ALL (SELECT dni, CONCAT(nombre, ' ', apellidos), NULL, 'MasViejo' FROM alumno ORDER BY fechaNacimiento ASC LIMIT 1)";
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString("dni")+"\t"+rs.getString("NombreAlumno")+" "+rs.getString("totalAsignaturas"));   
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
}