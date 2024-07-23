package com.example.mob.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mob.entidades.Cras;
import com.example.mob.servicos.CrasService;

@Controller
public class CrasController {

    @Autowired
    private CrasService crasService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cras", new Cras());
        model.addAttribute("crasList", crasService.getAllCras());
        return "telainicial";
    }

    @PostMapping("/salvar-cras")
    public String salvarCras(@ModelAttribute Cras cras) {
        crasService.saveCras(cras);
        return "redirect:/cras/sucesso";
    }

    @GetMapping("/cras/sucesso")
    public String sucesso() {
        return "cadastrocras_feito";
    }
    
   
}
