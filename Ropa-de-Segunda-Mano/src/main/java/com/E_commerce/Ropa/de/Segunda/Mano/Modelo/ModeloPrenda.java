package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ropa")
public class ModeloPrenda {
    @Id
    @Column(name = "id_ropa", length = 8)
    private String id;

    @Column(nullable = false, length = 80)
    private String cuidados;

    @Column(nullable = false, length = 80)
    private String descripcion;

    @Column(name = "Tipo_ropa_id_ropa", nullable = false)
    private Long tipoRopaId;

}