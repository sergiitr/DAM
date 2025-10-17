public class Main {
    public static void main(String[] args) {
        Calculadora c1 = new Calculadora(2, 5);
        if(c1.division() != 0.0)
            System.out.println("La division es: "+c1.division());
    }
}
