package com.e_commerce.ms_sucursal.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-regiones", url = "http://localhost:8087")
public interface sucursalCliente {

    @GetMapping("/api/regiones/{id}")
    String obtenerRegionPorId(@PathVariable("id") Long id);
}