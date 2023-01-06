package br.com.attornatus.pessoa.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.attornatus.pessoa.domain.Endereco;

/**
 * @author palmerio
 * 
 * Essa classe ultiliza o padrão de projetos Data Transfer Object (DTO)
 * o transporte de dados entre diferentes componentes.
 * 
 */
public class EnderecoDto {

	private Long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private String enderecoPrincipal;

	public EnderecoDto() {
		super();
	}

	public EnderecoDto(Long id, String logradouro, String cep, String numero, String cidade, String enderecoPrincipal) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(String enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}
	
	/**
	 * Convertendo classe EnderecoDto para classe Endereco.
	 *
	 * @param Classe dto.
	 * @return Uma classe do tipo Endereco.
	 */
	public static Endereco toEndereco(EnderecoDto dto) {
		return new Endereco(
				dto.getId(), 
				dto.getLogradouro(), 
				dto.getCep(), 
				dto.getNumero(), 
				dto.getCidade(),
				dto.getEnderecoPrincipal());
	}
	
	/**
	 * Convertendo entidade Endereco para classe EnderecoDto.
	 *
	 * @param Classe entidade.
	 * @return Uma classe do tipo EnderecoDto.
	 */
	public static EnderecoDto fromEndereco(Endereco entity) {
		return new EnderecoDto(
				entity.getId(), 
				entity.getLogradouro(), 
				entity.getCep(), 
				entity.getNumero(),
				entity.getCidade(), 
				entity.getEnderecoPrincipal());
	}

	/**
	 * Este método converte uma lista do objeto EnderecoDto para uma 
	 * lista da entidade Enderecos.
	 *
	 * @param Lista de Dto.
	 * @return Uma lista do tipo Endereco.
	 */
	public static List<Endereco> toConvertList(List<EnderecoDto> enderecos) {
		return enderecos
				.stream()
				.map((e -> EnderecoDto.toEndereco(e)))
				.collect(Collectors.toList());
	}

	/**
	 * Este método converte uma lista do objeto Endereco para uma 
	 * lista de Enderecos em Dto.
	 *
	 * @param Lista de entidade.
	 * @return Uma lista do tipo Endereco.
	 */
	public static List<EnderecoDto> fromConvertList(List<Endereco> enderecos) {
		return enderecos
				.stream()
				.map((e -> EnderecoDto.fromEndereco(e)))
				.collect(Collectors.toList());
	}

}
