package com.E_commerce.Ropa.de.Segunda.Mano.Config;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloCategoria;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloRegion;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioCategoria;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioRegion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component // Le avisa a Spring Boot que debe cargar esta clase apenas arranque
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RepositorioCategoria categoriaRepository;

    @Autowired
    private RepositorioRegion regionRepository;

    @Override
    public void run(String... args) throws Exception {

        // 1. SEMBRAR CATEGORÍAS INICIALES
        if (categoriaRepository.count() == 0) {
            log.info(">>> Base de datos limpia. Sembrando categorías iniciales...");

            ModeloCategoria cat1 = new ModeloCategoria();
            cat1.setNombre("Poleras");
            categoriaRepository.save(cat1);

            ModeloCategoria cat2 = new ModeloCategoria();
            cat2.setNombre("Pantalones");
            categoriaRepository.save(cat2);

            ModeloCategoria cat3 = new ModeloCategoria();
            cat3.setNombre("Chaquetas");
            categoriaRepository.save(cat3);

            log.info(">>> 3 Categorías cargadas exitosamente en Oracle Cloud.");
        } else {
            log.info(">>> Las categorías ya existen en la base de datos. Se omite la siembra.");
        }

        // 2. SEMBRAR REGIONES INICIALES
        if (regionRepository.count() == 0) {
            log.info(">>> Sembrando regiones base para cobros de envío...");

            ModeloRegion reg1 = new ModeloRegion();
            reg1.setNombre("Valparaíso");
            regionRepository.save(reg1);

            ModeloRegion reg2 = new ModeloRegion();
            reg2.setNombre("Metropolitana");
            regionRepository.save(reg2);

            log.info(">>> Regiones cargadas exitosamente.");
        } else {
            log.info(">>> Las regiones ya existen en la base de datos. Se omite la siembra.");
        }
    }
}