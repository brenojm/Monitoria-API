package org.serratec.funcionario.domain;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Id;
import org.serratec.funcionario.domain.enums.Turno;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_FUNCIONARIO", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("FUNCIONARIO")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long Id;
	
	@NotBlank(message = "O nome não pode ser vazio.")
	@Column(nullable = false)
	protected String Nome;
	
	@CPF(message = "O cpf é inválido")
	@Column(nullable = false, unique = true)
	protected String Cpf;
	
	@NotNull(message = "O salário é obrigatório.")
	@Positive(message = "O salário deve ser um valor positivo")
	@Column(nullable = false)
	protected Double Salario;
	
	@NotNull(message = "O turno não pode ser nulo")
	@Enumerated(EnumType.STRING)
	protected Turno Turno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	@JsonManagedReference
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	@JsonBackReference
	private Departamento departamento;
	
	
	@ManyToMany
	@JoinTable(
			name="funcionario_projeto",
			joinColumns = @JoinColumn(name = "funcionario_id"),
			inverseJoinColumns = @JoinColumn(name = "projeto_id")
	)
	private List<Projeto> projetos;

	public Funcionario() {
		super();
	}

	


	public Funcionario(Long id, @NotBlank(message = "O nome não pode ser vazio.") String nome,
			@CPF(message = "O cpf é inválido") String cpf,
			@NotNull(message = "O salário é obrigatório.") @Positive(message = "O salário deve ser um valor positivo") Double salario,
			org.serratec.funcionario.domain.enums.@NotNull(message = "O turno não pode ser nulo") Turno turno,
			Endereco endereco, Departamento departamento, List<Projeto> projetos) {
		super();
		Id = id;
		Nome = nome;
		Cpf = cpf;
		Salario = salario;
		Turno = turno;
		this.endereco = endereco;
		this.departamento = departamento;
		this.projetos = projetos;
	}




	public List<Projeto> getProjetos() {
		return projetos;
	}




	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}




	public Departamento getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public Double getSalario() {
		return Salario;
	}

	public void setSalario(Double salario) {
		Salario = salario;
	}

	public Turno getTurno() {
		return Turno;
	}

	public void setTurno(Turno turno) {
		Turno = turno;
	}
	
	
	
	
}
