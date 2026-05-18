package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Detalle_venta")
public class ModeloDetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Long id;

    @Column(name = "precio_original", nullable = false)
    private Integer precioOriginal;

    @Column(name = "descuento_aplicado", nullable = false)
    private Integer descuentoAplicado;

    @Column(name = "Ropa_id_ropa", nullable = false, length = 8)
    private String ropaId;
}