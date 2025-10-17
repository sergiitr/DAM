import java.util.Random;
public class Persona {
    public Persona() {
    }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Persona(String nombre, String apellidos, int edad, double peso, int altura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(Persona p1) {
        this.nombre = p1.nombre;
        this.apellidos = p1.apellidos;
        this.edad = p1.edad;
        this.peso = p1.peso;
        this.altura = p1.altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        this.DNI=generarDNI();
        return this.DNI;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double calcularIMC() {
        int numero;
        double alturaMetros = (double) altura / 100;
        double resultado = peso / (alturaMetros * alturaMetros);
        if (resultado < 20)
            numero = -1;
        else if (resultado >= 20 && resultado <= 25)
            numero = 0;
        else
            numero = 1;

        return numero;
    }

    public boolean esMayorDeEdad() {
        boolean comp;
        if (this.edad >= 18)
            comp = true;
        else
            comp = false;
        return comp;
    }

    public String generarDNI() {
        char letraDNI;
        int numeroDNI;
        String nuestroDNI = " ";
        Random ran = new Random();
        int min=10000000;
        int max=99999999;
        numeroDNI=ran.nextInt(min,max);
        switch (numeroDNI % 23) {
            case 0:
                letraDNI = 'T';
                break;
            case 1:
                letraDNI = 'R';
                break;
            case 2:
                letraDNI = 'W';
                break;
            case 3:
                letraDNI = 'A';
                break;
            case 4:
                letraDNI = 'G';
                break;
            case 5:
                letraDNI = 'M';
                break;
            case 6:
                letraDNI = 'Y';
                break;
            case 7:
                letraDNI = 'F';
                break;
            case 8:
                letraDNI = 'P';
                break;
            case 9:
                letraDNI = 'D';
                break;
            case 10:
                letraDNI = 'X';
                break;
            case 11:
                letraDNI = 'B';
                break;
            case 12:
                letraDNI = 'N';
                break;
            case 13:
                letraDNI = 'J';
                break;
            case 14:
                letraDNI = 'Z';
                break;
            case 15:
                letraDNI = 'S';
                break;
            case 16:
                letraDNI = 'Q';
                break;
            case 17:
                letraDNI = 'V';
                break;
            case 18:
                letraDNI = 'H';
                break;
            case 19:
                letraDNI = 'L';
                break;
            case 20:
                letraDNI = 'C';
                break;
            case 21:
                letraDNI = 'K';
                break;
            case 22:
                letraDNI = 'E';
                break;
            default:
                letraDNI = '-';
                break;
        }
        String numDNI = Integer.toString(numeroDNI);
        String letDNI = Character.toString(letraDNI);
        
        nuestroDNI=numDNI.concat(letDNI);
        return nuestroDNI;
    }

    @Override
    public String toString() {
        return "Persona [nombre="+nombre+", apellidos="+apellidos+", edad="+edad+", peso="+peso+", altura="+altura+", DNI()="+this.DNI+"]";
    }

    private String nombre;
    private String apellidos;
    private int edad;
    private String DNI;
    private double peso;
    private int altura;
}
