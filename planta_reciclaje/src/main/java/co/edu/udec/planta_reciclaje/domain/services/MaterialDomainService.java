package co.edu.udec.planta_reciclaje.domain.services;

import co.edu.udec.planta_reciclaje.domain.model.EtapaProceso;
import co.edu.udec.planta_reciclaje.domain.model.Material;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MaterialDomainService {
    public int totalProcessingHours(Material material) {
        List<EtapaProceso> etapa = material.etapas();
        return etapa.stream().mapToInt(s -> s.tiempoEstimado().horas()).sum();
    }

    // Genera una descripción corta de las etapas
    public String describeStages(Material material) {
        return material.etapas().stream()
            .map(EtapaProceso::toString)
            .collect(Collectors.joining(" -> "));
    }

    // Calcula ingreso estimado por una cantidad
    public String estimatedRevenue(Material material, BigDecimal quantity) {
        var cost = material.calcularCostoporCantidad(quantity);
        return cost + " COP"; // Replace "COP" with your desired currency code or symbol
    }
}
