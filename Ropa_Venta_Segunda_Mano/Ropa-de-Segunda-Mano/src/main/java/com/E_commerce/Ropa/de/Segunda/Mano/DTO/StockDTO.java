package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StockDTO {

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 0, message = "La cantidad en stock no puede ser negativa")
    private Integer cantidad;

    @NotBlank(message = "El estado del inventario es obligatorio")
    @Size(max = 50, message = "El estado no puede superar los 50 caracteres")
    private String estadoInventario;

    @NotBlank(message = "El código de la ropa es obligatorio")
    @Size(max = 8, message = "El código de la ropa no puede superar los 8 caracteres")
    private String ropaId;

    @NotNull(message = "El ID de la sucursal es obligatorio")
    private Long sucursalId;
}