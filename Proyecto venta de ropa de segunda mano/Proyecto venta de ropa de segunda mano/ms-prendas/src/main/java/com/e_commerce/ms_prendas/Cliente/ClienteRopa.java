package com.e_commerce.ms_prendas.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-tiporopa", url = "http://localhost:8090")
public interface ClienteRopa {

    @GetMapping("/api/tiporopa/{id}")
    String verificarTipoRopaExiste(@PathVariable("id") Long id);
}