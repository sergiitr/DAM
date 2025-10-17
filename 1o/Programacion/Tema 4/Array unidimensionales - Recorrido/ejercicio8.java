import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 5;

        int vector1[] = new int[N];
        int vector2[] = new int[N];
        int vector3[] = new int[N];

        System.out.println("Introduce los valores del primer vector");
        for (int i=0; i<N; i++) {
            System.out.print("Posicion "+i+":");
            vector1[i] = sc.nextInt();
        }
        System.out.println("Introduce los valores del segundo vector");
        for (int i=0; i<N; i++) {
            System.out.print("Posicion "+i+":");
            vector2[i] = sc.nextInt();
        }

        for (int i=0; i<N; i++)
            vector3[i] = vector1[i]+vector2[i];

        System.out.print("vector1[");
        for(int i=0;i<N;i++) 
            System.out.print(vector1[i]+" ");
        
        System.out.println("]");
        
        System.out.print("vector2[");
        for(int i=0;i<N;i++) 
            System.out.print(vector2[i]+" ");
        System.out.println("]");

        System.out.print("vector3[");
        for(int i=0;i<N;i++) 
            System.out.print(vector3[i]+" ");
        System.out.println("]");
    }
}
