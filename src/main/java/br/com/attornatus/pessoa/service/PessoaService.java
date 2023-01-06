package br.com.attornatus.pessoa.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.dao.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;
import br.com.attornatus.pessoa.dto.PessoaDto;

@Service
public class PessoaService {

	final PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	// * Metódo que salva um registro na tabela pessoa. */
	public PessoaDto criarPessoa(PessoaDto dto) {
		try {
			var pessoa = pessoaRepository.save(PessoaDto.toPessoa(dto));
			return convertReturn(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}

	// * Metódo que edita um registro da tabela pessoa. */
	public PessoaDto editarPessoa(PessoaDto dto) {		 
		try {
			var pessoa = pessoaRepository.save(PessoaDto.toPessoa(dto));
			return convertReturn(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}

	// * Metódo que lista um registros da tabela pessoa. */
	public PessoaDto consultarPessoa(Long id) {
		try {
			var pessoa = pessoaRepository.findById(id);
			return convertOptionalReturn(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}

	}

	// * Metódo que lista todas os registros da tabela pessoa. */
	public List<PessoaDto> listarPessoas() {
		try {
			return pessoaRepository.findAll().stream().map(p -> PessoaDto.fromPessoa(p))
					.sorted((p1, p2) -> p1.getId().compareTo(p2.getId())).collect(Collectors.toList());
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}

	// * Chama o método para converter o objeto Pessoa para o objeto PessoaDto */
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

	// * Chama o método para converter o Optional para o objeto PessoaDto */
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
