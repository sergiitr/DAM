public class ejercicio8 {
    public static void main(String[] args) {
        ProfesorTitular pt1 = new ProfesorTitular("Sergio Trillo", 2001, "26518076L", "informática", 2024);
        ProfesorTitular pt2 = new ProfesorTitular("Jose Rodriguez", 1996, "12341234A", "informática", 2022);
        ProfesorInterino pi1 = new ProfesorInterino("Luis Alonso", 1999, "11111111A", "informática", 3);
        ProfesorInterino pi2 = new ProfesorInterino("Jose Blanco", 2002, "22222222B", "informática", 5);
        ProfesorInterino pi3 = new ProfesorInterino("Gabriel Garrido", 1979, "33333333C", "informática", 11);
        
        Claustro c1 = new Claustro("IES Virgen del Carmen");
        c1.anadirProfesor(pt1);
        c1.anadirProfesor(pt2);
        c1.anadirProfesor(pi1);
        c1.anadirProfesor(pi2);
        c1.anadirProfesor(pi3);

        System.out.println();
        System.out.println("--- MOSTRAMOS LOS PROFESORES ---");
        c1.listarProfesores();

        System.out.println();
        System.out.println("--- EDAD MEDIA ---");
        System.out.println("La edad media es: "+c1.edad_media());
        System.out.println();

        System.out.println("--- BORRAMOS UN PROFESOR ---");
        c1.borrarProfesor(pi2);
        c1.listarProfesores();

        System.out.println();
        System.out.println("--- EDAD MEDIA ---");
        System.out.println("La edad media es: "+c1.edad_media());

        System.out.println();
        c1.profesorMasAntiguedad();

        System.out.println("Hay "+c1.profesoresPorEspecialidad("informática")+" de informática");
    }
}
