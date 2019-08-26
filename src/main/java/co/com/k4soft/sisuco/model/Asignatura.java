package co.com.k4soft.sisuco.model;

import co.com.k4soft.sisuco.model.businessexception.RepruebaNotaException;
import co.com.k4soft.sisuco.model.parametro.TipoNotasEnum;

import java.util.List;

public class Asignatura {

    private String nombre;
    private List<Nota> notas;
    private double notaMinimaPermitida;


    public Asignatura(String nombre){
        this.nombre = nombre;
    }

    public void setNotaMinimaPermitida(double notaMinimaPermitida) {
        this.notaMinimaPermitida = notaMinimaPermitida;
    }

    public void setNotas(List<Nota> notas){
        this.notas = notas;
    }


    public double getTotalSeguimiento(){
        double totalSeguimiento = 0;
        for(Nota nota : notas){
           if(nota.getTipoNota().getId() == TipoNotasEnum.SEGUIMIENTO.getId()){
               totalSeguimiento = nota.getNota() * (TipoNotasEnum.SEGUIMIENTO.getPorcentaje()/100);
           }
        }
        return  totalSeguimiento;
    }

    public double getParcial(){
        double totalParcial = 0;
        for(Nota nota : notas){
            if(nota.getTipoNota().getId() == TipoNotasEnum.PARCIAL.getId()){
                totalParcial = nota.getNota() * (TipoNotasEnum.PARCIAL.getPorcentaje()/100);
            }
        }
        return  totalParcial;
    }


    public double getFinal(){
        double totalFinal = 0;
        for(Nota nota : notas){
            if(nota.getTipoNota().getId() == TipoNotasEnum.FINAL.getId()){
                totalFinal = nota.getNota() * (TipoNotasEnum.FINAL.getPorcentaje()/100);
            }
        }
        return  totalFinal;
    }

    public double getDefinitiva() throws RepruebaNotaException {

        double definitiva = getParcial() +getFinal()+getTotalSeguimiento();

        if(definitiva < notaMinimaPermitida){
            throw new RepruebaNotaException(Mensaje.Asignatura.REPRUEBA_NOTA);
        }

        return definitiva;
    }



}
