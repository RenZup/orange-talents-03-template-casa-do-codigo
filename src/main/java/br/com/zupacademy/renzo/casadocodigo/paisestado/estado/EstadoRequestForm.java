package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;

public class EstadoRequestForm {
	@NotBlank
	private String nome;
	@NotNull
	private Pais pais;
	
	public String getNome() {
		return nome;
	}
	public Pais getPais() {
		return pais;
	}
	
	
}
