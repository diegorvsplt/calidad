package com.calidad.nominasoft;

import java.time.LocalDate;

import com.calidad.nominasoft.Dominio.Entidades.Contrato;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
class ContratoTest {

    @Test
    public void Test1_estaVigente() {
        Contrato contrato = new Contrato();
        LocalDate fechaFin = LocalDate.of(2022, 6, 6);
        contrato.setFechaFin(fechaFin);
        contrato.setAnulado(false);
        boolean estaVigente_esperado = true;
        boolean estaVigente_obtenido = contrato.estaVigente();
        Assert.assertEquals(estaVigente_esperado, estaVigente_obtenido);
    }

    @Test
    public void Test1_esValidaFechaFin() {
        Contrato contrato = new Contrato();
        LocalDate fechaInicio = LocalDate.of(2021, 5, 6);
        LocalDate fechaFin = LocalDate.of(2021, 7, 6);
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);
        boolean esValidoFechaFin_esperado = false;
        boolean esValidoFechaFin_obtenido = contrato.esValidaFechaFin();
        Assert.assertEquals(esValidoFechaFin_esperado, esValidoFechaFin_obtenido);
    }

    @Test
    public void Test2_esValidaFechaFin() {
        Contrato contrato = new Contrato();
        LocalDate fechaInicio = LocalDate.of(2021, 5, 6);
        LocalDate fechaFin = LocalDate.of(2021, 11, 6);
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);
        boolean esValidoFechaFin_esperado = true;
        boolean esValidoFechaFin_obtenido = contrato.esValidaFechaFin();
        Assert.assertEquals(esValidoFechaFin_esperado, esValidoFechaFin_obtenido);
    }

    @Test
    public void Test3_esValidaFechaFin() {
        Contrato contrato = new Contrato();
        LocalDate fechaInicio = LocalDate.of(2021, 5, 6);
        LocalDate fechaFin = LocalDate.of(2022, 6, 6);
        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);
        boolean esValidoFechaFin_esperado = false;
        boolean esValidoFechaFin_obtenido = contrato.esValidaFechaFin();
        Assert.assertEquals(esValidoFechaFin_esperado, esValidoFechaFin_obtenido);
    }

    @Test
    public void Test1_esValidaFechaInicio() {
        Contrato contratoAnterior = new Contrato();
        LocalDate fechaFinContrato1 = LocalDate.of(2021, 5, 6);

        contratoAnterior.setFechaFin(fechaFinContrato1);

        Contrato nuevoContrato = new Contrato();
        LocalDate fechaInicioContrato2 = LocalDate.of(2021, 5, 7);

        nuevoContrato.setFechaInicio(fechaInicioContrato2);

        boolean esValidoFechaInicio_esperado = true;
        boolean esValidoFechaInicio_obtenido = nuevoContrato.esValidaFechaInicio(contratoAnterior);
        Assert.assertEquals(esValidoFechaInicio_esperado, esValidoFechaInicio_obtenido);
    }

    @Test
    public void Test1_esValidoHorasContratadas() {
        Contrato contrato = new Contrato();
        contrato.setHorasContratadasPorSemana(40);
        boolean esValidoHorasContratadas_esperado = true;
        boolean esValidoHorasContratadas_obtenido = contrato.esValidoHorasContratadas();
        Assert.assertEquals(esValidoHorasContratadas_esperado, esValidoHorasContratadas_obtenido);
    }

    @Test
    public void Test1_esValidoValorHora() {
        Contrato contrato = new Contrato();
        contrato.setValorHora(50);
        boolean esValidoValorHora_esperado = true;
        boolean esValidoValorHora_obtenido = contrato.esValidoValorHora();
        Assert.assertEquals(esValidoValorHora_esperado, esValidoValorHora_obtenido);
    }

    @Test
    public void Test1_calcularMontoAsignacionFamiliar() {
        Contrato contrato = new Contrato();
        contrato.setValorHora(50);
        contrato.setHorasContratadasPorSemana(8);
        contrato.setAsignacionFamiliar(true);
        float montoAsignacionFamiliar_esperado = 40;
        float montoAsignacionFamiliar_obtenido = contrato.calcularMontoAsignacionFamiliar();
        Assert.assertEquals(montoAsignacionFamiliar_esperado, montoAsignacionFamiliar_obtenido, 0);
    }

    @Test
    public void Test2_calcularMontoAsignacionFamiliar() {
        Contrato contrato = new Contrato();
        contrato.setValorHora(50);
        contrato.setHorasContratadasPorSemana(8);
        contrato.setAsignacionFamiliar(false);
        float montoAsignacionFamiliar_esperado = 0;
        float montoAsignacionFamiliar_obtenido = contrato.calcularMontoAsignacionFamiliar();
        Assert.assertEquals(montoAsignacionFamiliar_esperado, montoAsignacionFamiliar_obtenido, 0);
    }

}
