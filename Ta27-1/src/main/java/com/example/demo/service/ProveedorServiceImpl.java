package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService {
    @Autowired
    private IProveedorDAO proveedorDAO;

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorDAO.findAll();
    }

    @Override
    public Proveedor obtenerProveedorPorId(String id) {
        return proveedorDAO.findById(id).orElse(null);
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorDAO.save(proveedor);
    }

    @Override
    public Proveedor actualizarProveedor(String id, Proveedor proveedor) {
        if (proveedorDAO.existsById(id)) {
            proveedor.setId(id);
            return proveedorDAO.save(proveedor);
        }
        return null;
    }

    @Override
    public void eliminarProveedor(String id) {
        proveedorDAO.deleteById(id);
    }
}
