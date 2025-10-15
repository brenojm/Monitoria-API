package org.serratec.funcionario.controller;

import java.util.List;

import org.serratec.funcionario.domain.Departamento;
import org.serratec.funcionario.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@PostMapping
	public ResponseEntity<Departamento> criarDepartamento(@Valid @RequestBody Departamento departamento) {
		Departamento departamentoCriado = departamentoRepository.save(departamento);
		return new ResponseEntity<>(departamentoCriado, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Departamento>> listarDepartamentos() {
		return ResponseEntity.ok(departamentoRepository.findAll());
	}
	
	
}
