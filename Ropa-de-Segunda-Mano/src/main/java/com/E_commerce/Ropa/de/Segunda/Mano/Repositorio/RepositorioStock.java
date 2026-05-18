package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloStock;
import com.E_commerce.Ropa.de.Segunda.Mano.ModeloStock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockRepository extends JpaRepository<ModeloStock, Long> {
    Optional<ModeloStock> findByPrendaId(Long prendaId);
}