import java.util.Scanner;
public class ejercicio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numeroUsuario, numeroMaquina;
		numeroMaquina=(int)(Math.random()*100);
		System.out.println("El numero de la maquina es: "+numeroMaquina);
		do{
			System.out.println("Introduce un numero: ");
			numeroUsuario=sc.nextInt();
			if (numeroUsuario>numeroMaquina)
				System.out.println("El numero introducido es mayor");
			else if(numeroUsuario<numeroMaquina)
				System.out.println("El numero introducido es menor");
		}while (numeroUsuario != numeroMaquina);
		System.out.println("Adivinaste el numero!");
	}
}
