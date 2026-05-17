package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario")
public class ModeloUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(unique = true, nullable = false, length = 30)
    private String email;

    @Column(nullable = false, length = 14)
    private String password;

    @Column(nullable = false, length = 15)
    private String rol;
    @OneToOne
    @JoinColumn(name = "Perfil_id_perfil", nullable = false, unique = true)
    private ModeloPerfil perfil;
}