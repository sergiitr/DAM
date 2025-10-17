import java.util.Scanner;
public class ejercicio4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dni;
		System.out.println("Introduzca el DNI: ");
		dni=sc.nextInt();
    	
    	if (String.valueOf(dni).length() != 8)
			System.out.println("Longitud del DNI incorrecta");
		else {    	
			char letraDNI;
			switch(dni%23) {
				case 0:
					letraDNI='T';
					break;
				case 1:
					letraDNI='R';
					break;
				case 2:
					letraDNI='W';
					break;
				case 3:
					letraDNI='A';
					break;
				case 4:
					letraDNI='G';
					break;
				case 5:
					letraDNI='M';
					break;
				case 6:
					letraDNI='Y';
					break;
				case 7:
					letraDNI='F';
					break;
				case 8:
					letraDNI='P';
					break;
				case 9:
					letraDNI='D';
					break;
				case 10:
					letraDNI='X';
					break;
				case 11:
					letraDNI='B';
					break;
				case 12:
					letraDNI='N';
					break;
				case 13:
					letraDNI='J';
					break;
				case 14:
					letraDNI='Z';
					break;
				case 15:
					letraDNI='S';
					break;
				case 16:
					letraDNI='Q';
					break;
				case 17:
					letraDNI='V';
					break;
				case 18:
					letraDNI='H';
					break;
				case 19:
					letraDNI='L';
					break;
				case 20:
					letraDNI='C';
					break;
				case 21:
					letraDNI='K';
					break;
				case 22:
					letraDNI='E';
					break;
				default:
					letraDNI='-';
					break;
			}
			
			System.out.println("Tu DNI es: "+dni+letraDNI);
		}
	}   
}
