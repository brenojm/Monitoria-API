package org.serratec.funcionario.controller;

import java.util.List;

import org.serratec.funcionario.domain.Funcionario;
import org.serratec.funcionario.domain.Gerente;
import org.serratec.funcionario.exception.RecursoNaoEncontradoException;
import org.serratec.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionarios")
	public ResponseEntity<List<Funcionario>> listarFuncionarios() {
		return ResponseEntity.ok(funcionarioRepository.findAll());
	}
	
	@GetMapping("/funcionarios/{id}")
	public ResponseEntity<Funcionario> listarFuncionarios(@PathVariable Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("O funcionario com ID " + id + " não foi encontrado."));
		return ResponseEntity.ok(funcionario);
	}
	
	@PostMapping("/funcionarios")
	public ResponseEntity<Funcionario> criarFuncionario(@Valid @RequestBody Funcionario funcionario) {
		Funcionario funcionarioCadastrado = funcionarioRepository.save(funcionario);
		return new ResponseEntity<>(funcionarioCadastrado, HttpStatus.CREATED);
	}
	
	@PostMapping("/gerente")
	public ResponseEntity<Gerente> criarGerente(@Valid @RequestBody Gerente gerente) {
		Gerente gerenteCadastrado = funcionarioRepository.save(gerente);
		return new ResponseEntity<>(gerenteCadastrado, HttpStatus.CREATED);
	}
}
