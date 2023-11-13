package com.example.demo.controller;

import com.example.demo.dto.Proveedor;
import com.example.demo.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    public List<Proveedor> getProveedores() {
        return proveedorService.listarProveedores();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public Proveedor getProveedorPorId(@PathVariable String id) {
        return proveedorService.obtenerProveedorPorId(id);
    }

    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.guardarProveedor(proveedor);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public Proveedor actualizarProveedor(@PathVariable String id, @RequestBody Proveedor proveedor) {
        return proveedorService.actualizarProveedor(id, proveedor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void eliminarProveedor(@PathVariable String id) {
        proveedorService.eliminarProveedor(id);
    }
}