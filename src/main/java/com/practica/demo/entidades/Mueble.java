package com.practica.demo.entidades;

public class Mueble {
    private int id;
    private String nombre;
    private double precio;
    private EstadoMueble estadoMueble;

    public Mueble(int id, String nombre, double precio, EstadoMueble estadoMueble) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.estadoMueble = estadoMueble;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoMueble getEstadoMueble() {
        return estadoMueble;
    }

    public void setEstadoMueble(EstadoMueble estadoMueble) {
        this.estadoMueble = estadoMueble;
    }

    @Override
    public String toString() {
        return "Mueble{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", estadoMueble=" + estadoMueble +
                '}';
    }
}
