package dev.desafioJava.cadastro_nome_senha.repository;

import dev.desafioJava.cadastro_nome_senha.model.NomeSenhaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomeSenhaRepository extends JpaRepository<NomeSenhaModel,Long> {
}
