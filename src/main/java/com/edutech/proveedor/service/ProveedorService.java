package com.edutech.proveedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.proveedor.model.Proveedor;
import com.edutech.proveedor.repository.ProveedorRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProveedorService {

    @Autowired
    private ProveedorRepositoryJPA proveedorRepository;

    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor getProveedor(int id) throws Exception {
        return proveedorRepository.findById(id)
            .orElseThrow(() -> new Exception("Proveedor no encontrado con id " + id));
    }

    public void deleteProveedor(int id) {
        proveedorRepository.deleteById(id);
    }
}
