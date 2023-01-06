package br.com.attornatus.pessoa.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.dao.EnderecoRepository;
import br.com.attornatus.pessoa.dto.EnderecoDto;

@Service
public class EnderecoService {
	
	final EnderecoRepository enderecoRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public EnderecoDto salvarEndereco(EnderecoDto dto) {
		try {
			var endereco = enderecoRepository.save(EnderecoDto.toEndereco(dto));
			return null;
		} catch (RuntimeException e) {
			return null;
		}
	}

}
