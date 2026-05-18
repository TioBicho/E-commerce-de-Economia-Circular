package com.e_commerce.ms_ventas.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-empleados", url = "http://localhost:8083")
public interface EmpleadoVentaCliente {

    @GetMapping("/api/empleados/{id}")
    String verificarEmpleadoExiste(@PathVariable("id") Long id);
}