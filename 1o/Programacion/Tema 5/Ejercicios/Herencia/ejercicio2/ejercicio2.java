public class ejercicio2 {
    public static void main(String[] args) {
        Vehiculos v1 = new Vehiculos("1234ABC", "Nissan", 1000);
        Taxi t1 = new Taxi("1111AAA", "ASD", 1500, 2000);
        Autobus a1 = new Autobus(30, "2222BBB", "ZXC", 1200);

        System.out.println("Vehiculos: "+v1.toString());
        System.out.println("Taxi:"+t1.toString());
        System.out.println("Autobus:"+a1.toString());
    }
}
