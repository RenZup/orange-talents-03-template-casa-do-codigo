package br.com.zupacademy.renzo.casadocodigo.categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaDto {
	@NotNull
	@NotEmpty
	private String nome;
	
	@Deprecated
	public CategoriaDto(){}
	
	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}
	
	public String getNome() {
		return nome;
	}
	
	
}
