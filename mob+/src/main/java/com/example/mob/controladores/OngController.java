package com.example.mob.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mob.entidades.*;
import com.example.mob.servicos.*;

@Controller
public class OngController {

    @Autowired
    private OngService ongService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("ong", new Ong());
        model.addAttribute("ongs", ongService.getAllOngs());
        return "telainicial";
    }

    @PostMapping("/salvar-ong")
    public String salvarOng(@ModelAttribute Ong ong) {
        ongService.saveOng(ong);
        return "redirect:/sucesso";
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "cadastroong_feito";
    }

}

