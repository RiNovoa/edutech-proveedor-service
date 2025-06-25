package com.edutech.proveedor.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.edutech.proveedor.model.Proveedor;
import com.edutech.proveedor.repository.ProveedorRepositoryJPA;
import com.edutech.proveedor.util.ProveedorTestUtils;

class ProveedorServiceTest {

    @Mock
    private ProveedorRepositoryJPA proveedorRepository;

    @InjectMocks
    private ProveedorService proveedorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarProveedorPorId() {
        Proveedor proveedor = ProveedorTestUtils.crearProveedorFake();
        proveedor.setId(1);

        when(proveedorRepository.findById(1)).thenReturn(Optional.of(proveedor));

        Optional<Proveedor> resultado = proveedorService.buscarProveedorPorId(1);

        assertTrue(resultado.isPresent());
        assertEquals(proveedor.getNombre(), resultado.get().getNombre());
    }

    @Test
    void testGuardarProveedor() {
        Proveedor proveedor = ProveedorTestUtils.crearProveedorFake();

        when(proveedorRepository.save(proveedor)).thenReturn(proveedor);

        Proveedor resultado = proveedorService.saveProveedor(proveedor);

        assertNotNull(resultado);
        assertEquals(proveedor.getNombre(), resultado.getNombre());
    }

    @Test
    void testBuscarProveedorPorIdNoEncontrado() {
        when(proveedorRepository.findById(999)).thenReturn(Optional.empty());

        Optional<Proveedor> resultado = proveedorService.buscarProveedorPorId(999);

        assertTrue(resultado.isEmpty());
    }
}
