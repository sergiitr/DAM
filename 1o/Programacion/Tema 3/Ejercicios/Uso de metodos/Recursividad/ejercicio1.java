package Recursividad;

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;

        System.out.println("Introduzca el valor de A:");
        a=sc.nextInt();
        System.out.println("Introduzca el valor de B:");
        b=sc.nextInt();

        System.out.println("El mcd("+a+","+b+")="+mcd(a,b));
    }

    /**
     * Se crea una funcion para crear el mcd de dos numeros
     * @param x
     * @param y
     * @return el mcd de ambos numeros
     */
    public static int mcd(int x, int y) {
        if (x==0)
            return y;
        else if(y==0)
            return x;
        else if(x>=y)
            return mcd(x-y,y);
        else
            return mcd(x,y-x);
    }
}
