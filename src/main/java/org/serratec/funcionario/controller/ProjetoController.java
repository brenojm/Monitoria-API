package org.serratec.funcionario.controller;

import java.net.URI;
import java.util.List;

import org.serratec.funcionario.domain.Projeto;
import org.serratec.funcionario.domain.dto.ProjetoPostDto;
import org.serratec.funcionario.exception.RecursoNaoEncontradoException;
import org.serratec.funcionario.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@PostMapping
	public ResponseEntity<Projeto> criarProjeto(@Valid @RequestBody ProjetoPostDto projetoDto) {
		Projeto projeto = new Projeto();
		projeto.setNome(projetoDto.Nome);
		projeto.setDescricao(projetoDto.Descricao);
		Projeto projetoNovo = projetoRepository.save(projeto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(projetoNovo.getId()).toUri();
		return ResponseEntity.created(uri).body(projetoNovo);
	}
	
	@GetMapping
	public ResponseEntity<List<Projeto>> listarProjetos() {
		return ResponseEntity.ok(projetoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> encontrarProjetoPorId(@PathVariable Long id) {
		Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Projeto com o Id " + id + " não foi encontrado."));
		return ResponseEntity.ok(projeto);
	}
	
}
