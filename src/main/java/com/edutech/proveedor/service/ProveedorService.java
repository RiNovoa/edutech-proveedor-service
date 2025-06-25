package com.edutech.proveedor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.proveedor.model.Proveedor;
import com.edutech.proveedor.repository.ProveedorRepositoryJPA;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepositoryJPA proveedorRepository;

    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> buscarProveedorPorId(Integer id) {
        return proveedorRepository.findById(id);
    }
}
