
import java.util.Random;
import java.util.Scanner;

public class TRSergio {
    /**
     * Funcion para crear nuevo personaje. Crearemos una guerrera, un bandido o un marginado
     * @return personaje
     */
    private static Personaje crearPersonaje() {
        Scanner sc = new Scanner(System.in);
        Personaje p1;
        final int GUERRERA=1;
        final int BANDIDO=2;
        final int MARGINADO=3;
        System.out.println("--- Se crea personaje ---");
        System.out.println("---Menu---");
        System.out.println("1. Guerrera");
        System.out.println("2. Bandido");
        System.out.println("3. Marginado");
        
        int opcion;
        do {
            System.out.println("Introduce una opcion: ");
            opcion=sc.nextInt();
        } while (opcion!=GUERRERA && opcion!=BANDIDO && opcion!=MARGINADO);

        if (opcion==GUERRERA) {
            Personaje personaje=new Personaje("guerrera", "guerrera", 1500, 200, 100);
            p1=personaje;
        } else if (opcion==BANDIDO) {
            Personaje personaje=new Personaje("bandido", "bandido", 1300, 300, 60);
            p1=personaje;
        } else {
            Personaje personaje=new Personaje("marginado", "marginado", 800, 200, 80);
            p1=personaje;
        }
        System.out.println("Se ha creado el personaje correctamente");
        return p1;
    }

    /**
     * Funcion para elegir si atacamos o bebemos 
     * @param pj Personaje
     * @param artorias Personaje
     */
    private static void accion(Personaje pj, Personaje artorias) {
        Scanner sc = new Scanner(System.in);
        final int ATACAR=1;
        final int BEBER=2;

        System.out.println("---Menu---");
        System.out.println("1. Atacar");
        System.out.println("2. Beber");

        int opcion;
        do { 
            System.out.println("Introduce una opcion: ");
            opcion=sc.nextInt();
        } while (opcion!=ATACAR && opcion!=BEBER);

        if (opcion==ATACAR)
            artorias.recibirGolpe(pj.atacar());
        else {
            pj.beberEstus();
            System.out.println("Has bebido estus. La vida actual del personaje es de "+pj.getVidaActual()+" puntos");
        }
    }


    public static void main(String[] args) {
        Escudo escudoArtorias = new Escudo("Gran Escudo de Artorias", 80);
        Arma armaArtorias = new Arma("Espadon de Artorias", 60);
        Personaje artorias = new Personaje("Artorias", "Boss", 3000, 200, 150,escudoArtorias,armaArtorias);

        Personaje personaje = new Personaje();
        personaje=crearPersonaje();
        Escudo escudoPersonaje = new Escudo("Escudo emblema hierba", 30);
        personaje.equiparEscudo(escudoPersonaje);
        Arma armaPersonaje = new Arma("Claymore", 40);
        personaje.equiparArma(armaPersonaje);


        do { 
            Random random = new Random();
            int turno = random.nextInt(4);

            if (turno==1) {
                System.out.println("--Turno de Artorias ---");
                personaje.recibirGolpe(artorias.atacar());
                System.out.println("La vida de nuestro personaje despues del ataque es de: "+personaje.getVidaActual());
            } else {
                System.out.println("--Turno del personaje ---");
                accion(personaje,artorias);
                System.out.println("La vida de Artorias es de "+artorias.getVidaActual());
            }
        } while (artorias.getVidaActual()!=0 && personaje.getVidaActual()!=0);

        if(artorias.getVidaActual() == 0) 
            System.out.println("Artorias es el que ha muerto. Has ganado!");
        
        if (personaje.getVidaActual() == 0)
            System.out.println("Nuestro personaje es el que ha muerto. Has perdido!");
        
        System.out.println("Fin de la partida");
    }
}

record Arma(String nombre, int danio) {
    
}

record Escudo (String nombre, int defensa) {
    
}

class Personaje {
    public Personaje() {
    }
    public Personaje(String nombre, String clase, int vidaMaxima, int fuerza, int resistencia) {
        this.nombre = nombre;
        this.clase = clase;
        this.vidaMaxima = vidaMaxima;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.vidaActual = vidaMaxima;
    }

    public Personaje(String nombre, String clase, int vidaMaxima, int fuerza, int resistencia, Escudo escudo, Arma arma) {
        this.nombre = nombre;
        this.clase = clase;
        this.vidaMaxima = vidaMaxima;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.escudo = escudo;
        this.arma = arma;
        this.vidaActual = vidaMaxima;
    }

    public int getVidaActual() {
        return this.vidaActual;
    }

    /**
     * Se calcula la defensa del Personaje
     * @return defensaPesonaje
     */
    private int defensa() {
        int defensaPersonaje=this.escudo.defensa()+2*this.resistencia;
        return defensaPersonaje;
    }

    /**
     * Funcion morir
     * Sale un mensaje por pantalla de que ha
     */
    private void morir() {
        this.vidaActual=0;
        System.out.println("HAS MUERTO");
    }

    /**
     * Hacemos el metodo recibir golpe
     * Si el golpe es mayor que la suma de la vida actual y del escudo, el personaje se muere
     * Si el golpe es mayor que la defensa del escudo, al guerrero le baja la vida
     * En caso contrario, la vidaActual se mantiene 
     * @param golpe
     */
    public void recibirGolpe(int golpe) {
        if ( golpe>=(this.vidaActual+escudo.defensa()) )
            morir();
        else if ( golpe>escudo.defensa() )
            this.vidaActual = this.vidaActual - ( golpe-escudo.defensa());
        else
            this.vidaActual = this.vidaActual;
    }

    /**
     * Hacemos el metodo atacar.
     * El ataque es la fuera nuestra mas la del arma
     * @return ataque
     */
    public int atacar() {
        int ataque = (this.fuerza+arma.danio());
        return ataque;
    }

    /**
     * Metodo beberEstus
     * Sila resistencia*3 es mayor que la vidaMaxima, se devuelve la totalidad de la vida, en caso contrario, solamente la resistencia*3
     * Cada vez que bebamos decrementamos la pocima en 1. Si llegamos a 0 no podemos volver a beber
     */
    public void beberEstus() {
        if(this.estus>0) {
            if ( this.resistencia*3 >= this.vidaMaxima  )
                this.vidaActual = this.vidaMaxima;
            else
                this.vidaActual = this.resistencia*3;
            
            this.estus -= 1;
        } else
            System.out.println("No te quedan estus");
    }

    /**
     * Equipamos arma
     * @param arma
     */
    public void equiparArma(Arma arma) {
        if (this.arma != null) 
            this.arma=null;
        
        this.arma=arma;
        System.out.println("Se acaba de equipar con una arma "+arma.nombre());
    }

    /**
     * Equipamos escudo
     * @param escudo
     */
    public void equiparEscudo(Escudo escudo) {
        if(this.escudo != null) 
            this.escudo = null;
        
        this.escudo = escudo;
        System.out.println("Se acaba de equipar con un escudo "+escudo.nombre());
    }

    private String nombre;
    private String clase;
    private int vidaMaxima;
    private int vidaActual;
    private int fuerza;
    private int resistencia;
    private int estus=10;
    private Escudo escudo;
    private Arma arma;
}
