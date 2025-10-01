package co.edu.udec.planta_reciclaje.domain.model;

import co.edu.udec.planta_reciclaje.domain.enums.tipodeEtapa;
import co.edu.udec.planta_reciclaje.domain.valueobjects.tiempoEstimado;

public class EtapaProceso {
    private final tipodeEtapa tipo;
    private final tiempoEstimado tiempo;

    public EtapaProceso(tipodeEtapa tipo, tiempoEstimado tiempoEstimado) {
        if (tipo == null) throw new IllegalArgumentException("StageType requerido");
        if (tiempoEstimado == null) throw new IllegalArgumentException("TimeEstimate requerido");
        this.tipo = tipo;
        this.tiempo = tiempoEstimado;
    }

    public tipodeEtapa tipo() { return tipo; }
    public tiempoEstimado tiempoEstimado() { return tiempo; }

    @Override
    public String toString() {
        return tipo.name() + "(" + tiempo.horas() + "h)";
    }
}