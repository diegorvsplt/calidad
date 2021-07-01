package com.calidad.nominasoft;

import com.calidad.nominasoft.Dominio.Entidades.PeriodoDePago;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class PeriodoDePagoTest {

    @Test
    public void Test_esFechaActualMayor() {
        PeriodoDePago periodo = new PeriodoDePago();
        LocalDate fechaFin = LocalDate.of(2021, 7, 15);
        periodo.setFechaFin(fechaFin);
        boolean fechaActualMayor_esperado = true;
        boolean fechaActualMayor_obtenido = periodo.esFechaActualMayor();
        Assert.assertEquals(fechaActualMayor_esperado, fechaActualMayor_obtenido);
    }

    @Test
    public void Test_calcularTotalSemanas() {
        PeriodoDePago periodo = new PeriodoDePago();
        LocalDate fechaInicio = LocalDate.of(2021, 04, 15);
        LocalDate fechaFin = LocalDate.of(2021, 05, 15);
        periodo.setFechaInicio(fechaInicio);
        periodo.setFechaFin(fechaFin);
        int totalSemanas_esperado = 4;
        int totalSemanas_obtenido = periodo.getSemanasDelPeriodo();
        Assert.assertEquals(totalSemanas_esperado, totalSemanas_obtenido);
    }

}
