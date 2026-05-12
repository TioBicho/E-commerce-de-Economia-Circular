package com.E_commerce.Ropa.de.Segunda.Mano.Controlador;

import com.tienda.profiles.dto.ProfileDTO;
import com.tienda.profiles.model.Profile;
import com.tienda.profiles.repository.ProfileRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfiles")
public class perfilControlador {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/crear")
    public Profile crearPerfil(@Valid @RequestBody ProfileDTO dto) {
        Profile perfil = new Profile();
        perfil.setUsername(dto.getUsername());
        perfil.setBio(dto.getBio());
        perfil.setRol(dto.getRol());
        return profileRepository.save(perfil);
    }

    @GetMapping("/{username}")
    public Profile obtenerPerfil(@PathVariable String username) {
        return profileRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
    }
}