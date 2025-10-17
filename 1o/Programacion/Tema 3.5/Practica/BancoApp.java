import java.util.Objects;
import java.util.Scanner;

public class BancoApp {
    /**
     * Metodo para limpiar la pantalla de la consola
     */
    public static void limpiarConsola() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }      

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCuenta, aux, cantidad, cuentaDestino;
        boolean operaciones = true;
        CuentaBancaria c1 = new CuentaBancaria(110, "Sergio");
        CuentaBancaria c2 = new CuentaBancaria(220, "David");
        CuentaBancaria c3 = new CuentaBancaria(330, "Jesus");

        Banco banco1 = new Banco();
        banco1.agregarCuenta(c1);
        banco1.agregarCuenta(c2);
        banco1.agregarCuenta(c3);

        System.out.print("Las cuentas que hay en el banco son:");
        banco1.listarCuentas();

        System.out.println("\n\n");
        do {
            // Leer número de cuenta
            System.out.print("Ingrese un numero de cuenta: ");
            try {
                numCuenta = sc.nextInt();
                if (!Objects.nonNull(banco1.buscaCuenta(numCuenta)))
                    System.out.println("No existe ese numero de cuenta");
                else {
                    System.out.println("Los datos de esa cuenta son:\n" + banco1.buscaCuenta(numCuenta).toString());

                    System.out.println("¿Qué operación quieres hacer en esa cuenta?");
                    System.out.println("Pulse 1 para depositar, 2 para retirar, 3 para transferencia");

                    do {
                        try {
                            aux = sc.nextInt();
                            if (aux != 1 && aux != 2 && aux != 3) {
                                System.out.println("Opción no válida. Por favor ingrese 1, 2 o 3.");
                            }
                        } catch (Exception e) {
                            System.out.println("Entrada no válida. Debe ingresar un número.");
                            sc.nextLine();
                            aux = -1;
                        }
                    } while (aux != 1 && aux != 2 && aux != 3);

                    switch (aux) {
                        case 1:
                            // Depositar
                            try {
                                System.out.print("Introduzca la cantidad que quiera depositar: ");
                                cantidad = sc.nextInt();
                                banco1.buscaCuenta(numCuenta).depositar(cantidad);
                            } catch (Exception e) {
                                System.out.println("Entrada no válida para la cantidad. Intente de nuevo.");
                                sc.nextLine(); 
                            }
                            break;
                        case 2:
                            // Retirar
                            try {
                                System.out.print("Introduzca la cantidad que quiera retirar: ");
                                cantidad = sc.nextInt();
                                banco1.buscaCuenta(numCuenta).retirar(cantidad);
                            } catch (Exception e) {
                                System.out.println("Entrada no válida para la cantidad. Intente de nuevo.");
                                sc.nextLine(); 
                            }
                            break;
                        case 3:
                            try {
                                System.out.print("Introduzca la cantidad que quiera transferir: ");
                                cantidad = sc.nextInt();

                                System.out.print("Introduzca la cuenta a la que va a ir: ");
                                cuentaDestino = sc.nextInt();

                                if (!Objects.nonNull(banco1.buscaCuenta(cuentaDestino)))
                                    System.out.println("No existe ese número de cuenta");
                                else
                                    banco1.buscaCuenta(numCuenta).transferir(banco1.buscaCuenta(cuentaDestino), cantidad);
                            } catch (Exception e) {
                                System.out.println("Entrada no válida para la cantidad o cuenta. Intente de nuevo.");
                                sc.nextLine(); 
                            }
                            break;
                        default:
                            break;
                    }
                    System.out.println("Los datos actualizados de esa cuenta son:\n" + banco1.buscaCuenta(numCuenta).toString());
                }

                limpiarConsola();
            } catch (Exception e) {
                System.out.println("No se ha introducido un numero válido para la cuenta.");
                sc.nextLine();
            }

            
            System.out.print("¿Quieres hacer otra operación? 1 para SI, 2 para NO: ");
            try {
                do {
                    aux = sc.nextInt();
                    if (aux != 1 && aux != 2) {
                        System.out.println("Opción no válida. Ingrese 1 para SI o 2 para NO.");
                    }
                } while (aux != 1 && aux != 2);

                operaciones = aux == 1;

                limpiarConsola();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Debe ingresar 1 para SI o 2 para NO.");
                sc.nextLine(); 
                operaciones = false;
            }
        } while (operaciones);
    }
}
