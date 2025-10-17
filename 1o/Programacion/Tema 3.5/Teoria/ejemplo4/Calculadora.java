public class Calculadora {
    public Calculadora() {
        this.num1=2;
        this.num2=3;
    }
    
    public Calculadora(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }
    
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    
    public int getNum2() {
        return num2;
    }
    
    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int suma() {
        int suma = this.num1+this.num2;
        return suma;
    }

    public int resta() {
        int resta = this.num1-this.num2;
        return resta;
    }

    public int multiplicacion() {
        int multiplicacion = this.num1*this.num2;
        return multiplicacion;
    }

    public double division() {
        try {
            if(this.num2==0){
                throw new ArithmeticException("El segundo numero es 0");
            }
            double division = (double)this.num1/this.num2;
            return division;
        } catch (ArithmeticException e) {
            System.out.println("Division entre 0, no se puede realizar");
        }
        return 0;
    }

    private int num1;
    private int num2;
}
