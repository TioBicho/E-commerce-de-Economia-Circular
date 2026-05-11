package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String bio;

    private double reputacion= 5.0;
    @Column(nullable = false)
    private String rol;


}
