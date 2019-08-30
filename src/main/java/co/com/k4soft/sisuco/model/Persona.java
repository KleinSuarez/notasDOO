package co.com.k4soft.sisuco.model;


import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="cedula")
    private String cedula;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
