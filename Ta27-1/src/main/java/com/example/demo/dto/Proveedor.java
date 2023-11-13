package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    private String id;
    private String nombre;

    @OneToMany(mappedBy = "proveedor")
    @JsonIgnore
    private List<Suministra> suministros;

    public Proveedor() {
    }

    public Proveedor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Proveedor [id=" + id + ", nombre=" + nombre + "]";
    }
}
