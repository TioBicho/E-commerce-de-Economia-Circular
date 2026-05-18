package com.e_commerce.ms_envios.Servicio;

import com.e_commerce.ms_envios.DTO.EnviosDTO;
import com.e_commerce.ms_envios.Modelo.ModeloEnvios;
import com.e_commerce.ms_envios.Repositorio.RepositorioEnvios;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class ServicioEnvios {

    @Autowired
    private RepositorioEnvios repository;

    public ModeloEnvios guardarEnvio(EnviosDTO dto) {
        log.info("Iniciando validación y registro de envío para la venta ID: {}", dto.getVentasIdVenta());


        if (repository.findByVentasIdVenta(dto.getVentasIdVenta()).isPresent()) {
            log.error("Validación fallida: La venta ID {} ya cuenta con un envío registrado.", dto.getVentasIdVenta());
            throw new RuntimeException("No se puede despachar: Esta venta ya tiene un envío asociado.");
        }

        ModeloEnvios entidad = new ModeloEnvios();
        entidad.setDireccionDestino(dto.getDireccionDestino());
        entidad.setTransportista(dto.getTransportista());
        entidad.setNumeroSeguimiento(dto.getNumeroSeguimiento());
        entidad.setEstado(dto.getEstado());


        entidad.setFechaCreacion(LocalDate.now());
        entidad.setVentasIdVenta(dto.getVentasIdVenta());

        log.info("Envío validado con éxito. Persistiendo ruta en la base de datos.");
        return repository.save(entidad);
    }

    public List<ModeloEnvios> obtenerTodos() {
        log.info("Consultando el listado completo de despachos.");
        return repository.findAll();
    }

    public ModeloEnvios obtenerPorId(Long id) {
        log.info("Buscando envío con ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El envío con ID " + id + " no existe en el registro."));
    }
    public ModeloEnvios actualizarEnvio(Long id, EnviosDTO dto) {
        log.info("Modificando estado de despacho ID: {}", id);
        ModeloEnvios envio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despacho no registrado."));

        // Validar índice único de la boleta de venta
        repository.findByVentasIdVenta(dto.getVentasIdVenta()).ifPresent(otro -> {
            if (!otro.getId().equals(id)) throw new RuntimeException("Esta venta ya posee otra ruta de envío activa.");
        });

        envio.setDireccionDestino(dto.getDireccionDestino());
        envio.setTransportista(dto.getTransportista());
        envio.setNumeroSeguimiento(dto.getNumeroSeguimiento());
        envio.setEstado(dto.getEstado());
        return repository.save(envio);
    }

    public void eliminarEnvio(Long id) {
        log.info("Anulando envío ID: {}", id);
        ModeloEnvios envio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El envío no existe."));
        repository.delete(envio);
    }

    public List<ModeloEnvios> listarPorEstado(String estado) {
        log.info("Filtrando despachos bajo el estado: {}", estado);
        return repository.buscarPorEstadoContiene(estado);
    }
}