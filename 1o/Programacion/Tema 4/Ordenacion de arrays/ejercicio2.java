import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] persona = new Persona[10];
        final int N = persona.length;
        for (int i=0;i<N;i++)
            persona[i] = new Persona();
        
        String[] nombre = new String[10];
        System.out.println("Introduce los nombre ");
        for (int i=0; i<N; i++) {
            System.out.println("Persona "+(i+1)+": ");
            nombre[i]=sc.nextLine();
        }
        for (int i=0; i<N; i++) 
            persona[i].setNombre(nombre[i]);
        

        System.out.println("Introduce la edad ");
        int edad;
        for (int i=0; i<N; i++) {
            System.out.println("Persona "+(i+1)+": ");
            edad=sc.nextInt();
            persona[i].setEdad(edad);
        }

        System.out.println("Vector antes:");
        for (Persona i:persona) {
            System.out.println("Nombre: "+i.getNombre());
            System.out.println("Edad: "+i.getEdad());
            System.out.println();
        }


        Persona aux = new Persona();
        for (int i = 0; i < N-1; i++) 
            for (int j = 0; j < N-i-1; j++) 
                if(persona[j].getEdad() < persona[j+1].getEdad()){
                    aux=persona[j];
                    persona[j]=persona[j+1];
                    persona[j+1]=aux;
                }

        System.out.println("Vector despues:");
        for (Persona i:persona) {
            System.out.println("Nombre: "+i.getNombre());
            System.out.println("Edad: "+i.getEdad());
            System.out.println();
        }
    }
}
