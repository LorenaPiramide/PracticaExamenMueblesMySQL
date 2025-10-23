package com.practica.demo.dao.mueble;

import com.practica.demo.entidades.EstadoMueble;
import com.practica.demo.entidades.Mueble;

import java.util.List;

public interface DAOMueble {
    void guardaMueble(String nombre, String descripcion, double precio, EstadoMueble estadoMueble);
    List<Mueble> getMuebles();
    Mueble getDetallesMueble(int id);
//    List<Mueble> getMuebleTienda();
//    List<Mueble> filtrarPorTienda(String nombreTienda);
//    List<Mueble> filtrarPorEstado(EstadoMueble estadoMueble);
//    List<Mueble> ordenarPorPrecio(double precio);
}
