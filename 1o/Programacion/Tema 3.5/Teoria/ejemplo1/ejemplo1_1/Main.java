public class Main {
    public static void main(String[] args) {
        Prueba p1 = new Prueba();

        System.out.println("Numero prueba1: "+p1.prueba1);
        System.out.println("Numero prueba2: "+p1.prueba2);
        try {
            int num3=p1.prueba3;
            System.out.println("Numero prueba3: "+num3);
        } catch (Exception e) {
            System.out.println("Metodo privadi.");
        }
    }
}
