package co.edu.udec.planta_reciclaje.domain.valueobjects;

public record idMaterial(String value) {
    public idMaterial {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Id no puede estar vacío.");
        }
    }
}