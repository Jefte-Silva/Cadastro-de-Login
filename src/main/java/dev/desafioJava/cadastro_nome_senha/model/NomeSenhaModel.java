package dev.desafioJava.cadastro_nome_senha.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Table(name = "Cadastro_Nome_Senha")
@Entity
public class NomeSenhaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 20 )
    private String nome;

    // Modulo validation
    @NotBlank
    @Size(min = 6 , max = 20)
    private String senha;

    //Contrutor vazio
    public NomeSenhaModel(){

    }

    //Construtor com argumentos
    public NomeSenhaModel(String nome,String senha){
        this.nome = nome;
        this.senha = senha;
    }


    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
