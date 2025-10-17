
/**
 * Juego del piedra papel tijera
 *
 * @author Sergio Trillo
 */
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion, jugar;
        do {
            /**
             * Se filtra si la opcion es piedra papel o tijera, Si se mete un
             * numero distinto a 1, 2 ó 3, se vuelve a mostrar el mensaje
             */
            do {
                System.out.println("Introduzca una opcion. 1 para piedra 2 para papel o 3 para tijera: ");
                opcion = sc.nextInt();
            } while (opcion != 1 && opcion != 2 && opcion != 3);

            /**
             * Se genera la jugada del ordenador
             */
            int ordenador = (int) (Math.random() * 3) + 1;

            /**
             * Mostramos la jugada del ordenador
             */
            if (ordenador == 1) 
                System.out.println("La maquina escoge piedra "); 
            else if (ordenador == 2) 
                System.out.println("La maquina escoge papel "); 
            else if (ordenador == 3)
                System.out.println("La maquina escoge tijera "); 
            else
                System.out.println("Otro parametro");
            
            /**
             * Muestra quien gana, si humano, maquina o empate
             */
            if ((opcion == 1 && ordenador == 3) || (opcion == 2 && ordenador == 1) || (opcion == 3 && ordenador == 2))
                System.out.println("Gana el humano"); 
            else if (opcion == ordenador) 
                System.out.println("Empate"); 
            else
                System.out.println("Gana la maquina");

            System.out.println();
			
            System.out.println("Quieres volver a jugar? 1 para SI, otro valor para NO");
            jugar = sc.nextInt();
        } while (jugar == 1);
    }
}
