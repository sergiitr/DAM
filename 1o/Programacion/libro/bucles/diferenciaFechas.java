/**
 * Introducimos el dia el mes y el año y se muestra la fecha del dia siguiente
 * Suponemos que todos los meses tienen 30 dias
 * Si se introduce año=0,se pone como 1
 * @author Sergio Trillo
 */
import java.util.Scanner;
public class diferenciaFechas{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dia,mes,anio, dia2,mes2,anio2, diferencia=0,diferenciaMes,diferenciaAnio;

        System.out.println("Datos primera fecha");
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
        
        System.out.println("Datos segunda fecha (mayor de la primera fecha)");
        do{
            System.out.println("Intruduzca el dia:");
            dia2 = sc.nextInt();
        } while (dia2>30 ||dia2<1);
        do{
            System.out.println("Intruduzca el mes:");
            mes2 = sc.nextInt();
        } while (mes2>12 || mes2<1);
        do { 
            System.out.println("Intruduzca el anio:");
            anio2 = sc.nextInt();
        } while (anio2==0);


        if (anio==anio2) {
            if (mes==mes2) {
                if(dia==dia2)
                    System.out.println("No hay diferencia");
                else if(dia>dia2)
                    System.out.println("Primera fecha mayor que la segunda");
                else
                    diferencia = dia2-dia;
            } else if (mes > mes2) {
                System.out.println("Primera fecha mayor que la segunda");
            } else {
                diferenciaMes=mes2-mes;
                diferencia=diferenciaMes*30+(dia2-dia);
            }
        }else if (anio2>anio){
            if (mes==mes2) {
                if(dia==dia2) {
                    diferencia=(anio2-anio)*365;
                } else if (dia2>dia) {
                    diferencia=(anio2-anio)*365+(dia2-dia);
                } else {
                    diferencia=(anio2-anio)*365+(dia-dia2);
                }
            } else if (mes2>mes){
                if(dia==dia2) {
                    diferencia=(anio2-anio)*365+(mes2-mes)*30;
                } else if (dia2>dia) {
                    diferencia=(anio2-anio)*365+(mes2-mes)*30+(dia2-dia);
                } else {
                    diferencia=(anio2-anio)*365+(mes2-mes)*30+(dia-dia2);
                }
            }else {
                if(dia==dia2) {
                    diferencia=(anio2-anio)*365+(mes-mes2)*30;
                } else if (dia2>dia) {
                    diferencia=(anio2-anio)*365+(mes-mes2)*30+(dia-dia2);
                } else {
                    diferencia=(anio2-anio)*365+(mes-mes2)*30+(dia2-dia);
                }
            }
        }else{
            System.out.println("Primera fecha mayor que la segunda");
            diferencia=0;
        }
        System.out.println("La diferencia de entre ambas fechas son "+diferencia+" dias");
	}
}