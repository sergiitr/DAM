/**
 * Ejercicio 1
 * @author Sergio Trilo Rodriguez
 */
import java.util.Scanner;
public class TRSergioEjercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c,d,e,f;
        /**
         * Hacemos los objetos e1 y e2 pasando nosotros los parametros
         */
        TRSergioEcuacionesLineales e1 = new TRSergioEcuacionesLineales();
        System.out.println("Introduce a: ");
        a = sc.nextInt();
        System.out.println("Introduce b: ");
        b = sc.nextInt();
        System.out.println("Introduce c: ");
        c = sc.nextInt();
        System.out.println("Introduce d: ");
        d = sc.nextInt();
        System.out.println("Introduce e: ");
        e = sc.nextInt();
        System.out.println("Introduce f: ");
        f = sc.nextInt();
        
        e1.setA(a);
        e1.setB(b);
        e1.setC(c);
        e1.setD(d);
        e1.setE(e);
        e1.setF(f);
   
        System.out.println("Ecuacion 1:\n"+e1.toString());

        /**
         * Creamos e2 con el constructor de copia
         */
        TRSergioEcuacionesLineales e2 = new TRSergioEcuacionesLineales(2,1,-1,2,7,-1);
        System.out.println("Ecuacion 2:\n"+e2);

        /**
         * Hacemos el objeto e3 con el constructor por defecto
         */
        TRSergioEcuacionesLineales e3 = new TRSergioEcuacionesLineales();
        /**
         * Comprobamos si e1 y e2 son iguales o no
         */
        if (e1.equals(e2) == true)
            System.out.println("e1 y e2 son iguales");
        else
            System.out.println("e1 y e2 NO son iguales");

        /**
         * Comprobamos si e1 y e3 son iguales o no
         */
        if (e1.equals(e3) == true)
            System.out.println("e1 y e3 son iguales");
        else
            System.out.println("e1 y e3 NO son iguales");
    }
}