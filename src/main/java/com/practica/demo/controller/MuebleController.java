package com.practica.demo.controller;

import com.practica.demo.dao.DAOFactory;
import com.practica.demo.entidades.EstadoMueble;
import com.practica.demo.entidades.Mueble;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MuebleController {

    @GetMapping("/crear_mueble")
    String crearMuebleForm() {
        return "crear_mueble";
    }

    @PostMapping("/crear/mueble")
    String guardarMueble(@ModelAttribute Mueble mueble) {
        DAOFactory.getInstance().getDaoMueble().guardaMueble(mueble);
        return "redirect:/tabla_mueble";
    }

    @GetMapping("/tabla_mueble")
    String getMueble(Model model) {
        List<Mueble> muebles = DAOFactory.getInstance().getDaoMueble().getMuebles();
        model.addAttribute("muebles", muebles);

        return "tabla_mueble";
    }
}
