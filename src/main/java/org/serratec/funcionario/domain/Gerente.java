package org.serratec.funcionario.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue("GERENTE")
public class Gerente extends Funcionario {
	
	@NotBlank(message = "O setor é obrigatório")
	private String Setor;

	public String getSetor() {
		return Setor;
	}

	public void setSetor(String setor) {
		Setor = setor;
	}

	public Gerente(@NotBlank(message = "O setor é obrigatório") String setor) {
		super();
		Setor = setor;
	}

	public Gerente() {
		super();
	}
	
	
}
