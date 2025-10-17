public class ejercicio5 {
    public static void main(String[] args) {
        Cilindro c1 = new Cilindro(1,2);
        Cilindro c2 = new Cilindro(2,2);
        Cilindro c3 = new Cilindro(3,3);
        Cilindro[] vector = new Cilindro[3];

        vector[0] = c1;
        vector[1] = c2;
        vector[2] = c3;

        float media=0;
        int suma=0;
        
        for (int i=0; i<vector.length; i++)
            suma += vector[i].getRadio();

        media=(float)suma/vector.length;
        System.out.println("El radio medio es "+media+"cm");
    }
}
