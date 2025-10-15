package org.serratec.funcionario.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "O nome não pode ser vazio")
	private String Nome;
	
	@OneToMany(mappedBy = "departamento")
	@JsonManagedReference
	private List<Funcionario> funcionarios;
	
	
	
	public Departamento() {
		super();
	}

	public Departamento(Long id, @NotBlank(message = "O nome não pode ser vazio") String nome,
			List<Funcionario> funcionarios) {
		super();
		Id = id;
		Nome = nome;
		this.funcionarios = funcionarios;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
