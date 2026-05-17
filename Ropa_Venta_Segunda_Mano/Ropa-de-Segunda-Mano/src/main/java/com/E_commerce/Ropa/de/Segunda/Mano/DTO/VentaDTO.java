package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VentaDTO {

    @NotBlank(message = "El número de boleta es obligatorio")
    @Size(max = 30, message = "El número de boleta no puede superar los 30 caracteres")
    private String boleta;

    @NotNull(message = "El identificador del carrito es obligatorio")
    @Min(value = 1, message = "El número de carrito debe ser un valor positivo válido")
    private Integer carrito;

    @NotNull(message = "El RUT del cliente es obligatorio")
    private Integer clienteRut;

    @NotNull(message = "El ID del empleado es obligatorio")
    private Long empleadoId;
}