package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe proporcionar un formato de correo válido")
    @Size(max = 30, message = "El correo no puede superar los 30 caracteres")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(max = 14, message = "La contraseña no puede superar los 14 caracteres")
    private String password;

    @NotBlank(message = "El rol es obligatorio")
    @Size(max = 15, message = "El rol no puede superar los 15 caracteres")
    private String rol;

    @NotNull(message = "El ID del perfil asociado es obligatorio")
    private Long perfilId;
}