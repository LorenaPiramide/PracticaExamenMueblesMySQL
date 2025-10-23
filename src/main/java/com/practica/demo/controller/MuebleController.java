package com.practica.demo.controller;

import com.practica.demo.dao.DAOFactory;
import com.practica.demo.entidades.EstadoMueble;
import com.practica.demo.entidades.Mueble;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MuebleController {

    @GetMapping("/crear_mueble")
    String crearMuebleForm(Model model) {
        model.addAttribute("estados", EstadoMueble.values());
        return "crear_mueble";
    }

    @PostMapping("/crear/mueble")
    String guardarMueble(@RequestParam String nombre, String descripcion, double precio, EstadoMueble estadoMueble) {

        DAOFactory.getInstance().getDaoMueble().guardaMueble(nombre, descripcion, precio, estadoMueble);
        return "redirect:/tabla_mueble";
    }

    //@GetMapping("/editar_mueble")

    @GetMapping("/detalles_mueble/{id}")
    String getDetallesMueble(@PathVariable int id, Model model) {

        Mueble mueble = DAOFactory.getInstance().getDaoMueble().getDetallesMueble(id);

        model.addAttribute("mueble", mueble);

        return "detalles_mueble";
    }

    @GetMapping("/tabla_mueble")
    String getMueble(Model model) {
        List<Mueble> muebles = DAOFactory.getInstance().getDaoMueble().getMuebles();
        model.addAttribute("muebles", muebles);

        return "tabla_mueble";
    }

//    @GetMapping("/tabla_mueble")
//    String getMueble(Model model) {
//        List<Mueble> muebles = DAOFactory.getInstance().getDaoMueble().getMueblesTienda();
//        model.addAttribute("muebles", muebles);
//        return "tabla_mueble";
//    }
}
