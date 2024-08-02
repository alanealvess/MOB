package com.example.mob.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mob.entidades.Ong;
import com.example.mob.entidades.Cras;
import com.example.mob.servicos.OngService;
import com.example.mob.servicos.CrasService;

@Controller
public class LoginONGCRASController {

    @Autowired
    private OngService ongService;

    @Autowired
    private CrasService crasService;

    @GetMapping("/login-ongcras")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Email ou senha inválidos!");
        }
        return "LoginONGCRAS";
    }

    @PostMapping("/login-ongcras")
    public String login(@RequestParam String email, @RequestParam String senha, Model model) {
        Ong ong = ongService.findByEmail(email);
        Cras cras = crasService.findByEmail(email);

        if (ong != null && ong.getSenha().equals(senha)) {
            return "redirect:/success";
        } else if (cras != null && cras.getSenha().equals(senha)) {
            return "redirect:/success-cras";
        } else {
            model.addAttribute("error", "Email ou senha inválidos!");
            return "LoginONGCRAS";
        }
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }

    @GetMapping("/success-cras")
    public String successCrasPage() {
        return "success-cras";
    }

    @GetMapping("/alterar-senha")
    public String alterarSenhaPage() {
        return "alterarSenha";
    }

    @PostMapping("/alterar-senha")
    public String processarAlterarSenha(@RequestParam String email, @RequestParam String novaSenha, Model model) {
        Ong ong = ongService.findByEmail(email);
        Cras cras = crasService.findByEmail(email);

        if (ong != null) {
            ong.setSenha(novaSenha);
            ongService.saveOng(ong); // Atualiza o banco de dados
            model.addAttribute("message", "Senha alterada com sucesso!");
        } else if (cras != null) {
            cras.setSenha(novaSenha);
            crasService.saveCras(cras); // Atualiza o banco de dados
            model.addAttribute("message", "Senha alterada com sucesso!");
        } else {
            model.addAttribute("error", "Email não encontrado!");
            return "alterarSenha";
        }
        return "redirect:/success";
    }

    @GetMapping("/alterar-dados")
    public String alterarDadosPage() {
        return "alterarDados";
    }

    @PostMapping("/alterar-dados")
    public String processarAlterarDados(@RequestParam String email, @RequestParam String nome, @RequestParam String novoEmail, Model model) {
        Ong ong = ongService.findByEmail(email);
        Cras cras = crasService.findByEmail(email);

        if (ong != null) {
            ong.setNome(nome);
            ong.setEmail(novoEmail);
            ongService.saveOng(ong); // Atualiza o banco de dados
            model.addAttribute("message", "Dados alterados com sucesso!");
        } else if (cras != null) {
            cras.setNome(nome);
            cras.setEmail(novoEmail);
            crasService.saveCras(cras); // Atualiza o banco de dados
            model.addAttribute("message", "Dados alterados com sucesso!");
        } else {
            model.addAttribute("error", "Email não encontrado!");
            return "alterarDados";
        }
        return "redirect:/success";
    }
    
    @GetMapping("/sessao-encerrada")
    public String sessaoEncerradaPage() {
        return "sessao-encerrada";
    }

}
