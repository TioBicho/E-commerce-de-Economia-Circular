package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PerfilDTO {

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Size(max = 12, message = "El teléfono no puede superar los 12 caracteres") // NVARCHAR2(12) en tu DDL
    private String telefono;
}