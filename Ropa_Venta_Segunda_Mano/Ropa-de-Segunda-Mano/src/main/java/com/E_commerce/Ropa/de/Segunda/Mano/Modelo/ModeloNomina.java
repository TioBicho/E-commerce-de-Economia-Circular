package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Nomina")
public class ModeloNomina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nomina")
    private Long id;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "sueldo_base", nullable = false)
    private Long sueldoBase;

    @Column(name = "bonos", nullable = false)
    private Long bonos;

    @Column(name = "descuentos_legales", nullable = false)
    private Long descuentosLegales;

    @Column(name = "sueldo_liquido", nullable = false)
    private Long sueldoLiquido;

    //Llave foranea de empleado
    @Column(name = "Empleado_id_empleado", nullable = false)
    private Long empleadoId;
}