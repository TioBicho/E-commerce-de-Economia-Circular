package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalDate;

@Data
public class NominaDTO {

    @NotNull(message = "La fecha de emisión es obligatoria")
    private LocalDate fechaEmision;

    @NotNull(message = "El sueldo base es obligatorio")
    @Positive(message = "El sueldo base debe ser un monto positivo")
    private Long sueldoBase;

    @NotNull(message = "Los bonos son obligatorios")
    @Min(value = 0, message = "Los bonos no pueden ser negativos")
    private Long bonos;

    @NotNull(message = "Los descuentos legales son obligatorios")
    @Min(value = 0, message = "Los descuentos legales no pueden ser negativos")
    private Long descuentosLegales;

    @NotNull(message = "El sueldo líquido es obligatorio")
    @Positive(message = "El sueldo líquido debe ser un monto positivo")
    private Long sueldoLiquido;

    @NotNull(message = "El ID del empleado es obligatorio")
    private Long empleadoId;
}