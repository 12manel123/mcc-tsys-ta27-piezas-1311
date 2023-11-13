package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proveedor;

public interface IProveedorService {
    List<Proveedor> listarProveedores();

    Proveedor obtenerProveedorPorId(String id);

    Proveedor guardarProveedor(Proveedor proveedor);

    Proveedor actualizarProveedor(String id, Proveedor proveedor);

    void eliminarProveedor(String id);
}
