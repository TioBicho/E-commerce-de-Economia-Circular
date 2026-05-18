package com.e_commerce.ms_usuarios.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-perfiles", url = "http://localhost:8093")
public interface PerfilCliente {
    @GetMapping("/api/perfiles/{id}")
    Object obtenerPerfilPorId(@PathVariable("id") Long id);
}