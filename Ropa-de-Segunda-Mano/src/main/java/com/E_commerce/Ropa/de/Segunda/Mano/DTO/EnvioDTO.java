package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnvioDTO {

    @NotNull(message = "El ID de la venta es obligatorio")
    private Long ventaId;

    @NotBlank(message = "La dirección de destino no puede estar vacía")
    @Size(max = 150, message = "La dirección de destino no puede superar los 150 caracteres")
    private String direccionDestino;

    @NotBlank(message = "Debe especificar la empresa de transporte (ej: Starken, BlueExpress)")
    @Size(max = 50, message = "El nombre del transportista no puede superar los 50 caracteres")
    private String transportista;
}