import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ejercicio2{
    public static void main(String[] args) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("d/MM/uuuu");
        Scanner sc = new Scanner(System.in);
        
        /**
         * Hacemos la Persona 1
         * Tendra los datos del constructor por defecto
         */
        System.out.println("--- Datos Persona 1 ---");
        Persona p1 = new Persona();
        System.out.println(p1.getNombre());
        System.out.println(p1.getApellidos());
        System.out.println(p1.getfNac().format(formatoFecha).toString());

        /**
         * Hacemos la Persona 2
         * Tendra los datos del constructor de copia 
         */
        System.out.println("\n--- Datos Persona 2 ---");
        LocalDate fechaPrueba2=LocalDate.of(2001, 07, 02);
        Persona p2 = new Persona("Sergio","Trillo",fechaPrueba2);
        System.out.println(p2.getNombre());
        System.out.println(p2.getApellidos());
        System.out.println(p2.getfNac().format(formatoFecha).toString());

        /**
         * Hacemos la Persona 3
         * Tendra los datos del constructor de copia
         * El usuario introduce los parametros
         */
        System.out.println("\n--- Datos Persona 3 ---");
        int dia,mes,anio;
        String nombre,apellido;
        System.out.println("Introduce nombre");
        nombre=sc.nextLine();
        System.out.println("Introduce apellidos");
        apellido=sc.nextLine();
        System.out.println("Introduce dia nacimiento");
        dia=sc.nextInt();
        System.out.println("Introduce mes nacimiento");
        mes=sc.nextInt();
        System.out.println("Introduce anio nacimiento");
        anio=sc.nextInt();

        LocalDate fechaPrueba=LocalDate.of(anio, mes, dia);
        Persona p3 = new Persona(nombre,apellido,fechaPrueba);
        System.out.println(p3.getNombre());
        System.out.println(p3.getApellidos());
        System.out.println(p3.getfNac().format(formatoFecha).toString());

        /**
         * Mostramos los resultados
         */
        System.out.println("\n --- Resultados ---");
        System.out.println("-- Prueba 1 --");
        /**
         * Comprobamos con el 1er comparador (comparador ==)
         */
        System.out.println("-- Comparador == --");
        System.out.println("Comparamos p1 y p2");
        if (p1.comparador(p2) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        /**
         * A pesar de que p1 y p3 tengan los mismos parametros,
         * al estar en diferentes posiciones de memoria no son iguales 
         */
        System.out.println("Comparamos p1 y p3");
        if (p1.comparador(p3) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        /**
         * Comprobamos con el 1er comparador (comparador isEquals)
         */
        System.out.println("\n-- Comparador equals --");
        System.out.println("Comparamos p1 y p2");
        if (p1.equals(p2) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        /** 
         * Ahora comparamos con el equals, por tanto ahora 
         * si sale que ambos son iguales
         */
        System.out.println("Comparamos p1 y p3");
        if (p1.equals(p3) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        /**
         * Ponemos que la persona 1 tenga los atributos que la persona 2
         */
        System.out.println("\n\nAsociamos p2 a p1");
        p1 = p2;
        System.out.println("Mostramos los nuevos datos de p1");
        System.out.println(p2.getNombre());
        System.out.println(p2.getApellidos());
        System.out.println(p2.getfNac().format(formatoFecha).toString());
        
        System.out.println("\n-- Prueba 2 --");
        /**
         * Comprobamos con el 1er comparador (comparador ==)
         */
        System.out.println("-- Comparador == --");
        /**
         * Ahora p1 y p2 apuntan a la misma posicion de memoria,
         * por tanto p1 y p2 son iguales
         */
        System.out.println("Comparamos p1 y p2");
        if (p1.comparador(p2) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        System.out.println("Comparamos p1 y p3");
        if (p1.comparador(p3) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        /**
         * Comprobamos con el comparador Equals
         */
        System.out.println("\n-- Comparador equals --");
        System.out.println("Comparamos p1 y p2");
        if (p1.equals(p2) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        System.out.println("Comparamos p1 y p3");
        if (p1.equals(p3) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");
    }
}