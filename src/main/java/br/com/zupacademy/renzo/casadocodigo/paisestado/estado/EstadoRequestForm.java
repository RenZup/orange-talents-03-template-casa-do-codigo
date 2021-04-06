package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.renzo.casadocodigo.compartilhado.ExistingId;
import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;

public class EstadoRequestForm {
	@NotBlank
	private String nome;
	@NotNull
	@ExistingId(domainClass = Pais.class,fieldName = "id")
	private Long  idPais;
	
	public String getNome() {
		return nome;
	}
	public Long getIdPais() {
		return idPais;
	}
	
	
}
