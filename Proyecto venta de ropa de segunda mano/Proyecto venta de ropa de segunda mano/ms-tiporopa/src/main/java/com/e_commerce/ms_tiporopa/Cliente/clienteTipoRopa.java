package com.e_commerce.ms_tiporopa.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-categorias", url = "http://localhost:8081")
public interface clienteTipoRopa {

    @GetMapping("/api/categorias/{id}")
    String verificarCategoriaExiste(@PathVariable("id") Long id);
}