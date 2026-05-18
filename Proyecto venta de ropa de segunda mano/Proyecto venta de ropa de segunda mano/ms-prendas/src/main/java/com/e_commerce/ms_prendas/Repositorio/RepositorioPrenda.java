package com.e_commerce.ms_prendas.Repositorio;

import com.e_commerce.ms_prendas.Modelo.ModeloPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioPrenda extends JpaRepository<ModeloPrenda, String> {

}