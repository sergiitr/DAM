import java.util.Scanner;
public class ejercicio4 {
    static int calculadoraSegundos(int dias,int horas,int minutos) {
        int segundos=0;

        segundos=minutos*60+horas*60*60+dias*24*60*60;

        return segundos;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int dia,hora,minuto;

        System.out.print("Introduzca los dias: ");
        dia=sc.nextInt();
        System.out.print("Introduzca las horas: ");
        hora=sc.nextInt();
        System.out.print("Introduzca los minutos: ");
        minuto=sc.nextInt();

        System.out.println("Hay un total de "+calculadoraSegundos(dia,hora,minuto)+" segundos");
    }
}
