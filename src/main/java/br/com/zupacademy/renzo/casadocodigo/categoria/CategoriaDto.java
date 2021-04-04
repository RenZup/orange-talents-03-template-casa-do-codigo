package br.com.zupacademy.renzo.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.renzo.casadocodigo.compartilhado.UniqueValue;

public class CategoriaDto {
	@NotBlank
	@UniqueValue(domainClass = Categoria.class,fieldName = "nome")
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
