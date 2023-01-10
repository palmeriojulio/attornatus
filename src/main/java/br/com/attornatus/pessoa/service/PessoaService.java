package br.com.attornatus.pessoa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.dao.PessoaRepository;
import br.com.attornatus.pessoa.domain.Endereco;
import br.com.attornatus.pessoa.domain.Pessoa;
import br.com.attornatus.pessoa.dto.PessoaDto;
import br.com.attornatus.pessoa.exception.AttornatusException;

@Service
public class PessoaService {

	final PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public PessoaDto criarPessoa(PessoaDto dto) {
		try {
			var pessoa = pessoaRepository.save(PessoaDto.toPessoa(dto));
			return convertReturn(pessoa);
		} catch (RuntimeException e) {
			throw new AttornatusException(e.getMessage());
		}
	}

	public PessoaDto editarPessoa(PessoaDto dto) {
		try {
			var pessoa = pessoaRepository.save(PessoaDto.toPessoa(dto));
			return convertReturn(pessoa);
		} catch (RuntimeException e) {
			throw new AttornatusException(e.getMessage());
		}
	}

	public PessoaDto consultarPessoa(Long id) {
		try {
			var pessoa = pessoaRepository.findById(id);
			return convertOptionalReturn(pessoa);
		} catch (RuntimeException e) {
			throw new AttornatusException("Pessoa de id: " + id + ", não encontrada!");
		}

	}

	public List<PessoaDto> listarPessoas() {
		List<PessoaDto> pessoas = new ArrayList<PessoaDto>();
		try {
			pessoas = pessoaRepository.findAll().stream().map(p -> PessoaDto.fromPessoa(p))
					.sorted((p1, p2) -> p1.getId().compareTo(p2.getId())).collect(Collectors.toList()); 
			if (pessoas.isEmpty()) {
				throw new AttornatusException("Não existem pessoas cadastradas!");
			} 			
			return pessoas;				
		} catch (RuntimeException e) {
			throw new AttornatusException(e.getMessage());
		}
	}

	/**
	 * Esse método cria um endereço para uma pessoa. Ele recebe um dto, consulta no
	 * banco se existe uma pessoa com o id passado, se existe a pessoa, verifica se
	 * o endereço passado já está cadastrado como principal, se for verdade lança
	 * uma exceção caso contrario adiciona o endereço a pessoa.
	 * 
	 * @author palmerio
	 * @param PessoaDto dto - dados que vem da tela.
	 * @return Uma classe Pessoa.
	 * @exception Retrona mensagem de erro ou o objeto pessoa.
	 */
	public PessoaDto criarEnderecoPessoa(PessoaDto dto) {
		var pessoaDto = consultarPessoa(dto.getId());
		try {
			if (pessoaDto.getId() == dto.getId()) {
				verificaEnderecoPricipal(pessoaDto, dto);
				pessoaDto.getEnderecos().addAll(dto.getEnderecos());
				var pessoa = pessoaRepository.save(PessoaDto.toPessoa(pessoaDto));
				return PessoaDto.fromPessoa(pessoa);
			} else {
				return null;
			}
		} catch (RuntimeException e) {
			throw new AttornatusException(e.getMessage());
		}
	}

	/**
	 * Esse método recebe um dto que foi passado pelo front e o dto da conculta do
	 * método que chamou, cria uma variável que recebe uma lista de enderecos que
	 * tenha o endereco principal com Sim, verifica se a lista tem o tamanho igual a
	 * 1 e se o valor do campo endereco principal da requisição tem o valor de Sim,
	 * caso verdade retorna uma exceção.
	 * 
	 * @author palmerio
	 * @param PessoaDto - vinda da consulta do banco.
	 * @param Dto - vindo do front.
	 * @return Uma classe Pessoa.
	 * @exception Retrona ema exceção ou uma lista Dto de endereços.
	 */
	private void verificaEnderecoPricipal(PessoaDto pessoaDto, PessoaDto dto) {
		var enderecos = pessoaDto.getEnderecos().stream()
				.filter(pessoa -> pessoa.getEnderecoPrincipal().equalsIgnoreCase("Sim")).collect(Collectors.toList());
		if (enderecos.size() == 1 && dto.getEnderecos().get(0).getEnderecoPrincipal().equalsIgnoreCase("Sim")) {
			throw new AttornatusException("Já existem um endereço como principal.");
		}
	}

	/**
	 * Recebe um id e listar todos os endereços cadastrados de uma pessoa.
	 *
	 * @author palmerio
	 * @param Long - id.
	 * @return Uma lista do tipo endereço.
	 * @exception Retrona uma exceção ou uma lista endereços.
	 */
	public List<Endereco> listarEnderecosPessoaById(Long id) {
		try {
			var pessoa = pessoaRepository.findById(id);
			return pessoa.get().getEnderecos();
		} catch (RuntimeException e) {
			throw new AttornatusException("Pessoa de id: " + id + ", não encontrada!");
		}
	}

	/**
	 * O método chama outro que converte uma pessoa em dto, se parametro passado não
	 * for nulo ele converte e retorna um objeto dto, caso seja nulo retorna uma
	 * exceção.
	 * 
	 * @author palmerio
	 * @param Entidade Pessoa.
	 * @return Um objeto Dto.
	 * @exception Retorna uma mensagem de erro.
	 */
	private PessoaDto convertReturn(Pessoa pessoa) {
		try {
			if (Objects.nonNull(pessoa)) {
				return PessoaDto.fromPessoa(pessoa);
			} else {
				return null;
			}
		} catch (RuntimeException e) {
			throw new AttornatusException("Ocorreu algum erro ao persistir pessoa!");
		}
	}
	
	/**
	 * O método chama outro que converte um Optional em dto, se parametro passado
	 * existir ele converte e retorna um objeto dto, caso seja não retorna uma
	 * exceção.
	 * 
	 * @author palmerio
	 * @param Optional de Pessoa.
	 * @return Um objeto Dto.
	 * @exception Retorna uma mensagem de erro.
	 */
	private PessoaDto convertOptionalReturn(Optional<Pessoa> pessoa) {
		try {
			if (pessoa.isPresent()) {
				return PessoaDto.fromPessoa(pessoa.get());
			} else {
				throw new AttornatusException("Pessoa não encontrada!");
			}
		} catch (RuntimeException e) {
			throw new AttornatusException("Ocorreu algum erro ao persistir pessoa!");
		}
	}
}
