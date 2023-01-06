package br.com.attornatus.pessoa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoa.domain.Endereco;

/**
 * @author palmerio
 * 
 * Classe
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
