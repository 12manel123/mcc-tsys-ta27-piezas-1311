package com.example.demo.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "piezas")
public class Pieza {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;

    @OneToMany(mappedBy = "pieza")
    @JsonIgnore
    private List<Suministra> suministros;
    
    public Pieza() {
    }

    public Pieza(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Suministra> getSuministros() {
        return suministros;
    }

    public void setSuministros(List<Suministra> suministros) {
        this.suministros = suministros;
    }

    @Override
    public String toString() {
        return "Pieza [codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}
