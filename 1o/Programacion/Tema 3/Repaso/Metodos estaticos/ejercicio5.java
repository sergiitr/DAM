import java.util.Scanner;
public class ejercicio5 {
    /**
     * Suponemos q la segunda es mayor q la primera
     * @param hora1
     * @param minuto1
     * @param hora2
     * @param minuto2
     * @return minutosDiferencia (cantidad de minutos de diferencia)
     */
    static int diferenciaMin(int hora1, int minuto1, int hora2,int minuto2) {
        int minutosDiferencia=0;
        if(hora2>hora1) {
            minutosDiferencia+=(hora2-hora1)*60;
            if(minuto2>=minuto1)
                minutosDiferencia=minutosDiferencia+(minuto2-minuto1);
            else 
                minutosDiferencia=minutosDiferencia-(minuto1-minuto2);
        } else if (hora2==hora1) {
            if(minuto2>=minuto1) 
                minutosDiferencia+=(minuto2-minuto1);
            else 
                minutosDiferencia-=(minuto1-minuto2);
        }else 
            minutosDiferencia=-1;
        return minutosDiferencia;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int h1,m1,h2,m2;
        System.out.println("----- Hora y minutos 1 -----");
        System.out.print("Introduce la hora 1: ");
        h1=sc.nextInt();
        System.out.print("Introduce el minuto 1: ");
        m1=sc.nextInt();
        System.out.println("----- Hora y minutos 2 -----");
        System.out.print("Introduce la hora 2: ");
        h2=sc.nextInt();
        System.out.print("Introduce el minuto 2: ");
        m2=sc.nextInt();

        if(diferenciaMin(h1,m1,h2,m2)>=0) 
            System.out.println("La diferencia es de "+diferenciaMin(h1,m1,h2,m2)+" minutos");
        else 
            System.out.println("La primera hora es mayor");
    }
}
