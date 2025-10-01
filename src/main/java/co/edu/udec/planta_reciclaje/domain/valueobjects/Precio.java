package co.edu.udec.planta_reciclaje.domain.valueobjects;

import java.math.BigDecimal;

public record Precio(BigDecimal monto, String moneda) {
    public Precio {
        if (monto == null) throw new IllegalArgumentException("Cantidad no puede ser nula");
        if (monto.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cantidad no puede ser negativa");
        if (moneda == null || moneda.isBlank()) throw new IllegalArgumentException("Moneda requerida");
    }
}
