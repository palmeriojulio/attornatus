package br.com.attornatus.pessoa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoa.domain.Endereco;

/**
 * @author palmerio
 * 
 * Esta classe extende a API do JpaRepository, interface para operações
 * CRUD genéricas em um repositório para um tipo específico.
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	

		
	@Query(value = "select * from pessoa_endereco where id_pessoa = :id", nativeQuery = true)
	List<String> listarEnderecosPessoaById(Long id);	
	

}
