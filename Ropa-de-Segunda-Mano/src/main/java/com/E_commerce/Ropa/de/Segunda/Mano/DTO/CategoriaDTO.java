package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoriaDTO {

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(max = 50, message = "El nombre de la categoría no puede superar los 50 caracteres") // VARCHAR2(50) en tu DDL
    private String nombre;
}