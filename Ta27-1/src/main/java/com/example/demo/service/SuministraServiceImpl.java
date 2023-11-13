package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISuministraDAO;
import com.example.demo.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService {
    @Autowired
    private ISuministraDAO suministraDAO;

    @Override
    public List<Suministra> listarSuministros() {
        return suministraDAO.findAll();
    }

    @Override
    public Suministra obtenerSuministroPorId(int id) {
        return suministraDAO.findById(id).orElse(null);
    }

    @Override
    public Suministra guardarSuministro(Suministra suministra) {
        return suministraDAO.save(suministra);
    }

    @Override
    public Suministra actualizarSuministro(int id, Suministra suministra) {
        if (suministraDAO.existsById(id)) {
            suministra.setId(id);
            return suministraDAO.save(suministra);
        }
        return null;
    }

    @Override
    public void eliminarSuministro(int id) {
        suministraDAO.deleteById(id);
    }
}