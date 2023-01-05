package br.com.attornatus.pessoa.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private LocalDate dataNascincimento;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> enderecos;

	public Pessoa() {
		super();		
	}

	public Pessoa(Long id, String nome, LocalDate dataNascincimento, List<Endereco> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascincimento = dataNascincimento;
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

	public LocalDate getDataNascincimento() {
		return dataNascincimento;
	}

	public void setDataNascincimento(LocalDate dataNascincimento) {
		this.dataNascincimento = dataNascincimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
