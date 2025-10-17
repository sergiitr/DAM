import java.util.Scanner;

public class ejercicio2 {
    static void menu(int opcion, int num1, int num2) {
        int salida=0;
        double salidaDivision=0;
        switch (opcion) {
            case 1:
                salida=num1+num2;
                System.out.println("La suma es: "+salida);
                break;
            case 2:
                salida=num1-num2;
                System.out.println("La resta es: "+salida);
                break;
            case 3:
                salida=num1*num2;
                System.out.println("La multiplicacion es: "+salida);
                break;
            case 4:
                salidaDivision=(double)num1/num2;
                System.out.println("La division es: "+salidaDivision);
                break;
            default:
                System.out.println("Valor no corresponde a ninguna operacion");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcion,num1,num2;
        System.out.println("Introduce el numero 1: ");
        num1=sc.nextInt();
        System.out.println("Introduce el numero 2: ");
        num2=sc.nextInt();

        System.out.println("---Menu---");
        System.out.println("Opcion 1: Suma");
        System.out.println("Opcion 2: Resta");
        System.out.println("Opcion 3: Multiplicacion");
        System.out.println("Opcion 4: Division");

        do {
            System.out.println("Introduzca opcion: ");
            opcion=sc.nextInt();
            menu(opcion,num1,num2);
        }while (opcion<=4);

    }
}
