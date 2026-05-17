package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmpleadoDTO {

    @NotNull(message = "El RUN es obligatorio")
    private Integer run;

    @NotBlank(message = "El dígito verificador es obligatorio")
    @Size(max = 1, message = "El DV debe tener 1 carácter")
    private String dv;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 15, message = "El nombre no puede superar los 15 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 8, message = "El apellido paterno no puede superar los 8 caracteres")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 8, message = "El apellido materno no puede superar los 8 caracteres")
    private String apellidoMaterno;

    @NotNull(message = "La fecha de contrato es obligatoria")
    private LocalDate fechaContrato;

    @NotBlank(message = "El cargo es obligatorio")
    @Size(max = 15, message = "El cargo no puede superar los 15 caracteres")
    private String cargo;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El ID de la sucursal es obligatorio")
    private Long sucursalId;
}