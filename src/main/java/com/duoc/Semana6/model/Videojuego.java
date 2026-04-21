package com.duoc.Semana6.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "videojuego")
public class Videojuego {

    @Id
    private int id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false)
    private int precio;

    @Column(nullable = false, length = 50)
    private String plataforma;

    @Column(nullable = false)
    private boolean disponibilidad;

    public Videojuego() {
    }

    public Videojuego(int id, String titulo, int precio, String plataforma, boolean disponibilidad) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
