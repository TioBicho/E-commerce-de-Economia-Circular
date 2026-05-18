package com.e_commerce.ms_detalleventas.Config;

import com.e_commerce.ms_detalleventas.Modelo.ModeloDetalleVenta;
import com.e_commerce.ms_detalleventas.Repositorio.RepositorioDetalleVenta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class dataInitializer implements CommandLineRunner {


    private final RepositorioDetalleVenta repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de detalles de ventas...");

        if (repository.count() > 0) {
            log.info(">>> Detalles de ventas ya cargados. Se omite inicialización.");
            return;
        }

        log.info(">>> Base de datos de detalles vacía. Insertando líneas de prueba...");


        ModeloDetalleVenta detalle1 = new ModeloDetalleVenta();
        detalle1.setPrecioOriginal(20000);
        detalle1.setDescuentoAplicado(5000);
        detalle1.setRopaId("POL01NKL");
        detalle1.setVentaId(1L);


        ModeloDetalleVenta detalle2 = new ModeloDetalleVenta();
        detalle2.setPrecioOriginal(45000);
        detalle2.setDescuentoAplicado(0);
        detalle2.setRopaId("JNS03ADD");
        detalle2.setVentaId(1L);


        ModeloDetalleVenta detalle3 = new ModeloDetalleVenta();
        detalle3.setPrecioOriginal(15000);
        detalle3.setDescuentoAplicado(2000);
        detalle3.setRopaId("ZAP02PUM");
        detalle3.setVentaId(2L);


        repository.save(detalle1);
        repository.save(detalle2);
        repository.save(detalle3);

        log.info(">>> 3 líneas de detalle de ventas cargadas OK.");
    }
}