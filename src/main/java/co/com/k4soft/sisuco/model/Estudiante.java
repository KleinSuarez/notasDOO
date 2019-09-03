package co.com.k4soft.sisuco.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue
    @Column(name="idestudiante")
    private Long idEstudiante;
    @ManyToOne
    @JoinColumn(name ="idprograma")
    private Programa programa;
    @ManyToOne
    @JoinColumn(name ="idpersona")
    private Persona persona;


    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
