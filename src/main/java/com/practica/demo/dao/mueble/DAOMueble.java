package com.practica.demo.dao.mueble;

import com.practica.demo.entidades.EstadoMueble;
import com.practica.demo.entidades.Mueble;

import java.util.List;

public interface DAOMueble {
    void addMueble(String nombre, double precio, EstadoMueble estadoMueble);
    List<Mueble> getMuebles();
}
