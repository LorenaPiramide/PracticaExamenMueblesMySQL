package com.practica.demo.entidades;

// En una tienda hay muchos muebles, y el mismo mueble puede venderse en varias tiendas
public class Tienda {
    private String nombreTienda;
    private String localidad;

    public Tienda(String nombre, String ciudad) {
        this.nombreTienda = nombre;
        this.localidad = ciudad;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombreTienda + '\'' +
                ", ciudad=" + localidad +
                '}';
    }
}
