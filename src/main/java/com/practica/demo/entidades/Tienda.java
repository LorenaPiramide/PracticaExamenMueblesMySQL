package com.practica.demo.entidades;

// En una tienda hay muchos muebles, y el mismo mueble puede venderse en varias tiendas
public class Tienda {
    private String nombre;
    private int ciudad;

    public Tienda(String nombre, int ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }
}
