package br.com.attornatus.pessoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoa.domain.Pessoa;

/**
 * @author palmerio
 * 
 * Esta classe extende a API do JpaRepository, interface para operações
 * CRUD genéricas em um repositório para um tipo específico.
 *
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	

}
