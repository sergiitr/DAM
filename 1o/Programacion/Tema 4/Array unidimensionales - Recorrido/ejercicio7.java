import java.util.Random;

public class ejercicio7 {
    public static void main(String[] args) {
        Random r = new Random();
        final int N = r.nextInt(2,10);
        int aux;
        int[] vector = new int[N];
        int[] vector2 = new int[N];

        // Se crea el vector[]
        for (int i=0; i<N; i++)
            vector[i]=r.nextInt();
        
        // Se asocia el vector[] a vector2[]
        for (int i=0; i<N; i++)
            vector2[i]=vector[i];
        
        // Se intercambia el orden
        for (int i=0; i<(N-1); i++) {
            for (int j=i+1; j<N;j++){
                aux=vector2[i];
                vector2[i]=vector2[j];
                vector2[j]=aux;
            }
        }

        System.out.print("vector[");
        for (int i=0; i<N;i++)
            System.out.print(vector[i]+" ");
        System.out.println("]");

        System.out.print("vector2[");
        for (int i=0; i<N;i++)
            System.out.print(vector2[i]+" ");
        System.out.println("]");
    }
}
