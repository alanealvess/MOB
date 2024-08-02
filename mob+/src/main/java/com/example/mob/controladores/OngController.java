package com.example.mob.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mob.entidades.*;
import com.example.mob.servicos.*;

<<<<<<< HEAD
import java.security.SecureRandom;
import java.util.Base64;

=======
>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
@Controller
public class OngController {

    @Autowired
    private OngService ongService;

    @GetMapping("/ong")
    public String index(Model model) {
        model.addAttribute("ong", new Ong());
        model.addAttribute("ongs", ongService.getAllOngs());
        return "telainicial";
    }

    @PostMapping("/salvar-ong")
    public String salvarOng(@ModelAttribute Ong ong) {
<<<<<<< HEAD
        String senhaGerada = gerarSenhaAutomatica();
        ong.setSenha(senhaGerada);
=======
>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
        ongService.saveOng(ong);
        return "redirect:/ong/sucesso";
    }

    @GetMapping("/ong/sucesso")
    public String sucesso() {
        return "cadastroong_feito";
    }
<<<<<<< HEAD

    private String gerarSenhaAutomatica() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[24];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
=======
>>>>>>> 45232dac7c716d6fe8d2ed401437d775e8cd0b2f
}
