package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ventas")
public class ModeloVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id;

    @Column(nullable = false, length = 30)
    private String boleta;

    @Column(nullable = false)
    private Integer carrito;


    @Column(name = "Cliente_rut", nullable = false)
    private Integer clienteRut;


    @Column(name = "Empleado_id_empleado", nullable = false)
    private Long empleadoId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ventas_id_venta")
    private List<ModeloDetalleVenta> detalles;
}