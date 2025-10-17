public class ejercicio4 {
    public static void main(String[] args) {
        Cilindro c1 = new Cilindro(1,1);
        Cilindro c2 = new Cilindro(2,2);
        Cilindro c3 = new Cilindro(3,3);
        
        Cilindro[] vector = new Cilindro[3];

        vector[0] = c1;
        vector[1] = c2;
        vector[2] = c3;
        
        for (int i=0; i<vector.length; i++)
            System.out.println(vector[i].toString());
    }
}
