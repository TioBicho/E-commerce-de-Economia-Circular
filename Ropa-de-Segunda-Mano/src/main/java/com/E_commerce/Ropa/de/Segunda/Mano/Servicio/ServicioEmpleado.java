package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.EmpleadoDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloEmpleado;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioEmpleado; // Importación corregida al inglés
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class ServicioEmpleado {

    @Autowired
    private RepositorioEmpleado repositorio;

    public ModeloEmpleado contratar(EmpleadoDTO dto) {
        log.info("Registrando nuevo empleado: {} {}", dto.getNombre(), dto.getApellidoPaterno());

        ModeloEmpleado empleado = new ModeloEmpleado();

        empleado.setRun(dto.getRun());
        empleado.setDv(dto.getDv());
        empleado.setNombre(dto.getNombre());
        empleado.setApellidoPaterno(dto.getApellidoPaterno());
        empleado.setApellidoMaterno(dto.getApellidoMaterno());
        empleado.setFechaContrato(dto.getFechaContrato());
        empleado.setCargo(dto.getCargo());
        empleado.setUsuarioId(dto.getUsuarioId());
        empleado.setSucursalId(dto.getSucursalId());

        return repositorio.save(empleado);
    }

    public List<ModeloEmpleado> listarActivos() {
        log.info("Consultando lista de empleados");
        return repositorio.findAll();
    }

    public ModeloEmpleado obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }
}