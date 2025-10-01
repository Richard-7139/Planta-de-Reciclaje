package co.edu.udec.planta_reciclaje.domain.factory;
import co.edu.udec.planta_reciclaje.domain.model.Material;
import co.edu.udec.planta_reciclaje.domain.valueobjects.Precio;
import co.edu.udec.planta_reciclaje.domain.valueobjects.idMaterial;
import co.edu.udec.planta_reciclaje.domain.valueobjects.tiempoEstimado; // <-- Add this import
import co.edu.udec.planta_reciclaje.domain.enums.*;

import java.math.BigDecimal;

public class MaterialFactory {
    public static Material crear(String id, String nombreMaterial, clasificacionMaterial clasificacion, unidadMedida unidadMedida, BigDecimal monto, String moneda, int horas) {
        // construcción controlada
        return new Material(new idMaterial(id), nombreMaterial, clasificacion, unidadMedida, new Precio(monto, moneda), new tiempoEstimado(horas));
    }
}