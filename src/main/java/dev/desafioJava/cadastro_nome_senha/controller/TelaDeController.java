package dev.desafioJava.cadastro_nome_senha.controller;

import dev.desafioJava.cadastro_nome_senha.model.NomeSenhaModel;
import dev.desafioJava.cadastro_nome_senha.service.NomeSenhaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TelaDeController {

    private final NomeSenhaService nomeSenhaService;

    // Injeção de dependência
    public TelaDeController(NomeSenhaService nomeSenhaService) {
        this.nomeSenhaService = nomeSenhaService;
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new NomeSenhaModel());
        return "telaDeCadastro"; // renderiza telaDeCadastro.html
    }

    @PostMapping("/form")
    public String cadastrarViaFormulario(@ModelAttribute NomeSenhaModel usuario) {
        nomeSenhaService.salvarUsuario(usuario);
        return "redirect:/form?success";
    }
}
