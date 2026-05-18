package com.e_commerce.ms_ventas.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuarios", url = "http://localhost:8091")
public interface ventasCliente {
    @GetMapping("/api/usuarios/{id}")
    String verificarUsuarioExiste(@PathVariable("id") Long id);
}