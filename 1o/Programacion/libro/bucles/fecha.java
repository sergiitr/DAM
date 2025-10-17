/**
 * Introducimos el dia el mes y el año y se muestra la fecha del dia siguiente
 * Suponemos que todos los meses tienen 30 dias
 * Si se introduce año=0,se pone como 1
 * @author Sergio Trillo
 */
import java.util.Scanner;
public class fecha{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dia,mes,anio;
        do{
            System.out.println("Intruduzca el dia:");
            dia = sc.nextInt();
        } while (dia>30 || dia<1);
        do{
            System.out.println("Intruduzca el mes:");
            mes = sc.nextInt();
        } while (mes>12 || mes<1);
        do { 
            System.out.println("Intruduzca el anio:");
            anio = sc.nextInt();
        } while (anio==0);
        

        if (dia == 30){
            if (mes==12){
                dia=1;
                mes=1;
                anio+=1;
                if (anio==0)
                    anio+=1;
            } else {
                dia=1;
                mes +=1;
            }
        } else
            dia += 1;
        
        System.out.println("El dia siguiente a la fecha introducida es "+dia+"/"+mes+"/"+anio);
	}
}
