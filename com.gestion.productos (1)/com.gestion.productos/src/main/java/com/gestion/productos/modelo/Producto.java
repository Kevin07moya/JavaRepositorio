package com.gestion.productos.modelo;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="")
    private String nombre;

    private float precio;

    public Producto(Integer id, String nombre, float precio) {
        super ();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto( String nombre, float precio) {
        super ();
        this.nombre = nombre;
        this.precio = precio;
    }
    public Producto() {
        super ();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
