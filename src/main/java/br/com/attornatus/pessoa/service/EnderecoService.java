package br.com.attornatus.pessoa.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.dao.EnderecoRepository;
import br.com.attornatus.pessoa.dao.PessoaRepository;

@Service
public class EnderecoService {
	
	final EnderecoRepository enderecoRepository;
	final PessoaRepository pessoaRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
		this.enderecoRepository = enderecoRepository;
		this.pessoaRepository = pessoaRepository;
	}

	public Object listarEnderecosPessoaById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
