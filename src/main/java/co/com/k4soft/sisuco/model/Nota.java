package co.com.k4soft.sisuco.model;

public class Nota {

    private TipoNota tipoNota;
    private double nota;

    public Nota(TipoNota tipoNota, double nota) {
        this.tipoNota = tipoNota;
        this.nota = nota;
    }

    public double getNota() {
       return nota;
    }

    public TipoNota getTipoNota(){
        return tipoNota;
    }
}
