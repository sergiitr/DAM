package proyecto;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando el programa...");
        ListaPersonas lp = new ListaPersonas();

        String nombrearchivoMujeres = "/home/manana/Escritorio/AccesosADatos/Tema1/proyecto/datos/nombre_mujeres.txt";
        String nombrearchivoHombres = "/home/manana/Escritorio/AccesosADatos/Tema1/proyecto/datos/nombre_hombres.txt";
        String nombrearchivoApellidos = "/home/manana/Escritorio/AccesosADatos/Tema1/proyecto/datos/apellidos.txt";
        String nombrearchivoEmail = "/home/manana/Escritorio/AccesosADatos/Tema1/proyecto/datos/all_email.txt";

        System.out.println("Cargando datos...");
        lp.loadData(nombrearchivoMujeres, nombrearchivoHombres, nombrearchivoApellidos, nombrearchivoEmail);
    }
}
