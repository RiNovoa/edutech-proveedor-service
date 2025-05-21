package com.edutech.proveedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.edutech.proveedor.model.Proveedor;
import com.edutech.proveedor.service.ProveedorService;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        List<Proveedor> proveedores = proveedorService.getProveedores();
        return proveedores.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(proveedores);
    }

    @PostMapping
    public ResponseEntity<Proveedor> agregarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevo = proveedorService.saveProveedor(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable int id) {
        try {
            return ResponseEntity.ok(proveedorService.getProveedor(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable int id, @RequestBody Proveedor proveedor) {
        try {
            proveedorService.getProveedor(id); // Verifica existencia
            proveedor.setId(id);
            return ResponseEntity.ok(proveedorService.saveProveedor(proveedor));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable int id) {
        try {
            proveedorService.deleteProveedor(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
