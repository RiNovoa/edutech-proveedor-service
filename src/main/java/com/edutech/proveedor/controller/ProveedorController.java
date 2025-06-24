package com.edutech.proveedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return proveedores.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(proveedores);
    }

    @PostMapping
    public ResponseEntity<Proveedor> agregarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevo = proveedorService.saveProveedor(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}
