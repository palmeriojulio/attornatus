package br.com.attornatus.pessoa.domain;

import java.time.LocalDate;

public class Pessoa {

	private long id;
	private String nome;
	private LocalDate dataNascincimento;

	private Endereco endereco;

	public Pessoa() {
		super();		
	}

	public Pessoa(long id, String nome, LocalDate dataNascincimento, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascincimento = dataNascincimento;
		this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	

}
