import java.util.Scanner;
public class ejercicio5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double saldo=1000;
		int opciones;
		do{
			System.out.println("Introduzca opcion: ");
			opciones=sc.nextInt();
			switch (opciones){
				case 1:
					System.out.println("El saldo actual es "+saldo+"€");
					break;
				case 2:
					double ingreso;
					System.out.println("Introduzca el importe que quiera ingresar:");
					ingreso=sc.nextDouble();
					saldo+=ingreso;
					break;
				case 3:
					double retirar;
					System.out.println("Introduzca el importe que quiera retirar:");
					retirar=sc.nextDouble();
					saldo-=retirar;
					break;
				case 4:
					System.out.println("Salir");
					break;
				default:
					System.out.println("Introduzca valor valido");
					break;
			}
		} while (opciones != 4);
	} 
}
