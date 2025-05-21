package com.edutech.proveedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutech.proveedor.model.Proveedor;
import com.edutech.proveedor.service.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorVistaController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String mostrarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.getProveedores());
        return "proveedores"; // Asegúrate de tener un archivo proveedores.html
    }

    @PostMapping("/agregar")
    public String agregarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorService.saveProveedor(proveedor);
        return "redirect:/proveedores";
    }
}
