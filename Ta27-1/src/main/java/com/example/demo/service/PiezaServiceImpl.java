package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService {
    @Autowired
    private IPiezaDAO piezaDAO;

    @Override
    public List<Pieza> listarPiezas() {
        return piezaDAO.findAll();
    }

    @Override
    public Pieza obtenerPiezaPorCodigo(int codigo) {
        return piezaDAO.findById(codigo).orElse(null);
    }

    @Override
    public Pieza guardarPieza(Pieza pieza) {
        return piezaDAO.save(pieza);
    }

    @Override
    public Pieza actualizarPieza(int codigo, Pieza pieza) {
        if (piezaDAO.existsById(codigo)) {
            pieza.setCodigo(codigo);
            return piezaDAO.save(pieza);
        }
        return null;
    }

    @Override
    public void eliminarPieza(int codigo) {
        piezaDAO.deleteById(codigo);
    }
}