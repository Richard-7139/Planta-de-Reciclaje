package co.edu.udec.planta_reciclaje.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import co.edu.udec.planta_reciclaje.domain.factory.MaterialFactory;
import co.edu.udec.planta_reciclaje.domain.enums.clasificacionMaterial;
import co.edu.udec.planta_reciclaje.domain.enums.unidadMedida;
import co.edu.udec.planta_reciclaje.domain.enums.tipodeEtapa;
import co.edu.udec.planta_reciclaje.domain.model.EtapaProceso;
import co.edu.udec.planta_reciclaje.domain.valueobjects.tiempoEstimado;

class EtapasdeProcesamiento {
    @Test
    void agregarYAvanzarEtapas() {
        var m = MaterialFactory.crear("M-010", "Carton", clasificacionMaterial.Inorgánico, unidadMedida.Kilogramo, new java.math.BigDecimal("0.80"), "COP", 24);
        m.agregarEtapa(new EtapaProceso(tipodeEtapa.Recepción, new tiempoEstimado(2)));
        m.agregarEtapa(new EtapaProceso(tipodeEtapa.Clasificación, new tiempoEstimado(4)));
        assertThat(m.etapas()).hasSize(2);
        assertThat(m.etapaActual()).isPresent();
        m.avanzarEtapa();
        assertThat(m.etapaActual().get().tipo()).isEqualTo(tipodeEtapa.Clasificación);
    }

    @Test
    void avanzarSinEtapasFalla() {
        var m = MaterialFactory.crear("M-011", "Vidrio", clasificacionMaterial.Inorgánico, unidadMedida.Kilogramo, new java.math.BigDecimal("0.50"), "COP", 24);
        assertThatThrownBy(() -> m.avanzarEtapa()).isInstanceOf(RuntimeException.class);
    }
}
