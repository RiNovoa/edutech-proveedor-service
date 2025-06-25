package com.edutech.proveedor.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.edutech.proveedor.ProveedorServiceApplication;
import com.edutech.proveedor.model.Proveedor;

import net.datafaker.Faker;

@SpringBootTest(classes = ProveedorServiceApplication.class)
@ActiveProfiles("test")  // Usa application-test.properties con H2
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // Usa base embebida H2 para tests
public class ProveedorRepositoryJPATest {

    @Autowired
    private ProveedorRepositoryJPA proveedorRepository;

    @Test
    public void testGuardarProveedorConDatafaker() {
        Faker faker = new Faker();

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(faker.company().name());

        Proveedor guardado = proveedorRepository.save(proveedor);

        assertThat(guardado.getId()).isNotNull();
        assertThat(guardado.getNombre()).isNotEmpty();
    }
}
