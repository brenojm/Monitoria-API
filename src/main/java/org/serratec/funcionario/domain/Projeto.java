package org.serratec.funcionario.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "Nome não pode ser vazio.")
	private String Nome;
	
	@NotBlank(message = "Descrição não pode ser vazia.")
	private String Descricao;
	
	@ManyToMany(mappedBy = "projetos")
	@JsonBackReference
	private List<Funcionario> funcionarios;
	
	
	public Projeto() {
		super();
	}

	public Projeto(Long id, @NotBlank(message = "Nome não pode ser vazio.") String nome,
			@NotBlank(message = "Descrição não pode ser vazia.") String descricao, List<Funcionario> funcionarios) {
		super();
		Id = id;
		Nome = nome;
		Descricao = descricao;
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

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
}
