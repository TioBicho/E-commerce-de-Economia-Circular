package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor // OBLIGATORIO para Hibernate
@AllArgsConstructor
@Entity
@Table(name = "Envio") // Calza exacto con tu DDL
public class ModeloEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Long id;

    @Column(name = "direccion_destino", nullable = false, length = 150)
    private String direccionDestino;

    @Column(name = "transportista", nullable = false, length = 50)
    private String transportista;

    @Column(name = "numero_seguimiento", nullable = false, length = 50)
    private String numeroSeguimiento;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @OneToOne
    @JoinColumn(name = "Ventas_id_venta", nullable = false, unique = true)
    private ModeloVenta venta;
}
