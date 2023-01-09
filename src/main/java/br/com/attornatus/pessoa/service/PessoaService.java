package br.com.attornatus.pessoa.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.dao.PessoaRepository;
import br.com.attornatus.pessoa.domain.Endereco;
import br.com.attornatus.pessoa.domain.Pessoa;
import br.com.attornatus.pessoa.dto.PessoaDto;

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
			e.printStackTrace();
			return null;
		}
	}

	public PessoaDto editarPessoa(PessoaDto dto) {		 
		try {
			var pessoa = pessoaRepository.save(PessoaDto.toPessoa(dto));
			return convertReturn(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PessoaDto consultarPessoa(Long id) {
		try {
			var pessoa = pessoaRepository.findById(id);
			return convertOptionalReturn(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<PessoaDto> listarPessoas() {
		try {
			return pessoaRepository.findAll().stream().map(p -> PessoaDto.fromPessoa(p))
					.sorted((p1, p2) -> p1.getId().compareTo(p2.getId())).collect(Collectors.toList());
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * Cria um novo endereço para uma Pessoa.
	 *
	 * @param Dto.
	 * @return Um dto do tipo PessoaDto.
	 */
	public PessoaDto criarEnderecoPessoa(PessoaDto pessoaDto) {
		var pessoa = consultarPessoa(pessoaDto.getId());
		try {
			if (pessoa.getId() == pessoaDto.getId()) {				
				pessoa.getEnderecos().addAll(pessoaDto.getEnderecos());
				pessoaRepository.save(PessoaDto.toPessoa(pessoa));
				return (pessoa);
			} else {
				return null;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Listar todos os endereços cadastrados de uma pessoa.
	 *
	 * @param Long.
	 * @return Uma lista do tipo endereço.
	 */
	public List<Endereco> listarEnderecosPessoaById(Long id) {
		try {
			var pessoa = pessoaRepository.findById(id);
			return pessoa.get().getEnderecos(); 
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}

	private PessoaDto convertReturn(Pessoa pessoa) {
		try {
			if (Objects.nonNull(pessoa)) {
				return PessoaDto.fromPessoa(pessoa);
			} else {
				return null;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private PessoaDto convertOptionalReturn(Optional<Pessoa> pessoa) {
		try {
			if (pessoa.isPresent()) {
				return PessoaDto.fromPessoa(pessoa.get());
			} else {
				return null;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
}
