package br.com.attornatus.pessoa.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.attornatus.pessoa.domain.Pessoa;

/**
 * @author palmerio
 * 
 * Essa classe ultiliza o padrão de projetos Data Transfer Object (DTO)
 * o transporte de dados entre diferentes componentes.
 * 
 */
public class PessoaDto {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private List<EnderecoDto> enderecos;

	public PessoaDto() {
		super();
	}

	public PessoaDto(Long id, String nome, LocalDate dataNascimento, List<EnderecoDto> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
	}

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}

	/** Convertendo objeto PessoaDto para objeto Pessoa  */
	public static Pessoa toPessoa(PessoaDto dto) {
		return new Pessoa(
				dto.getId(), 
				dto.getNome(), 
				dto.getDataNascimento(),
				EnderecoDto.toConvertList(dto.getEnderecos()));
	}

	/** Convertendo o objeto Pessoa para objeto PessoaDto  */
	public static PessoaDto fromPessoa(Pessoa entity) {
		return new PessoaDto(
				entity.getId(), 
				entity.getNome(), 
				entity.getDataNascincimento(),
				EnderecoDto.fromConvertList(entity.getEnderecos()));
	}

}
