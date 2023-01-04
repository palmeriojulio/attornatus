package br.com.attornatus.pessoa.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.attornatus.pessoa.domain.Endereco;

/**
 * @author palmerio
 * 
 *         Essa classe ultiliza o padrão de projetos Data Transfer Object (DTO)
 *         o transporte de dados entre diferentes componentes.
 * 
 */
public class EnderecoDto {

	private long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private String enderecoPrincipal;
	private PessoaDto pessoa;

	public EnderecoDto() {
		super();
	}

	public EnderecoDto(long id, String logradouro, String cep, String numero, String cidade, String enderecoPrincipal,
			PessoaDto pessoa) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.enderecoPrincipal = enderecoPrincipal;
		this.pessoa = pessoa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public PessoaDto getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDto pessoa) {
		this.pessoa = pessoa;
	}

	/** Convertendo classe Endereco para classe EnderecoDto. */
	public static Endereco toEndereco(EnderecoDto dto) {
		return new Endereco(dto.getId(), dto.getLogradouro(), dto.getCep(), dto.getNumero(), dto.getCidade(),
				dto.getEnderecoPrincipal(), PessoaDto.toPessoa(dto.getPessoa()));
	}

	/** Convertendo classe EnderecoDto para classe Endereco. */
	public static EnderecoDto fromEndereco(Endereco entity) {
		return new EnderecoDto(entity.getId(), entity.getLogradouro(), entity.getCep(), entity.getNumero(),
				entity.getCidade(), entity.getEnderecoPrincipal(), PessoaDto.fromPessoa(entity.getPessoa()));
	}

	/**
	 * Este método converte uma lista do objeto Endereco para uma lista de Enderecos
	 * em Dto.
	 */
	public static List<Endereco> toConvertList(List<EnderecoDto> enderecos) {
		return enderecos.stream().map((e -> EnderecoDto.toEndereco(e))).collect(Collectors.toList());
	}

	/**
	 * Este método converte uma lista do objeto EnderecoDto para uma lista de
	 * Enderecos.
	 */
	public static List<EnderecoDto> fromConvertList(List<Endereco> enderecos) {
		return enderecos.stream().map((e -> EnderecoDto.fromEndereco(e))).collect(Collectors.toList());
	}

}
