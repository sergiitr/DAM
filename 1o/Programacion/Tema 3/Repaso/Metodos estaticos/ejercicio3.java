import java.util.Scanner;
public class ejercicio3 {
    static double distancia(int x1,int x2,int y1, int y2) {
        double distancia=0;
        distancia = Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)  );
        return distancia;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x1, x2, y1, y2;
        System.out.println("---Introduzca las cordenadas de x---");
        System.out.print("x1: ");
        x1=sc.nextInt();
        System.out.print("x2: ");
        x2=sc.nextInt();
        System.out.println("---Introduzca las cordenadas de y---");
        System.out.print("y1: ");
        y1=sc.nextInt();
        System.out.print("y2: ");
        y2=sc.nextInt();

        System.out.println("La distancia es: "+distancia(x1,x2,y1,y2) );
    }
}
