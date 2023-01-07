package br.com.attornatus.pessoa.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoa.dto.PessoaDto;
import br.com.attornatus.pessoa.service.PessoaService;

@RestController
@RequestMapping("/gerenciar")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PessoaResource {
	
	final PessoaService pessoaService;

	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@PostMapping("/pessoa")
	public ResponseEntity<Object> salvarPessoa(@RequestBody PessoaDto pessoaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.criarPessoa(pessoaDto));		
	}
	
	@PutMapping("/pessoa")
	public ResponseEntity<Object> editarPessoa(@RequestBody PessoaDto pessoaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.editarPessoa(pessoaDto));
	}
	
	@GetMapping("/pessoas")
	public ResponseEntity<Object> listarPessoas() {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoas());
	}
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Object> consultarPessoa(@PathVariable(value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.consultarPessoa(id));
	}
	
	@PostMapping("/pessoa/endereco")
	public ResponseEntity<Object> criarEnderecoPessoa(@RequestBody PessoaDto pessoaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.criarEnderecoPessoa(pessoaDto));		
	}
	
	@GetMapping("/pessoa/endereco/{id}")
	public ResponseEntity<Object> listarEnderecosPessoaById(@PathVariable(value = "id") Long id) {
		
		if(pessoaService.listarEnderecosPessoaById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Pessoa ou endereco não cadastrados!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarEnderecosPessoaById(id));		
	}

}
