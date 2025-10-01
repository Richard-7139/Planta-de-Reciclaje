package co.edu.udec.planta_reciclaje.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import co.edu.udec.planta_reciclaje.domain.factory.MaterialFactory;
import co.edu.udec.planta_reciclaje.domain.enums.clasificacionMaterial;
import co.edu.udec.planta_reciclaje.domain.enums.unidadMedida;

import java.math.BigDecimal;

class CostoMaterialTest {
    @Test
    void calcularCostoPorCantidad() {
        var m = MaterialFactory.crear("M-020", "Metal", clasificacionMaterial.Inorgánico, unidadMedida.Kilogramo, new BigDecimal("3.50"), "COP", 72);
        var cost = m.calcularCostoporCantidad (new BigDecimal("10"));
        assertThat(cost).isEqualByComparingTo(new BigDecimal("35.0"));
    }

    @Test
    void calcularCostoFallaConCantidadNegativa() {
        var m = MaterialFactory.crear("M-021", "Electronicos", clasificacionMaterial.Peligroso, unidadMedida.Unidad, new BigDecimal("20.0"), "COP", 120);
        assertThatThrownBy(() -> m.calcularCostoporCantidad (new BigDecimal("0"))).isInstanceOf(RuntimeException.class);
    }
}
