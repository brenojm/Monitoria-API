package org.serratec.funcionario.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "A rua não pode ser vazia.")
	private String Rua;
	
	@NotBlank(message = "O bairro não pode ser vazio.")
	private String Bairro;
	
	@NotBlank(message = "A cidade não pode ser vazia.")
	private String Cidade;
	
	@OneToOne(mappedBy = "endereco")
	@JsonBackReference
	private Funcionario funcionario;

	
	
	public Endereco() {
		super();
	}

	public Endereco(Long id, @NotBlank(message = "A rua não pode ser vazia.") String rua,
			@NotBlank(message = "O bairro não pode ser vazio.") String bairro,
			@NotBlank(message = "A cidade não pode ser vazia.") String cidade, Funcionario funcionario) {
		super();
		Id = id;
		Rua = rua;
		Bairro = bairro;
		Cidade = cidade;
		this.funcionario = funcionario;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}
