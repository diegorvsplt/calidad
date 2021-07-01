package com.calidad.nominasoft;

import com.calidad.nominasoft.Dominio.Entidades.OtrosConceptos;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class OtrosConceptosTest {

    @Test
    public void Test_calcularTotalConceptosIngresos() {
        OtrosConceptos conceptos = new OtrosConceptos();
        conceptos.setMontoHorasExtra(40);
        conceptos.setMontoOtrosIngresos(80);
        conceptos.setMontoReintegro(50);
        float totalConceptosDeIngresos_esperado = 170;
        float totalConceptosDeIngresos_obtenido = conceptos.calcularTotalConceptosIngresos();
        Assert.assertEquals(totalConceptosDeIngresos_esperado, totalConceptosDeIngresos_obtenido, 0);
    }

    @Test
    public void Test_calcularTotalConceptosDescuentos() {
        OtrosConceptos conceptos = new OtrosConceptos();
        conceptos.setMontoAdelantos(200);
        conceptos.setMontoOtrosDescuentos(120);
        conceptos.setMontoHorasAusente(80);
        float totalConceptosDeDescuentos_esperado = 400;
        float totalConceptosDeDescuentos_obtenido = conceptos.calcularTotalConceptosDescuentos();
        Assert.assertEquals(totalConceptosDeDescuentos_esperado, totalConceptosDeDescuentos_obtenido, 0);
    }
}
