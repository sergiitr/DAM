import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nombre, apellidos;
        int edad,altura;
        double peso;

        System.out.print("Introduce el nombre: ");
        nombre=sc.nextLine();
        System.out.print("Introduce los apellidos: ");
        apellidos=sc.nextLine();
        System.out.print("Introduce la edad: ");
        edad=sc.nextInt();
        System.out.print("Introduce el peso (en kg): ");
        peso=sc.nextDouble();
        System.out.print("Introduce la altura (en cms): ");
        altura=sc.nextInt();

        Persona p1 = new Persona(nombre, apellidos, edad, peso, altura);
        Persona p2 = new Persona(nombre, apellidos);
        Persona p3 = new Persona();
        Persona p4 = new Persona(p1);

        p3.setNombre(nombre);
        p3.setApellidos(apellidos);
        p3.setEdad(edad);
        p3.setAltura(altura);
        p3.setPeso(peso);

        System.out.println(p1.toString());
        if(p1.calcularIMC()==0) 
            System.out.println("Peso correcto");
        else if (p1.calcularIMC()==1)
            System.out.println("Tienes sobrepeso");
        else 
            System.out.println("Valor no valido");
        
        if (p1.esMayorDeEdad()==true)
            System.out.println("El pibe es mayor de edad");
        else
            System.out.println("El pibe es menor de edad");

        System.out.println("El dni es:"+p1.getDNI());
    }
}
