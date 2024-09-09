package com.example.mob.controladores;

import com.example.mob.entidades.Cras;
import com.example.mob.entidades.Ong;
import com.example.mob.entidades.PessoaComDeficiencia;
import com.example.mob.servicos.CrasService;
import com.example.mob.servicos.OngService;
import com.example.mob.servicos.PCDService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.SecureRandom;
import java.util.Base64;

@Controller
public class PCDController {

    @Autowired
    private PCDService PCDServiceService;

    @Autowired
    private OngService ongService;

    @Autowired
    private CrasService crasService;

    @GetMapping("/pcds")
    public String listarPessoasCadastradas(HttpSession session, Model model) {
        String emailLogado = (String) session.getAttribute("emailLogado");
        Ong ongLogada = ongService.findByEmail(emailLogado);
        Cras crasLogado = crasService.findByEmail(emailLogado);

        if (ongLogada != null) {
            model.addAttribute("pessoas", PCDServiceService.findByOng(ongLogada));
        } else if (crasLogado != null) {
            model.addAttribute("pessoas", PCDServiceService.findByCras(crasLogado));
        } else {
            model.addAttribute("error", "Usuário não encontrado.");
        }

        return "listar-pcds"; // Retornar a view correspondente
    }

    @PostMapping("/cadastrar-pcd")
    public String cadastrarPessoa(@ModelAttribute PessoaComDeficiencia pessoaComDeficiencia, HttpSession session, Model model) {
        String emailLogado = (String) session.getAttribute("emailLogado");
        Ong ongLogada = ongService.findByEmail(emailLogado);
        Cras crasLogado = crasService.findByEmail(emailLogado);

        if (ongLogada != null) {
            pessoaComDeficiencia.setOng(ongLogada); // Associar pessoa à ONG logada
        } else if (crasLogado != null) {
            pessoaComDeficiencia.setCras(crasLogado); // Associar pessoa ao CRAS logado
        } else {
            model.addAttribute("error", "Usuário não encontrado.");
            return "redirect:/";
        }

        String senhaGerada = gerarSenhaAutomatica();
        pessoaComDeficiencia.setSenha(senhaGerada);

        PCDServiceService.savePessoa(pessoaComDeficiencia);
        return "redirect:/pcds"; // Redirecionar para a listagem após o cadastro
    }

    private String gerarSenhaAutomatica() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[24];
        random.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
}
