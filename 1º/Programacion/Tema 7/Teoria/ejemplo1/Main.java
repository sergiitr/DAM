import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String texto = "";
        FileReader in = null;
        String rutaArchivo = "C:\\Users\\usuario\\Desktop\\Programacion\\Tema 7\\Teoria\\ejemplo1\\texto.txt";
        char[][] cadena=new char[5][2];
        cadena[0][0]='a';
        cadena[1][0]='e';
        cadena[2][0]='i';
        cadena[3][0]='o';
        cadena[4][0]='u';
        try {
            in = new FileReader(rutaArchivo);
            int caracter;
            while ((caracter = in.read()) != -1) {
                texto += ((char) caracter);
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el archivo: " + ex.getMessage());
                }
            }
        }
        System.out.println("Nuestra cadena de texto es: "+texto);
        Integer contadorA=0, contadorE=0, contadorI=0, contadorO=0, contadorU=0;
        for (int i = 0; i < texto.length(); i++) {
            switch (texto.charAt(i)) {
                case 'a':
                    contadorA++;
                    break;
                case 'e':
                    contadorE++;
                    break;
                case 'i':
                    contadorI++;
                    break;
                case 'o':
                    contadorO++;
                    break;
                case 'u':
                    contadorU++;
                    break;
                default:
                    break;
            }
        }
        cadena[0][1]=Integer.toString(contadorA).charAt(0);
        cadena[1][1]=Integer.toString(contadorE).charAt(0);
        cadena[2][1]=Integer.toString(contadorI).charAt(0);
        cadena[3][1]=Integer.toString(contadorO).charAt(0);
        cadena[4][1]=Integer.toString(contadorU).charAt(0);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println(cadena[i][j]+": "+cadena[i][j+1]);
            }
        }
    }
}
