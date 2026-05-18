package com.e_commerce.ms_categorias.Controlador;

import com.e_commerce.ms_categorias.DTO.categoriaDTO;
import com.e_commerce.ms_categorias.Modelo.ModeloCategoria;
import com.e_commerce.ms_categorias.Servicio.ServicioCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class ControladorCategoria {

    @Autowired
    private ServicioCategoria servicioCategoria;

    // URL final: POST http://localhost:8081/api/categorias/crear
    @PostMapping("/crear")
    public ResponseEntity<ModeloCategoria> crearCategoria(@Valid @RequestBody categoriaDTO dto) {
        ModeloCategoria nuevaCategoria = servicioCategoria.crearCategoria(dto);
        return ResponseEntity.ok(nuevaCategoria);
    }

    // URL final: GET http://localhost:8081/api/categorias/todas
    @GetMapping("/todas")
    public ResponseEntity<List<ModeloCategoria>> obtenerTodas() {
        return ResponseEntity.ok(servicioCategoria.obtenerTodas());
    }
}