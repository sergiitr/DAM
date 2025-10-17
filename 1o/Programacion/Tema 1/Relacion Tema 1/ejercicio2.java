import java.lang.Math;
import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int minutos;
    	System.out.println("Introduce los minutos: ");
    	minutos=sc.nextInt();
    	
    	if(minutos>60) {
			int horas=minutos/60;
			int minutosRestantes=minutos-horas*60;
			System.out.println("Son "+horas+"h con "+minutosRestantes+" minutos");
		} else
			System.out.println("Son "+minutos+" minutos");
	}   
}
