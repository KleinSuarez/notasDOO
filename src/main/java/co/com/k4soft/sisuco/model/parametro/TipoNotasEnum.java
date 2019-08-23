package co.com.k4soft.sisuco.model.parametro;

public enum TipoNotasEnum {

    PARCIAL(1,"parcial",30),
    FINAL(2,"final",30),
    SEGUIMIENTO(3,"parcial",40);

    private int id;
    private String nombre;
    private double porcentaje;



    TipoNotasEnum(int id, String nombre, double porcentaje){
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public int getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
