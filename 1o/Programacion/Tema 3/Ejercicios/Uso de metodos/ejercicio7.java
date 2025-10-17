import java.awt.geom.Line2D;
import java.util.Scanner;
public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * Se crea la primera distancia con el constructor x defecto
         */
        Distancia2Puntos d1 = new Distancia2Puntos();
        System.out.println("La distancia es: "+d1.distancia()+"cm");

        /**
         * Se crea la segunda distancia con el constructor de copia
         */
        Distancia2Puntos d2 = new Distancia2Puntos(5,2,6,4);
        System.out.println("La distancia es: "+d2.distancia()+"cm");

        /**
         * Se crea la tercera distancia pasandole los parametros x consola
         */
        Distancia2Puntos d3 = new Distancia2Puntos();
        int a1,b1, a2,b2;
        System.out.println("Introduzca coordenadas (x,y) del pnto A:");
        a1=sc.nextInt();
        a2=sc.nextInt();

        System.out.println("Introduzca coordenadas (x,y) del pnto B:");
        b1=sc.nextInt();
        b2=sc.nextInt();

        d3.setX1(a1);
        d3.setX2(a2);
        d3.setY1(b1);
        d3.setY2(b2);
        System.out.println("La distancia es: "+d3.distancia()+"cm");

        // Cálculo usando Line2D
        Line2D.Double line = new Line2D.Double(a1, b1, a2, b2);
        double distanciaLine2D = line.getP1().distance(line.getP2());
        System.out.println("Distancia calculada usando Line2D: " + (float)distanciaLine2D+"cm");
    }
}