public class ejercicio3 {
    public static char letraMinuscula() {
        String alfabeto="qwertyuiopasdfghjklñzxcvbnm";
        int numero = (int) (Math.random()*alfabeto.length());

        return alfabeto.charAt(numero);
    }

    public static char letraMayuscula() {
        String alfabeto="QWERTYUIOPASDFGHJKLÑZXCVBNM";
        int numero =(int) (Math.random()*alfabeto.length());

        return alfabeto.charAt(numero);
    }

    public static int numero(){
        int numero =(int) (Math.random() * 10);
        return numero;
    }

    public static String crearClaveSegura(int longitud, String contrasena) {

        if (longitud<4) {
            return null;
        } else {
            char[] contrasenia = new char[longitud];
            for (int i = 0; i < longitud; i++) {
                int valor=(int)(Math.random()*3);
                switch (valor) {
                    case 0:
                        contrasenia[i]=letraMinuscula();
                        break;
                    case 1:
                        contrasenia[i]=letraMayuscula();
                        break;
                    case 2:
                        contrasenia[i]=(char)numero();
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            for (int i = 0; i < longitud; i++) {
                System.out.print(contrasenia[i]);
            }
            return contrasena;
        }
    }

    public static void main(String[] args) {
        String contrasena="";
        int longitud=6;
        contrasena=crearClaveSegura(longitud, contrasena);

        System.out.println(contrasena);
    }
}
