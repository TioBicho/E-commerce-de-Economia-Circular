package com.E_commerce.Ropa.de.Segunda.Mano.DTO;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PerfilDTO {
    @NotBlack(message= "El nombre de usuario es obligatorio")
    private String nombre;

    @Size(max = 255, message= "la biografia es muy larga")
    private String bio;

    @Pattern(regexp="ADMIN|VENDEDOR|COMPRADOR", message= "Rol no valido" )
    private String rol;

}
