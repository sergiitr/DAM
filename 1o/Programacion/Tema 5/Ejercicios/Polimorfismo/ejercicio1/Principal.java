public class Principal {
    public static void main(String[] args) {
        Gerente g1 = new Gerente("Sergio","Informatica");
        Gerente g2 = new Gerente("David","Finanzas");
        Gerente g3 = new Gerente("Luis", "Marketing");
        Desarrollador d1 = new Desarrollador("Antonio", "Java");
        Desarrollador d2 = new Desarrollador("Manolo", "JavaScript");
        Desarrollador d3 = new Desarrollador("Carlos", "C++");
        Desarrollador d4 = new Desarrollador("Miguel","Python");
        Desarrollador d5 = new Desarrollador("Alejandro", "Cobol");
        Desarrollador d6 = new Desarrollador("Fernando", "C#");
        Gerente g4 = new Gerente("Domingo", "RRHH");
        Gerente g5 = new Gerente("Oscar", "Digitalizacion");

        System.out.println();
        
        g1.trabajar();
    }
}