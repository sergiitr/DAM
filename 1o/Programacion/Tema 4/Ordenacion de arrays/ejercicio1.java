import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante[] estudiante = new Estudiante[10];
        final int N = estudiante.length;
        for (int i=0;i<N;i++)
            estudiante[i] = new Estudiante();
        
        String[] nombre = new String[10];
        System.out.println("--- Introduce los nombres ---");
        for (int i=0; i<N; i++) {
            System.out.print("Estudiante "+(i+1)+": ");
            nombre[i]=sc.nextLine();
        }
        for (int i=0; i<N; i++) 
            estudiante[i].setNombre(nombre[i]);
        
        System.out.println("--- Introduce las notas ---");
        int nota;
        for (int i=0; i<N; i++) {
            System.out.print("Estudiante "+(i+1)+": ");
            nota=sc.nextInt();
            estudiante[i].setNota(nota);
        }

        System.out.println("\n--- Nuestro vector antes de ordenarlo es ---");
        for (int i=0; i<N; i++){
            System.out.println("Nombre estudiante "+(i+1)+": "+estudiante[i].getNombre());
            System.out.println("Nota estudiante "+(i+1)+": "+estudiante[i].getNota());
            System.out.println();
        }

        Estudiante aux = new Estudiante();
        for (int i = 0; i < N-1; i++) 
            for (int j = 0; j < N-i-1; j++) 
                if(estudiante[j].getNota() > estudiante[j+1].getNota()){
                    aux=estudiante[j];
                    estudiante[j]=estudiante[j+1];
                    estudiante[j+1]=aux;
                }
        
        System.out.println("--- Nuestro vector ordenado de menor a mayor es ---");
        for (int i=0; i<N; i++) {
            System.out.println("Nombre estudiante "+(i+1)+": "+estudiante[i].getNombre());
            System.out.println("Nota estudiante "+(i+1)+": "+estudiante[i].getNota());
            System.out.println();
        }
    }
}
