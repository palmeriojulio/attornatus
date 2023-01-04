package br.com.attornatus.pessoa.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.attornatus.pessoa.domain.Pessoa;

/**
 * @author palmerio
 * 
 *         Essa classe ultiliza o padrão de projetos Data Transfer Object (DTO)
 *         o transporte de dados entre diferentes componentes.
 * 
 */
public class PessoaDto {

	private long id;
	private String nome;
	private LocalDate dataNascincimento;
	private List<EnderecoDto> enderecos;

	public PessoaDto() {
		super();
	}

	public PessoaDto(long id, String nome, LocalDate dataNascincimento, List<EnderecoDto> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascincimento = dataNascincimento;
		this.enderecos = enderecos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascincimento() {
		return dataNascincimento;
	}

	public void setDataNascincimento(LocalDate dataNascincimento) {
		this.dataNascincimento = dataNascincimento;
	}

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}

	/** Convertendo o objeto Pessoa para objeto Dto */
	public static Pessoa toPessoa(PessoaDto dto) {
		return new Pessoa(dto.getId(), dto.getNome(), dto.getDataNascincimento(),
				EnderecoDto.toConvertList(dto.getEnderecos()));
	}

	/** Convertendo o objeto Dto para objeto Pessoa */
	public static PessoaDto fromPessoa(Pessoa entity) {
		return new PessoaDto(entity.getId(), entity.getNome(), entity.getDataNascincimento(),
				EnderecoDto.fromConvertList(entity.getEnderecos()));

	}

}
