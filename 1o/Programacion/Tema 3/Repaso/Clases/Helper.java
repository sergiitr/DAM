public class Helper {
    /**
     * Comprobamos si un dni es correcto
     * @param dni
     * @return true si es correcto false si es incorrecto
     */
    public static boolean comprobarDNI(String dni) {       
        final int LONGITUD = dni.length();
        if (LONGITUD != 9)
            return false;
        
        for (int i=0; i<(LONGITUD-1); i++) {
            if( Character.getNumericValue(dni.charAt(i)) != 0 && Character.getNumericValue(dni.charAt(i)) != 1 && Character.getNumericValue(dni.charAt(i)) != 2 && Character.getNumericValue(dni.charAt(i)) != 3 && Character.getNumericValue(dni.charAt(i)) != 4 &&  
                Character.getNumericValue(dni.charAt(i)) != 5 && Character.getNumericValue(dni.charAt(i)) != 6 && Character.getNumericValue(dni.charAt(i)) != 7 && Character.getNumericValue(dni.charAt(i)) != 8 && Character.getNumericValue(dni.charAt(i)) != 9 ) {
                    System.out.println(Character.getNumericValue(dni.charAt(i)) );
                    return false;
            }
        }
        if( dni.charAt(LONGITUD-1) == 0 || dni.charAt(LONGITUD-1) == 1 || dni.charAt(LONGITUD-1) == 2 || dni.charAt(LONGITUD-1) == 3 || dni.charAt(LONGITUD-1) == 4 ||  
            dni.charAt(LONGITUD-1) == 5 || dni.charAt(LONGITUD-1) == 6 || dni.charAt(LONGITUD-1) == 7 || dni.charAt(LONGITUD-1) == 8 || dni.charAt(LONGITUD-1) == 9 ) {
            return false;
        }
        return true;
    }

    /**
     * Comprobamos si un pasaporte es corecto
     * @param pasaporte
     * @return true si es correcto false si es incorrecto
     */
    public static boolean comprobarPasaporte(String pasaporte) {
        final int LONGITUD = pasaporte.length();
        if (LONGITUD != 9)
            return false;
        for (int i=0; i<3; i++) {
            if( pasaporte.charAt(i) == 0 || pasaporte.charAt(i) == 1 || pasaporte.charAt(i) == 2 || pasaporte.charAt(i) == 3 || pasaporte.charAt(i) == 4 ||  
                pasaporte.charAt(i) == 5 || pasaporte.charAt(i) == 6 || pasaporte.charAt(i) == 7 || pasaporte.charAt(i) == 8 || pasaporte.charAt(i) == 9 ) {
                    return false;
            }
        }
        for (int i=3; i<LONGITUD; i++) {
            if( Character.getNumericValue(pasaporte.charAt(i)) != 0 && Character.getNumericValue(pasaporte.charAt(i)) != 1 && Character.getNumericValue(pasaporte.charAt(i)) != 2 && Character.getNumericValue(pasaporte.charAt(i)) != 3 && Character.getNumericValue(pasaporte.charAt(i)) != 4 &&  
                Character.getNumericValue(pasaporte.charAt(i)) != 5 && Character.getNumericValue(pasaporte.charAt(i)) != 6 && Character.getNumericValue(pasaporte.charAt(i)) != 7 && Character.getNumericValue(pasaporte.charAt(i)) != 8 && Character.getNumericValue(pasaporte.charAt(i)) != 9 ) {
                    return false;
            }
        }
        return true;
    }

    /**
     * Comprobar si el IBAN es correcto o no
     * @param iban
     * @return true si es correcto, false si es incorrecto
     */
    public static boolean comprobarIBAN(String iban) {
        final int LONGITUD=iban.length();
        int contGiones=0;
        int contEspacios=0;

        if( (iban.charAt(0) != 'E') || (iban.charAt(1) != 'S') )
            return false;

        for (int i=0;i<LONGITUD; i++) {
            if ( iban.charAt(i) == '_')
                contGiones++;
        }
        for (int i=0;i<LONGITUD; i++) {
            if ( iban.charAt(i) == ' ')
                contEspacios++;
        }

        if (contEspacios==0 && contGiones==0) {
            if(LONGITUD!=24) 
                return false;
        } else {
            if (contEspacios>0 && contGiones==0){
                if(LONGITUD!=29) 
                    return false;
            } else if (contEspacios==0 && contGiones>0) {
                if(LONGITUD!=29) 
                    return false;
            }
        }
        return true;
    }

    /**
     * Comprobamos el telefono
     * @param tlfn
     * @return true si está bien, false si está mal
     */
    public static boolean comprobarTelefono(String tlfn) {
        final int LONGITUD = tlfn.length();
        if ( tlfn.charAt(0)=='+' && Character.getNumericValue(tlfn.charAt(1))==3 && Character.getNumericValue(tlfn.charAt(2))==4) {
            if ( LONGITUD != 12 )
                return false;
            if ( Character.getNumericValue(tlfn.charAt(3))!=6 && Character.getNumericValue(tlfn.charAt(3))!=7 && Character.getNumericValue(tlfn.charAt(3))!=9 ) 
                return false;
            return true;
        } else if (Character.getNumericValue(tlfn.charAt(0))==6 || Character.getNumericValue(tlfn.charAt(0))==7 || Character.getNumericValue(tlfn.charAt(0))==9) {
            if (LONGITUD != 9) 
                return false;
        } else 
            return false;
        return true;
    }

    public static boolean comprobarFechas(String fecha) {
        final int LONGITUD = fecha.length();

        if (LONGITUD != 10) 
            return false;
        
        for (int i=0; i<LONGITUD;i++) {
            if (i==2 || i==5) {
                if (fecha.charAt(i)!='/' && fecha.charAt(i)!='-') 
                    return false;            
            } else if (i!=2 && i!=5) {
                if (Character.getNumericValue(fecha.charAt(i)) != 0 && Character.getNumericValue(fecha.charAt(i)) != 1 && Character.getNumericValue(fecha.charAt(i)) != 2 && Character.getNumericValue(fecha.charAt(i)) != 3 && Character.getNumericValue(fecha.charAt(i)) != 4 &&  
                    Character.getNumericValue(fecha.charAt(i)) != 5 && Character.getNumericValue(fecha.charAt(i)) != 6 && Character.getNumericValue(fecha.charAt(i)) != 7 && Character.getNumericValue(fecha.charAt(i)) != 8 && Character.getNumericValue(fecha.charAt(i)) != 9 )
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String dni="26518076L";
        String pasaporte="ABC123456";
        String iban="ES91 21 0004 1845 02 00051332";
        String tlfn="622481916";
        String fecha="02-07-2001";

        System.out.println("DNI: "+Helper.comprobarDNI(dni));
        System.out.println("Pasaporte: "+Helper.comprobarPasaporte(pasaporte));
        System.out.println("IBAN: "+Helper.comprobarIBAN(iban));
        System.out.println("Telefono: "+Helper.comprobarTelefono(tlfn));
        System.out.println("Fecha: "+Helper.comprobarFechas(fecha));
    }
}
