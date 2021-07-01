package com.calidad.nominasoft;

import com.calidad.nominasoft.Dominio.Entidades.Contrato;
import com.calidad.nominasoft.Dominio.Entidades.OtrosConceptos;
import com.calidad.nominasoft.Dominio.Entidades.Pago;
import com.calidad.nominasoft.Dominio.Entidades.PeriodoDePago;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class PagoTest {

    @Test
    public void Test1_calcularSueldoBasico() {
        Pago pago = new Pago();
        pago.setTotalDeHoras(80);
        pago.setValorHora(40);
        int sueldoBasico_esperado = 3200;
        int sueldooBasico_obtenido = pago.calcularSueldoBasico();
        Assert.assertEquals(sueldoBasico_esperado, sueldooBasico_obtenido);
    }

    @Test
    public void Test1_calcularDescuentoAfp() {
        Pago pago = new Pago();
        pago.setTotalDeHoras(80);
        pago.setValorHora(40);
        pago.setPorcentajeDescuentoAFP(10);
        float descuentoAfp_esperado = 320f;
        float descuentoAfp_obtenido = pago.calcularDescuentoAFP();
        Assert.assertEquals(descuentoAfp_esperado, descuentoAfp_obtenido, 0);
    }

    @Test
    public void Test1_calcularTotalIngresos() {
        OtrosConceptos conceptos = new OtrosConceptos(0, 0, 50, 0, 30, 80);
        Contrato contrato = new Contrato();
        Pago pago = new Pago();
        contrato.setValorHora(20);
        contrato.setHorasContratadasPorSemana(40);
        contrato.setAsignacionFamiliar(false);
        pago.setOtrosConceptos(conceptos);
        contrato.setAsignacionFamiliar(true);
        pago.setTotalDeHoras(80);
        pago.setValorHora(40);
        pago.setContrato(contrato);

        float totalDeIngresos_esperado = 3440f;
        float totalDeIngresos_obtenido = pago.calcularTotalIngresos();
        Assert.assertEquals(totalDeIngresos_esperado, totalDeIngresos_obtenido, 0);
    }

    @Test
    public void Test1_calcularTotalDescuentos() {
        OtrosConceptos conceptos = new OtrosConceptos(30, 80, 0, 10, 0, 0);
        Contrato contrato = new Contrato();
        PeriodoDePago periodo = new PeriodoDePago();

        Pago pago = new Pago();
        pago.setTotalDeHoras(80);
        pago.setValorHora(40);
        pago.setPorcentajeDescuentoAFP(10);
        pago.setContrato(contrato);
        pago.setPeriodoDePago(periodo);
        pago.setOtrosConceptos(conceptos);
        float totalDeIngresos_esperado = 440f;
        float totalDeIngresos_obtenido = pago.calcularTotalDescuentos();
        Assert.assertEquals(totalDeIngresos_esperado, totalDeIngresos_obtenido, 0);
    }

    @Test
    public void Test1_calcularSueldoNeto() {
        OtrosConceptos conceptos = new OtrosConceptos(30, 80, 50, 10, 30, 80);
        Contrato contrato = new Contrato();
        contrato.setAsignacionFamiliar(true);
        PeriodoDePago periodo = new PeriodoDePago();
        Pago pago = new Pago();
        pago.setTotalDeHoras(80);
        pago.setValorHora(40);
        pago.setPorcentajeDescuentoAFP(5);
        pago.setContrato(contrato);
        pago.setPeriodoDePago(periodo);
        pago.setOtrosConceptos(conceptos);

        float sueldoNeto_esperado = 3080f;
        float sueldoNeto_obtenido = pago.calcularSueldoNeto();
        Assert.assertEquals(sueldoNeto_esperado, sueldoNeto_obtenido, 0);
    }

    @Test
    public void Test1_calcularTotalDeHoras() {
        LocalDate fechaInicio = LocalDate.of(2021, 1, 2);
        LocalDate fechaFin = LocalDate.of(2021, 2, 2);
        PeriodoDePago periodo = new PeriodoDePago();
        periodo.setFechaInicio(fechaInicio);
        periodo.setFechaFin(fechaFin);
        Contrato contrato = new Contrato();
        contrato.setHorasContratadasPorSemana(40);
        Pago pago = new Pago();
        pago.setPeriodoDePago(periodo);
        pago.setContrato(contrato);
        int totalHoras_esperado = 160;
        int totalHoras_obtenido = pago.calcularTotalDeHoras();
        Assert.assertEquals(totalHoras_esperado, totalHoras_obtenido);
    }
}
