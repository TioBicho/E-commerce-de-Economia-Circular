package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PrendaDTO {

    @NotBlank(message = "El código identificador de la ropa es obligatorio")
    @Size(max = 8, message = "El código de la ropa no puede superar los 8 caracteres")
    private String id;

    @NotBlank(message = "Los cuidados de la prenda son obligatorios")
    @Size(max = 80, message = "Los cuidados no pueden superar los 80 caracteres")
    private String cuidados;

    @NotBlank(message = "La descripción de la prenda es obligatoria")
    @Size(max = 80, message = "La descripción no puede superar los 80 caracteres")
    private String descripcion;

    @NotNull(message = "El ID del tipo de ropa es obligatorio")
    private Long tipoRopaId;
}