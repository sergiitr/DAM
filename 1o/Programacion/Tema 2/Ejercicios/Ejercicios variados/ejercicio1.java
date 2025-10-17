import java.util.Scanner;
public class ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String dia;
		
		System.out.println("Introdruzca un dia: ");
		dia=sc.nextLine();
		
		switch (dia.toLowerCase()) {
			case "lunes":
				System.out.println("Es laborable");
				break;
			case "martes": 
				System.out.println("Es laborable");
				break;
			case "miercoles": 
				System.out.println("Es laborable");
				break;
			case "jueves": 
				System.out.println("Es laborable");
				break;
			case "viernes": 
				System.out.println("Es laborable");
				break;
			case "sabado":
				System.out.println("NO es laborable");
				break;
			case  "domingo":
				System.out.println("NO es laborable");
				break;
			default:
				System.out.println("Parametro no valido");
				break;
		}
	}
}
