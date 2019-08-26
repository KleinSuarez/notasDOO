package co.com.k4soft.sisuco.model;

import co.com.k4soft.sisuco.model.businessexception.RepruebaNotaException;
import co.com.k4soft.sisuco.model.parametro.TipoNotasEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AsignaturaTest {

    private Asignatura asignatura;
    private double notaSeguimiento = 3.5;
    private double notaParcial = 2.8;
    private double notaFinal = 4.2;
    private double notaMinimaPermitida = 3;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp(){
        asignatura = new Asignatura("Ingeniería de Software 3");
    }


    @Test
    public void getTotalSeguimiento() {
        double notaEsperada = 1.5;
        TipoNota tipoNota = new TipoNota(TipoNotasEnum.SEGUIMIENTO.getId(),TipoNotasEnum.SEGUIMIENTO.getNombre(),TipoNotasEnum.SEGUIMIENTO.getPorcentaje());
        List<Nota> notas = new ArrayList<>();
        notas.add(new Nota(tipoNota,notaSeguimiento));
        asignatura.setNotas(notas);
        double notaSeguientoSalida = asignatura.getTotalSeguimiento();
        Assert.assertEquals(notaEsperada,notaSeguientoSalida,0.5);
    }

    @Test
    public void getParcial() {
        double notaEsperada = 0.8;
        TipoNota tipoNota = new TipoNota(TipoNotasEnum.PARCIAL.getId(),TipoNotasEnum.PARCIAL.getNombre(),TipoNotasEnum.PARCIAL.getPorcentaje());
        List<Nota> notas = new ArrayList<>();
        notas.add(new Nota(tipoNota,notaParcial));
        asignatura.setNotas(notas);
        double notaSeguientoSalida = asignatura.getParcial();
        Assert.assertEquals(notaEsperada,notaSeguientoSalida,0.5);
    }

    @Test
    public void getFinal() {
        double notaEsperada = 1.2;
        TipoNota tipoNota = new TipoNota(TipoNotasEnum.FINAL.getId(),TipoNotasEnum.FINAL.getNombre(),TipoNotasEnum.FINAL.getPorcentaje());
        List<Nota> notas = new ArrayList<>();
        notas.add(new Nota(tipoNota,notaFinal));
        asignatura.setNotas(notas);
        double notaSeguientoSalida = asignatura.getFinal();
        Assert.assertEquals(notaEsperada,notaSeguientoSalida,0.5);
    }

    @Test
    public void getDefinitiva() throws RepruebaNotaException {
        double notaEsperada = 3.5;
        TipoNota tipoNota = new TipoNota(TipoNotasEnum.FINAL.getId(),TipoNotasEnum.FINAL.getNombre(),TipoNotasEnum.FINAL.getPorcentaje());
        List<Nota> notas = new ArrayList<>();
        notas.add(new Nota(tipoNota,notaFinal));
        tipoNota = new TipoNota(TipoNotasEnum.PARCIAL.getId(),TipoNotasEnum.PARCIAL.getNombre(),TipoNotasEnum.PARCIAL.getPorcentaje());
        notas.add(new Nota(tipoNota,notaParcial));
        tipoNota = new TipoNota(TipoNotasEnum.SEGUIMIENTO.getId(),TipoNotasEnum.SEGUIMIENTO.getNombre(),TipoNotasEnum.SEGUIMIENTO.getPorcentaje());
        notas.add(new Nota(tipoNota,notaSeguimiento));
        asignatura.setNotaMinimaPermitida(notaMinimaPermitida);
        asignatura.setNotas(notas);
        double notaSalida = asignatura.getDefinitiva();
        Assert.assertEquals(notaEsperada,notaSalida,0.5);
    }

    @Test
    public void getDefinitivaReprobada() throws RepruebaNotaException {

        exception.expect(RepruebaNotaException.class);
        exception.expectMessage(Mensaje.Asignatura.REPRUEBA_NOTA);
        notaSeguimiento = 1.5;
        notaParcial = 1.8;
        notaFinal = 1.2;
        TipoNota tipoNota = new TipoNota(TipoNotasEnum.FINAL.getId(),TipoNotasEnum.FINAL.getNombre(),TipoNotasEnum.FINAL.getPorcentaje());
        List<Nota> notas = new ArrayList<>();
        notas.add(new Nota(tipoNota,notaFinal));
        tipoNota = new TipoNota(TipoNotasEnum.PARCIAL.getId(),TipoNotasEnum.PARCIAL.getNombre(),TipoNotasEnum.PARCIAL.getPorcentaje());
        notas.add(new Nota(tipoNota,notaParcial));
        tipoNota = new TipoNota(TipoNotasEnum.SEGUIMIENTO.getId(),TipoNotasEnum.SEGUIMIENTO.getNombre(),TipoNotasEnum.SEGUIMIENTO.getPorcentaje());
        notas.add(new Nota(tipoNota,notaSeguimiento));
        asignatura.setNotaMinimaPermitida(notaMinimaPermitida);
        asignatura.setNotas(notas);
        double notaSalida = asignatura.getDefinitiva();
    }

}