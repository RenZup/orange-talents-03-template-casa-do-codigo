package br.com.zupacademy.renzo.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.renzo.casadocodigo.compartilhado.UniqueValue;

public class AutorForm {
	@NotBlank
	private String nome;
	@NotBlank
	@Email @UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public AutorForm(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "AutorFormDto [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}
	
	public Autor toAutor() {
		return new Autor(nome, email, descricao);
	}
	
	
	
	
	
}
