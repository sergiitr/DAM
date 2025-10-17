import java.io.BufferedWritter;
import java.io.FileWritter;
import java.sql.*;
import java.util.Scanner;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dni;

        try {
            final String USUARIO = "usuario";
            final String CONTRASENIA = "usuario";
            Connection conexion;
            String url = "jdbc:mysql://localhost/academia";
            conexion = DriverManager.getConnection(url, USUARIO, CONTRASENIA);
            System.out.println("Conexión exitosa.");

            System.out.print("Introduce el DNI del profesor: ");
            dni = sc.nextLine();
            
            String sql = "SELECT a.dni AS dni_alumno, a.nombre AS nombre_alumno, a.apellidos AS apellidos_alumno, s.nombre AS asignatura, m.nota FROM alumnos a JOIN matriculas m ON a.dni = m.dniAlumno JOIN asignaturas s ON m.idAsignatura = s.idAsignatura JOIN profesores p ON s.dniProfesor = p.dni WHERE p.dni = '"+dni+"'";
            
            try (BufferedWriter br = new BufferedWriter(FileWritter("sql.json"))){
                
                Gson gson = new Gson();
                String personaJson = gson.toJson(sql);
                System.out.println(personaJson);
    
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                
                ResultSet rs = sentencia.executeQuery();
                boolean hayResultados = false;
                while (rs.next()) {
                    System.out.println("DNI Alumno: " + rs.getString("dni_alumno") + "\tNombre: " + rs.getString("nombre_alumno")  + "\tApellidos: "+ rs.getString("apellidos_alumno")  + "\tAsignatura: " + rs.getString("asignatura") + "\tNota: " + rs.getFloat("nota"));
                    hayResultados = true;
                }
                
                if (!hayResultados)
                    System.out.println("No hay alumnos matriculados en las asignaturas de este profesor.");
                
            } catch (IOException ex) {
                System.out.println(ex);
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
}
