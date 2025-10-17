import java.time.LocalDateTime;

public record Libro(String titulo,String autor,String editorial,int anoPublicacion,int numPaginas, String codISBN) {
    public boolean esClasico() {
        LocalDateTime hoy = LocalDateTime.now(); 
        boolean comprobacion=false;
        if (hoy.getYear()>(anoPublicacion+50)){
            comprobacion=true;
        }
        return comprobacion;
    }
    public String datosBasicos() {
        String datos="Titulo: "+titulo+", Autor: "+autor+", ISBN: "+codISBN;
        return datos;
    }
}
