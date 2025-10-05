import java.io.File;

public class ListarContenidoRecursivo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ListarContenidoRecursivo <ruta_de_la_carpeta>");
            System.exit(1);
        }
        String concat = " |_";
        String rutaCarpeta = args[0];
        listarContenidoRecursivo(new File(rutaCarpeta), concat);
    }

    public static void listarContenidoRecursivo(File carpeta, String concat) {
        String concat2=concat.concat("|__");
        if (carpeta.isDirectory()) {
            System.out.println(concat+"Carpeta: " + carpeta.getName());

            File[] archivos = carpeta.listFiles();
            concat=concat.concat("__");
            if (archivos != null) {
                for (File archivo : archivos) {
                    listarContenidoRecursivo(archivo,concat);
                }
            }
        } else if (carpeta.isFile()) {
            System.out.println(concat2+"Archivo: " + carpeta.getName());
        }
    }
}
