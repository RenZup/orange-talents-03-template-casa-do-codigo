package br.com.zupacademy.renzo.casadocodigo.autor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorForm {
	@NotNull @NotEmpty
	private String nome;
	@Email
	private String email;
	@NotNull @NotEmpty
	private String descricao;
	
	public AutorForm(@NotNull @NotEmpty String nome, @Email String email, @Valid String descricao) {
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
