package br.com.attornatus.pessoa.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoa.service.EnderecoService;

@RestController
@RequestMapping("/gerenciar")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnderecoResource {
	
	final EnderecoService enderecoService;

	public EnderecoResource(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	@GetMapping("/endereco/{id}")
	public ResponseEntity<Object> listarEnderecosPessoa(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarEnderecosPessoaById(id));
	}
	

}
