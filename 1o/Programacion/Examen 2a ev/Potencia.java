public enum Potencia {
    FUERTE, MEDIA, DEBIL;

    public double getFactor(Potencia potencia) {
        if(potencia==DEBIL)
            return  0.8;
        else if (potencia==MEDIA)
            return 1;
        else
            return 1.2;
    }
}
