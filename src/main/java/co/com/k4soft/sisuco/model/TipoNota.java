package co.com.k4soft.sisuco.model;

public class TipoNota {

    private int id;
    private String nombre;
    private double porcentaje;

    public TipoNota(int id, String nombre, double porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String  getNombre(){
        return nombre;
    }

    public double getPorcentaje(){
        return porcentaje;
    }

    public int getId() {
        return id;
    }
}
