package com.edutech.proveedor.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Usa configuración de test
class ProveedorServiceApplicationTests {

    @Test
    void contextLoads() {
        // Verifica que el contexto de Spring se carga sin problemas
    }
}
