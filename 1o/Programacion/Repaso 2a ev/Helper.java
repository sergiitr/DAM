public class Helper {
    public static boolean validarCodigo(String codigo) {
        if (codigo.charAt(0)=='G' && codigo.charAt(1)=='E' && codigo.charAt(2)!='0')
            return true;
        else if (codigo.charAt(0)=='R' && codigo.charAt(1)=='E' && codigo.charAt(2)!='0')
            return true;
        else if (codigo.charAt(0)=='S' && codigo.charAt(1)=='R' && codigo.charAt(2)=='E' && codigo.charAt(3)!=0)
            return true;
        else
            return false;
    }
}
