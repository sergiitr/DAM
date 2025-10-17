import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Alumno {
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String email;

    // Constructor
    public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String direccion, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
    }
    
    //Constructor que crea un objeto Alumno únicamente con su identificador.
    //Se utiliza para leer los datos desde la BD a partir del DNI (clave primaria)
    public Alumno(String dni){
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
                + fechaNacimiento + ", direccion=" + direccion + ", email=" + email + "]";
    }

    
    
}


public class AlumnoDAO {
    private Connection conexion;

    public AlumnoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void crearAlumno(Alumno alumno) throws SQLException {
        String sql = "INSERT INTO alumno (dni, nombre, apellidos, fechaNacimiento, direccion, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, alumno.getDni());
            statement.setString(2, alumno.getNombre());
            statement.setString(3, alumno.getApellidos());
            statement.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            statement.setString(5, alumno.getDireccion());
            statement.setString(6, alumno.getEmail());
            statement.executeUpdate();
            System.out.println("Alumno creado exitosamente en la base de datos.");
        }
    }

    public Alumno obtenerAlumnoPorDni(String dni) throws SQLException {
        String sql = "SELECT * FROM alumno WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                LocalDate fechaNacimiento = resultSet.getDate("fechaNacimiento").toLocalDate();
                String direccion = resultSet.getString("direccion");
                String email = resultSet.getString("email");
                return new Alumno(dni, nombre, apellidos, fechaNacimiento, direccion, email);
            } else
                return null;
        }
    }

    public List<Alumno> obtenerTodosalumno() throws SQLException {
        List<Alumno> listaalumno = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        try (Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                LocalDate fechaNacimiento = resultSet.getDate("fechaNacimiento").toLocalDate();
                String direccion = resultSet.getString("direccion");
                String email = resultSet.getString("email");
                Alumno alumno = new Alumno(dni, nombre, apellidos, fechaNacimiento, direccion, email);
                listaalumno.add(alumno);
            }
        }
        return listaalumno;
    }

    public void actualizarAlumno(Alumno alumno) throws SQLException {
        String sql = "UPDATE alumno SET nombre = ?, apellidos = ?, direccion = ?, fechaNacimiento = ?, email = ? WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellidos());
            statement.setString(3, alumno.getDireccion());
            statement.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            statement.setString(5, alumno.getEmail());
            statement.setString(6, alumno.getDni());
            statement.executeUpdate();
            System.out.println("Datos del alumno actualizados exitosamente en la base de datos.");
        }
    }

    public void eliminarAlumno(String dni) throws SQLException {
        String sql = "DELETE FROM alumno WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.executeUpdate();
            System.out.println("Alumno eliminado exitosamente de la base de datos.");
        }
    }
}
