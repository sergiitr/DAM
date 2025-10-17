public record TrianguloRectangulo(int base, int altura) {
    /**
     * Se calcula el valor de la hipotenusa 
     * Se calcula haciendo la raiz cuadrada de la suma de los cuadrados de altura y base
     * @return hipotenusa
     */
    public double hipotenusa() {
        double hipotenusa = Math.sqrt(altura*altura+base*base);
        return hipotenusa;
    }
    /**
     * Se calcula la area del cuadrado
     * Se calcula haciendo base por altura
     * @return areaCuadrado
     */
    public double areaCuadrado() {
        double areaCuadrado=(double)base*altura;
        return areaCuadrado;
    }
    /**
     * Se calcula la area del triangulo
     * Se calcula haciendo base por altura dividido entre 2
     * @return areaTriangulo
     */
    public double areaTriangulo() {
        double areaTriangulo=(base*altura)/2;
        return areaTriangulo;
    }
    /**
     * Se calcula el perimetro del cuadrado
     * Se calcula sumando los cuatro lados del cuadrado
     * @return perimetroCuadrado
     */
    public double perimetroCuadrado() {
        double perimetroCuadrado=2*base+2*altura;
        return perimetroCuadrado;
    }
    /**
     * Se calcula el perimetro del triangulo
     * Se calcula sumando la base, la altura y la hipotenusa
     * @return perimetroCuadrado
     */
    public double perimetroTriangulo() {
        double perimetroTriangulo=base+altura+hipotenusa();
        return perimetroTriangulo;
    }

    /**
     * Sobrescribimos el metodo toString()
     * Sacaremos el area y el perimetro tanto del cuadrado como del triangulo
     */
    @Override
    public String toString() {
        return "TrianguloRectangulo[\n   AreaCuadrado: \t"+areaCuadrado()+"cm"+
                                   "\n   AreaTriangulo: \t"+areaTriangulo()+"cm"+
                                   "\n   PerimetroCuadrado: \t"+perimetroCuadrado()+"cm"+
                                   "\n   PerimetroTriangulo: \t"+perimetroTriangulo()+"cm]";
    }
}