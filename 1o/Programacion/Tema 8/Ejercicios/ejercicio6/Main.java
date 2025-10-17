import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void mostrarAsgnatura() {
        try {
            Scanner sc = new Scanner(System.in);
            String nombreAsignatura;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);
            
            System.out.print("Introduce nombre de la asignatura: ");
            nombreAsignatura=sc.nextLine();

            alumnos.mostrarAsgnatura(nombreAsignatura);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void datosProfesores() {
        try {
            Scanner sc = new Scanner(System.in);
            String nombreAsignatura;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);
            

            alumnos.mostrarDatosProfesores();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void actualizarNota() {
        try {
            Scanner sc = new Scanner(System.in);
            String nombreAsignatura;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);
            

            alumnos.actualizarNota();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do { 
            System.out.println("--- MENU ---");
            System.out.println("1) Mostrar datos de todas las asignaturas, con su número de alumnos y nota media de la misma. Además, mostrar los datos de la asignatura con mayor nota media y menor nota media.");
            System.out.println("2) Mostrar los datos de todos los profesores, con el número de asignaturas que imparte cada uno.");
            System.out.println("3) Actualizar la nota de un alumno dado el dni del mismo y el dni del profesor que imparte la asignatura.");
            System.out.println("4) Mostrar todos los datos de una asignatura dado el dni del profesor que la imparte.");
            System.out.println("5) Salir");
            
            do { 
                System.out.print("Introduce opcion: ");
                opcion=sc.nextInt();
            } while (opcion<1 || opcion > 5);

            switch (opcion) {
                case 1:
                    mostrarAsgnatura();
                    break;
                case 2:
                    datosProfesores();
                    break;
                case 3:
                    actualizarNota();
                    break;
                case 4:
                    
                    break;
                case 5:
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion >= 5);
    }
}
