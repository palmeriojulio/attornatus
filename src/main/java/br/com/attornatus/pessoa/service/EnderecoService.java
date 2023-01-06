package br.com.attornatus.pessoa.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.dao.EnderecoRepository;
import br.com.attornatus.pessoa.dao.PessoaRepository;
import br.com.attornatus.pessoa.dto.EnderecoDto;

@Service
public class EnderecoService {
	
	final EnderecoRepository enderecoRepository;
	final PessoaRepository pessoaRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
		this.enderecoRepository = enderecoRepository;
		this.pessoaRepository = pessoaRepository;
	}	
	
	public EnderecoDto listarEnderecos(EnderecoDto dto) {		
		try {
			var endereco = enderecoRepository.save(EnderecoDto.toEndereco(dto));
			return null;
		} catch (RuntimeException e) {
			return null;
		}
	}

	
}
