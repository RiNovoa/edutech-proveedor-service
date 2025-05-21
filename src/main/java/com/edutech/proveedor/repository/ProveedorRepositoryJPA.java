package com.edutech.proveedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.proveedor.model.Proveedor;

@Repository
public interface ProveedorRepositoryJPA extends JpaRepository<Proveedor, Integer> {
}
