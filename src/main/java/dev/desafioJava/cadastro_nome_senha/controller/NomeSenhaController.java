package dev.desafioJava.cadastro_nome_senha.controller;

import dev.desafioJava.cadastro_nome_senha.dto.UsuarioRespostaDTO;
import dev.desafioJava.cadastro_nome_senha.model.NomeSenhaModel;
import dev.desafioJava.cadastro_nome_senha.service.NomeSenhaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class NomeSenhaController {

    private final NomeSenhaService nomeSenhaService;

    public NomeSenhaController(NomeSenhaService nomeSenhaService){
        this.nomeSenhaService = nomeSenhaService;
    }

    @GetMapping
    public List<NomeSenhaModel> listarTodos(){
        return nomeSenhaService.listarTodos();
    }

    @GetMapping("/{id}")
    public NomeSenhaModel buscarPorId(@PathVariable Long id){
        return nomeSenhaService.buscarPorId(id);
    }

    @PostMapping
    public NomeSenhaModel cadastrarUsuario(@RequestBody UsuarioRespostaDTO dto){
        NomeSenhaModel usuario = new NomeSenhaModel();
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());

        return nomeSenhaService.salvarUsuario(usuario);
    }

    @PutMapping("/{id}/senha")
    public NomeSenhaModel atualizarSenha(@PathVariable Long id, @RequestBody String novaSenha){
        return nomeSenhaService.atualizarSenha(id, novaSenha);
    }

    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id){
        return nomeSenhaService.deleteUsuario(id);
    }
}
