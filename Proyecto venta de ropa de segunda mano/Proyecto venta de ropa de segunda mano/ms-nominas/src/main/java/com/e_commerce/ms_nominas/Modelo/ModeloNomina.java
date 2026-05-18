package com.e_commerce.ms_nominas.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Nomina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloNomina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nomina_seq_gen")
    @SequenceGenerator(name = "nomina_seq_gen", sequenceName = "NOMINA_SEQ", allocationSize = 1)
    @Column(name = "id_nomina")
    private Long id;

    @Column(name = "sueldo_base", nullable = false)
    private Double sueldoBase;

    @Column(name = "bonos", nullable = false)
    private Double bonos;

    @Column(name = "descuentos", nullable = false)
    private Double descuentos;

    @Column(name = "sueldo_liquido", nullable = false)
    private Double sueldoLiquido;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    // Relación lógica por ID hacia el microservicio ms-empleados
    @Column(name = "empleado_id", nullable = false)
    private Long empleadoId;
}