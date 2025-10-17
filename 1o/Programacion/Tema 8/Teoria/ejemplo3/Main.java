// --- NOTAS --- 
// Iniciar sesion Mysql:    mysql -h localhost -u usuario -p
// Ejecutar java:           java -cp ./JAR/mysql-connector-j-9.3.0.jar ./Teoria/ejemplo1/Main.java

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void funcion(double notaCorte,String asignatura) {
        try{
            final String USUARIO = "usuario";
            final String CONTRASENIA = "usuario";
            Connection con;
            String url = "jdbc:mysql://localhost/academia";
            con = DriverManager.getConnection(url, USUARIO, CONTRASENIA);
            System.out.println("Conexión exitosa.");

            String sql = "SELECT dni,alumno.nombre FROM alumno,asignatura,matricula WHERE matricula.nota >= ? AND dni=dniAlumno AND asignatura.idAsignatura=matricula.idAsignatura AND asignatura.nombre=?;";
            PreparedStatement sentencia = con.prepareStatement(sql);

            sentencia.setDouble(1, notaCorte); 
            sentencia.setString(2, asignatura);
            ResultSet rs = sentencia.executeQuery();

            System.out.println("DNI\t\tNombre");
            while(rs.next()) {
                System.out.println(rs.getString("dni")+"\t"+rs.getString("nombre"));   
            }

            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double notaCorte;
            String asignatura;
            int salida;
            do {
                System.out.print("Introduce nota de corte: ");
                notaCorte=sc.nextDouble();
                sc.nextLine();
                System.out.print("Introduce asignatura: ");
                asignatura=sc.nextLine();
    
                funcion(notaCorte,asignatura);
                do { 
                    System.out.print("Deseas salir? (0 no 1 si): ");
                    salida=sc.nextInt();
                } while (salida!=0 && salida != 1);
                System.out.println();
            }while (salida!=1);

    }
}

