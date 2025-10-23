package com.practica.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MuebleController {

    @PostMapping("/crear_mueble")
    String crearMueble() {
        return "crear_mueble";
    }

    @PostMapping("/crear/mueble")
    String guardarMueble(@RequestParam String nombre, @RequestParam double precio) {
        
    }
}
