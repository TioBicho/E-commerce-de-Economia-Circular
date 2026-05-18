package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Stock") // Nombre exacto en tu DDL
public class ModeloStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "estado_inventario", nullable = false, length = 50)
    private String estadoInventario;

    @Column(name = "Ropa_id_ropa", nullable = false, length = 8)
    private String ropaId;

    //llave foranea sucursal
    @Column(name = "Sucursal_id_sucursal", nullable = false)
    private Long sucursalId;
}