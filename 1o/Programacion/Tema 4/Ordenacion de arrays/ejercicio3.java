import java.util.Scanner;

public class ejercicio3 {
    //Metodo de Ordenamiento QuickSort
    public static void Quicksort(Estudiante personas[], int izq, int der){
        /**
         * Este metodo recibe un arreglo de numero, y dos enteros que referencian el primer valor y el ultimo
         */
        //Se toma como pivote el primer valor
        Estudiante pivote = personas[izq];
        
        //Se definen los dos lados y un auxiliar
        int i = izq; 
        int j = der; 
        Estudiante aux;
        
        while(i<j) {
            while (personas[i].getNota() <= pivote.getNota() && i < j) 
                i++;
            while (personas[j].getNota() > pivote.getNota()) 
                j--;   

            if (i<j) {                                     
                aux = personas[i];                  
                personas[i]= personas[j];
                personas[j]=aux;
            }
        }

        personas[izq] = personas[j]; 
        personas[j] = pivote;

        if (izq < j-1)
            Quicksort(personas,izq,j-1);

        if (j+1 < der)
            Quicksort(personas,j+1,der);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante[] estudiantes = new Estudiante[10];
        final int N = estudiantes.length;
        for (int i=0;i<N;i++)
            estudiantes[i] = new Estudiante();
        
        String[] nombre = new String[10];
        System.out.println("--- Introduce los nombre ---");
        for (int i=0; i<N; i++) {
            System.out.print("Persona "+(i+1)+": ");
            nombre[i]=sc.nextLine();
        }
        for (int i=0; i<N; i++) 
            estudiantes[i].setNombre(nombre[i]);
        

        System.out.println("--- Introduce las edades ---");
        int nota;
        for (int i=0; i<N; i++) {
            System.out.print("Persona "+(i+1)+": ");
            nota=sc.nextInt();
            estudiantes[i].setNota(nota);
        }

        System.out.println("Vector antes:");
        for (Estudiante i:estudiantes) {
            System.out.println("Nombre: "+i.getNombre());
            System.out.println("Edad: "+i.getNota());
            System.out.println();
        }

        Quicksort(estudiantes,0,(estudiantes.length-1));
        
        System.out.println("Vector despues:");
        for (Estudiante i:estudiantes) {
            System.out.println("Nombre: "+i.getNombre());
            System.out.println("Edad: "+i.getNota());
            System.out.println();
        }
    }    
}
