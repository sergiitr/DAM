import java.sql.*;
public class Profesor {
    public Profesor(String dni, String nombre, String apellido,String especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }
    
    public Profesor(String dni){
        this.dni = dni;
    }

    public void create(Connection conexion) throws SQLException {
        String sql = "INSERT INTO profesor VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setDate(4, especialidad);
            statement.executeUpdate();
            System.out.println("Profesor insertado en la base de datos.");
        }
    }

    public static Profesor read(Connection conexion, String dni) throws SQLException {
        String sql = "SELECT * FROM profesor WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String _dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String especialidad = resultSet.getString("especialidad");
                
                return new Profesor(_dni, nombre, apellido, especialidad);
            } else
                return null;
        }
    }

    public void update(Connection conexion) throws SQLException {
        String sql = "UPDATE profesor SET nombre = ?, apellido = ?, especialidad = ? WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, especialidad);
            statement.setString(4, dni);
            statement.executeUpdate();
            System.out.println("Datos del profesor actualizados en la base de datos.");
        }
    }

    public void delete(Connection conexion) throws SQLException {
        String sql = "DELETE FROM profesor WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.executeUpdate();
            System.out.println("Profesor eliminado exitosamente de la base de datos.");
        }
    }
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
}