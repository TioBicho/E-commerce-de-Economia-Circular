package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegionDTO {

    @NotBlank(message = "El nombre de la región no puede estar vacío")
    @Size(max = 20, message = "El nombre de la región no puede superar los 20 caracteres") // Ajustado a VARCHAR2(20) de tu DDL
    private String nombre;
}