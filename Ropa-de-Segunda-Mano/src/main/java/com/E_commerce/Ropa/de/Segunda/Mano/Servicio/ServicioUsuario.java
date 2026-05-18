package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.UsuarioDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloPerfil;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloUsuario;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.PerfilRepositorio;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j // Activamos los logs estructurados de SLF4J según tu guía
@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario usuarioRepository;

    @Autowired
    private PerfilRepositorio perfilRepository;

    // Si tu profesor ya les hizo configurar el PasswordEncoder, descomenta esta línea:
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    public ModeloUsuario registrarUsuario(UsuarioDTO dto) {
        // Registramos el evento de forma estructurada en los logs
        log.info("Iniciando registro para el correo electrónico: {}", dto.getEmail());

        // 1. Validamos que el perfil asociado exista en Oracle Cloud antes de amarrarlo
        ModeloPerfil perfil = perfilRepository.findById(dto.getPerfilId())
                .orElseThrow(() -> {
                    log.error("Error al registrar: No se encontró el Perfil con ID {}", dto.getPerfilId());
                    return new RuntimeException("El perfil asociado no existe");
                });

        // 2. Creamos la entidad
        ModeloUsuario usuario = new ModeloUsuario();
        usuario.setEmail(dto.getEmail());
        usuario.setRol(dto.getRol());
        usuario.setPerfil(perfil);

        // 3. Seguridad de contraseñas (Mencionado en el cambio de paradigma de tu guía)
        // Lo ideal es encriptarla antes de guardarla para que no quede en texto plano:
        // usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setPassword(dto.getPassword()); // Temporal si aún no activan el encoder

        log.info("Usuario con el rol [{}] creado exitosamente en el sistema", dto.getRol());
        return usuarioRepository.save(usuario);
    }
}