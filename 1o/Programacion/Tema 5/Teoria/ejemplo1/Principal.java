public class Principal {
    public static void main(String[] args) {
        // Creación de un objeto Empleado
        Empleado empleado = new Empleado("Juan", "Gómez", 1.75, 50000.0);
        
        // Creación de un objeto Persona
        Persona persona = new Persona("Pepe", "Pérez", 1.85);
        
        // Creación de un objeto Profesor
        Profesor profesor = new Profesor("Sergio", "Trillo", 1200, "Programacion");

        // Acceso a los atributos del objeto Empleado
        System.out.println("Nombre: " + empleado.nombre);
        System.out.println("Apellidos: " + empleado.apellidos);
        System.out.println("Estatura: " + empleado.estatura);
        System.out.println("Salario: " + empleado.salario);
        
        // Acceso a los atributos del objeto Empleado
        System.out.println("Nombre: " + persona.nombre);
        System.out.println("Apellidos: " + persona.apellidos);
        System.out.println("Estatura: " + persona.estatura);

        System.out.println("Nombre: "+profesor.nombre);
        System.out.println("Apellidos: "+profesor.apellidos);
        System.out.println("Materia: "+profesor.materia);
    }
}
