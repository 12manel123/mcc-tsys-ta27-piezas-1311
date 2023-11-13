package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaService {
    List<Pieza> listarPiezas();

    Pieza obtenerPiezaPorCodigo(int codigo);

    Pieza guardarPieza(Pieza pieza);

    Pieza actualizarPieza(int codigo, Pieza pieza);

    void eliminarPieza(int codigo);
}