package dev.desafioJava.cadastro_nome_senha.service;

import dev.desafioJava.cadastro_nome_senha.model.NomeSenhaModel;
import dev.desafioJava.cadastro_nome_senha.repository.NomeSenhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomeSenhaService {

    // Injeção do repository, para usar metodos salva buscar etc
    private final NomeSenhaRepository nomeSenhaRepository;

    //Construtor recebe o repositorio e fica pronto para uso
    public  NomeSenhaService(NomeSenhaRepository nomeSenhaRepository){
        this.nomeSenhaRepository = nomeSenhaRepository;
    }

    //metodos

    public List<NomeSenhaModel> listarTodos(){
        return nomeSenhaRepository.findAll();
    }

    //Recebe o objeto  usuario vindo da camada Controller

    public NomeSenhaModel salvarUsuario (NomeSenhaModel usuario){
        return nomeSenhaRepository.save(usuario); // Retorna o objeto salvo com o ID preenchido
    }

    public NomeSenhaModel buscarPorId(Long id){
        return nomeSenhaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Usuário não encontrado " +id));
    }

    /*

    Forma simples ñ retorna msgem p usuário

    public void deleteUsuario(Long id){
        nomeSenhaRepository.deleteById(id);
    }

    */

    public String deleteUsuario(Long id){
        nomeSenhaRepository.deleteById(id);
        return (id+" Foi deleteado com sucesso.");
    }

    public NomeSenhaModel atualizarSenha(Long id,String novaSenha){
        // Buscar usuario no BD
        Optional<NomeSenhaModel>usuarioOpcional = nomeSenhaRepository.findById(id);

        // Se nao encontrar, lançar exeção
        if (usuarioOpcional.isEmpty()){
            throw new RuntimeException("Usuário com "+id+" não encontrado.");
        }
            //se encontrar
            NomeSenhaModel usuario = usuarioOpcional.get();

            // Validar acesso
            if (!novaSenha.matches(".*[A-Z].*") || !novaSenha.matches(".*[!@#$%^&*()_+=<>?/]*.")){
                throw new RuntimeException("Deve conter pelo mais um aletra Maiuscula e um caracter especial");
            }

            // Atualizar campo e senha
            usuario.setSenha(novaSenha);

            // Salva novamente no BD
            return nomeSenhaRepository.save(usuario);
    }

}
