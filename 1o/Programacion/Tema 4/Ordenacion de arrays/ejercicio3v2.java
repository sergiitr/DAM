import java.util.Scanner;

public class ejercicio3v2 {
    /*
     * Metodo de Ordenamiento x insercción
     */
    public static void inserccionSort(Estudiante[] array) {
    	for (int i=1; i < array.length; i++) {
        	Estudiante aux=array[i]; // Elemento actual a insertar
        	int j=i-1;
        	// Desplazar los elementos mayores que aux hacia la derecha
        	while (j >= 0 && array[j].getNota() > aux.getNota()) {
            	array[j+1]=array[j];
            	j--;
        	}
        	// Insertar la clave en su posición correcta
        	array[j+1]=aux;
    	}
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Estudiante[] estudiantes=new Estudiante[10];
        final int N=estudiantes.length;
        for (int i=0;i<N;i++)
            estudiantes[i]=new Estudiante();
        
        String[] nombre=new String[10];
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

        System.out.println("--- Vector antes ---");
        for (Estudiante i:estudiantes) {
            System.out.println("Nombre: "+i.getNombre());
            System.out.println("Edad: "+i.getNota());
            System.out.println();
        }

        inserccionSort(estudiantes);
        
        System.out.println("---Vector despues ---");
        for (Estudiante i:estudiantes) {
            System.out.println("Nombre: "+i.getNombre());
            System.out.println("Edad: "+i.getNota());
            System.out.println();
        }
    }    
}