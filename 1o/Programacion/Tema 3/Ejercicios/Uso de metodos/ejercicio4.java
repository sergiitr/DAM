public class ejercicio4 {
    public static void main(String[] args) {
        int altura = 5;
        int radio = 3;
        double superficieEstatica = Cilindro2.calcularSuperficie(altura, radio);
        double volumenEstatico = Cilindro2.calcularVolumen(altura, radio);

        System.out.println("Superficie calculada estáticamente: " + superficieEstatica + "cm2");
        System.out.println("Volumen calculado estáticamente: " + volumenEstatico + "cm3");

        // Llamando a los métodos de instancia después de crear un objeto
        Cilindro2 cilindro = new Cilindro2(altura, radio);
        System.out.println(cilindro.toString());
    }
}