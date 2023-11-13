package com.example.demo.controller;

import com.example.demo.dto.Suministra;
import com.example.demo.service.ISuministraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suministra")
public class SuministraController {
    @Autowired
    private ISuministraService suministraService;

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    public List<Suministra> getSuministros() {
        return suministraService.listarSuministros();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public Suministra getSuministroPorId(@PathVariable int id) {
        return suministraService.obtenerSuministroPorId(id);
    }

    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public Suministra crearSuministro(@RequestBody Suministra suministra) {
        return suministraService.guardarSuministro(suministra);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public Suministra actualizarSuministro(@PathVariable int id, @RequestBody Suministra suministra) {
        return suministraService.actualizarSuministro(id, suministra);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void eliminarSuministro(@PathVariable int id) {
        suministraService.eliminarSuministro(id);
    }
}