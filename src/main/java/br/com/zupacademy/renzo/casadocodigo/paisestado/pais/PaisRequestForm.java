package br.com.zupacademy.renzo.casadocodigo.paisestado.pais;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.renzo.casadocodigo.compartilhado.UniqueValue;

public class PaisRequestForm {
	@NotBlank @UniqueValue(domainClass = Pais.class,fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}
	
	
}
