public class ejercicio1 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Sergio", "Trillo", 23, 70, 170);
        Coche c1 = new Coche("Toyota", "Corolla", 2021, 100, 1000, 100, 200, p1);
        
        System.out.println("La antiguedad del coche es de "+c1.calcularAntiguedad()+" anio, por tanto su nuevo valor es de "+c1.depreciarValor()+"€");
        c1.bajarConductor(p1);
        c1.bajarConductor(p1);

    }
}