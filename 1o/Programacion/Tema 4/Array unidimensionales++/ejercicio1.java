import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int TOTAL_EMPLEADOS=10;
        int opcion,totalEmpleados=0;
        Empleado[] empleado=new Empleado[TOTAL_EMPLEADOS];
        String dni;
        double edadMedia=0;

        /**
         * Para introducir los parametros de los usuarios
         */
        String intNombre, intApellidos,intDNI;
        int intEdad, intSueldo;
        do {
            System.out.println("Introduduzca valor: ");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    if (totalEmpleados<TOTAL_EMPLEADOS) {
                        System.out.print("Introduce nombre: ");
                        intNombre = sc.nextLine();
                        System.out.print("Introduzca apellidos: ");
                        intApellidos = sc.nextLine();
                        do {
                            System.out.print("Introduce el DNI: ");
                            intDNI = sc.nextLine();
                        } while (intDNI.length() != 9);
                        System.out.print("Introduce la edad: ");
                        intEdad = sc.nextInt();
                        System.out.print("Introduce el sueldo: ");
                        intSueldo = sc.nextInt();
                        empleado[totalEmpleados] = new Empleado(intDNI,intNombre,intApellidos,intEdad,intSueldo);
                        totalEmpleados++;
                    } else
                        System.out.println("No se pueden introducir mas empleados");
                    break;
                case 2:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        for (int i=0;i<totalEmpleados;i++) {
                            System.out.println("--- Empleado "+(i+1)+" ---");
                            System.out.println(empleado[i].toString());
                        }
                    }
                    break;
                case 3:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        System.out.println("Introduzca un dni: ");
                        dni=sc.nextLine();
                        for (int i=0; i<totalEmpleados;i++) {
                            if (empleado[i].getDni().equals(dni)) 
                                System.out.println(empleado[i].toString());
                        }
                    }
                    break;
                case 4:
                    int aux=0;
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        for (int i=0; i<totalEmpleados; i++) {
                            aux += empleado[i].getEdad();
                        }
                        edadMedia = (double)aux/totalEmpleados;
                    }
                    break;
                case 5:
                    int pos;
                    do {
                        System.out.println("Introduzca una posicion:");
                        pos=sc.nextInt();
                    } while (pos>(totalEmpleados+1));
                    System.out.println("El sueldo del empleado de la posicion "+pos+" es: "+empleado[pos].getSueldo());
                    break;
                case 6:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        String nuevoNombre;
                        System.out.println("Introduzca un dni: ");
                        dni=sc.nextLine();
                        for (int i=0; i<totalEmpleados;i++) {
                            if (empleado[i].getDni().equals(dni)) {
                                System.out.print("Introduce el nuevo nombre: ");
                                nuevoNombre=sc.nextLine();
                                empleado[i].setNombre(nuevoNombre);
                            } 
                        }
                    }
                    break;
                case 7:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        int nuevaEdad;
                        System.out.println("Introduzca un dni: ");
                        dni=sc.nextLine();
                        for (int i=0; i<totalEmpleados;i++) {
                            if (empleado[i].getDni().equals(dni)) {
                                System.out.print("Introduce la nueva edad: ");
                                nuevaEdad=sc.nextInt();
                                empleado[i].setEdad(nuevaEdad);
                            } 
                        }
                    }
                    break;
                case 8:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        int nuevoSueldo;
                        System.out.println("Introduzca un dni: ");
                        dni=sc.nextLine();
                        for (int i=0; i<totalEmpleados;i++) {
                            if (empleado[i].getDni().equals(dni)) {
                                System.out.print("Introduce el nuevo sueldo: ");
                                nuevoSueldo=sc.nextInt();
                                empleado[i].setEdad(nuevoSueldo);
                            } 
                        }
                    }
                    break;
                case 9:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        Empleado empleadoAUX = new Empleado();
                        for (int i=0; i<totalEmpleados;i++) {
                            if (empleadoAUX.getSueldo()<=empleado[i].getSueldo()) 
                                empleadoAUX=empleado[i];
                        }
                        System.out.println("Los datos del empleado con mayor sueldo es:");
                        System.out.println(empleadoAUX.toString());
                    }
                    break;
                default: 
                    System.out.println("Se sale del programa");
                    break;
            }
        } while (opcion < 10);
    }    
}
