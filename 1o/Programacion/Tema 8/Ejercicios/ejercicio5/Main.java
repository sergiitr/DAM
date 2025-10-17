import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner (System.in);
    
    public static void anadirAlumno() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);

            LocalDate fechaNacimiento = LocalDate.now();
            String dni, nombre, apellidos, direccion, email;

            System.out.print("Introduce DNI:");
            dni = sc.nextLine();
            System.out.print("Introduce nombre:");
            nombre = sc.nextLine();
            System.out.print("Introduce apellidos:");
            apellidos = sc.nextLine();
            System.out.print("Introduce direccion:");
            direccion = sc.nextLine();
            System.out.print("Introduce email:");
            email = sc.nextLine();

            if ( alumnos.obtenerAlumnoPorDni(dni) == null ){
                Alumno alumno = new Alumno(dni, nombre, apellidos, fechaNacimiento, direccion, email);
                alumnos.crearAlumno(alumno);
            } else
                System.out.println("Alumno ya está en el sistema");  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarDatosAlumno() {
        try {
            String dni;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);
            
            System.out.print("Introduce DNI del alumno: ");
            dni=sc.nextLine();

            System.out.println(alumnos.obtenerAlumnoPorDni(dni).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarDatos() {
        try {
            String dni;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);

            System.out.print("Introduce DNI del alumno: ");
            dni=sc.nextLine();

            Alumno alumno = alumnos.obtenerAlumnoPorDni(dni);

            alumnos.actualizarAlumno(alumno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarAlumno() {
        try {
            String dni;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);

            System.out.print("Introduce DNI del alumno: ");
            dni=sc.nextLine();
            alumnos.eliminarAlumno(dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarDatos() {
        try {
            String dni;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "usuario", "usuario");
            AlumnoDAO alumnos = new AlumnoDAO(conexion);

            
            for (int i = 0; i < alumnos.obtenerTodosalumno().size(); i++) {
                System.out.println(alumnos.obtenerTodosalumno().get(i).toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do { 
            System.out.println("--- OPCIONES ---");
            System.out.println("1) Añadir nuevo alumno (si ya existe y no se añade, indicarlo en un mensaje )");
            System.out.println("2) Mostrar los datos del alumno (toString) según su DNI");
            System.out.println("3) Actualizar los datos de un alumno (buscar por DNI)");
            System.out.println("4) Eliminar un alumno de la BBDD por su DNI");
            System.out.println("5) Mostrar los datos de todos los alumnos");
            System.out.println("6) Salir");
            
            do { 
                System.out.print("Introduce opcion: ");
                opcion=sc.nextInt();
            } while (opcion<1 && opcion>6);

            switch (opcion) {
                case 1:
                    anadirAlumno();
                    break;
                case 2:
                    mostrarDatosAlumno();
                    break;
                case 3:
                    actualizarDatos();
                    break;
                case 4:
                    eliminarAlumno();
                    break;
                case 5:
                    mostrarDatos();
                    break;
                default:
                    break;
            }
        } while (opcion!=6);
    }
}
