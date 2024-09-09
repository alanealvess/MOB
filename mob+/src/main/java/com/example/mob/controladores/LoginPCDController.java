package com.example.mob.controladores;

import com.example.mob.entidades.PessoaComDeficiencia;
import com.example.mob.servicos.PCDService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginPCDController {

    @Autowired
    private PCDService pcdService;

    @GetMapping("/login-pessoa")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Email ou senha inválidos!");
        }
        return "LoginPessoa"; // Nome da página de login para Pessoa
    }

    @PostMapping("/login-pessoa")
    public String login(@RequestParam String email, @RequestParam String senha, HttpSession session, Model model) {
        PessoaComDeficiencia pessoaComDeficiencia = pcdService.findByEmail(email);

        if (pessoaComDeficiencia != null && pessoaComDeficiencia.getSenha().equals(senha)) {
            session.setAttribute("emailLogadoPessoa", email); // Armazena o email da pessoaComDeficiencia na sessão
            return "redirect:/pessoaComDeficiencia-dashboard"; // Redireciona para a página de sucesso da pessoaComDeficiencia
        } else {
            model.addAttribute("error", "Email ou senha inválidos!");
            return "LoginPessoa";
        }
    }


    @GetMapping("/logout-pessoa")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida a sessão para logout
        return "redirect:/login-pessoa"; // Redireciona para a página de login
    }

    @GetMapping("/success-pcd")
    public String successPessoaPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("emailLogado");
        PessoaComDeficiencia pessoaComDeficiencia = pcdService.findByEmail(email);

        if (pessoaComDeficiencia != null) {
            model.addAttribute("pessoa", pessoaComDeficiencia);
        } else {
            model.addAttribute("error", "Pessoa não encontrada");
        }
        return "success-pcd";
    }

}
