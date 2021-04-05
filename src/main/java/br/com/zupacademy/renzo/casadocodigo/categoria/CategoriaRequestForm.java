package br.com.zupacademy.renzo.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.renzo.casadocodigo.compartilhado.UniqueValue;

public class CategoriaRequestForm {
	@NotBlank
	@UniqueValue(domainClass = Categoria.class,fieldName = "nome")
	private String nome;
	
	@Deprecated
	public CategoriaRequestForm(){}
	
	public CategoriaRequestForm(Categoria categoria) {
		this.nome = categoria.getNome();
	}
	
	public String getNome() {
		return nome;
	}
	
	
}
