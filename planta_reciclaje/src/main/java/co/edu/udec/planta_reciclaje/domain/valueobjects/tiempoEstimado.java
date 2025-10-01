package co.edu.udec.planta_reciclaje.domain.valueobjects;

public record tiempoEstimado(int horas) {
    public tiempoEstimado {
        if (horas <= 0) throw new IllegalArgumentException("Horas debe ser mayor que cero.");
    }
}
