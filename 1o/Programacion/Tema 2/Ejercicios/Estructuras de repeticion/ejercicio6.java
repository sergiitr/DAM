import java.util.Scanner;
public class ejercicio6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	
       	int numero;
       	System.out.println("Introduzca el numero: ");
       	numero=sc.nextInt();
       	
       	int[] vector= new int[numero];
       	if (numero<=0){
			System.out.println("No se puede hacer fibonacci");
		}else if (numero==1) {
			vector[0]=0;
			System.out.println("Los primeros "+numero+" elementos de la sucesion son:");
			System.out.println(vector[0]);
		} else if(numero>=2) {
			vector[0]=0;
			vector[1]=1;
		
			System.out.println("Los primeros "+numero+" elementos de la sucesion son:");
			
			if (numero<=2) {
				System.out.println(vector[0]+" "+vector[1]);
			} else{
				for (int i=2; i<numero; i++) {
					vector[i]=vector[i-1]+vector[i-2];
				}
				for (int i=0; i<numero; i++) {
					System.out.print(vector[i]+" ");
				}
			}
		}
	}
}
