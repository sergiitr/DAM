import java.util.Scanner;
import java.util.Calendar;
public class ejemplo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	Calendar calendario = Calendar.getInstance();
		int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		switch(diaSemana){
			case 1:
				System.out.println("Es domingo");
				break;
			case 2:
				System.out.println("Es lunes");
				break;
			case 3:
				System.out.println("Es martes");
				break;
			case 4:
				System.out.println("Es miercoles");
				break;
			case 5:
				System.out.println("Es jueves");
				break;
			case 6:
				System.out.println("Es viernes");
				break;
			case 7:
				System.out.println("Es sabado");
				break;
			default:
				System.out.println("Dia no valido");
		}
		
		
		System.out.println("Fin del programa");
	}   
}
