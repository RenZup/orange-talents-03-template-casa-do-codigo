package br.com.zupacademy.renzo.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorDto {

	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataRegistro = LocalDateTime.now();
	
	public AutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.dataRegistro= autor.getDataRegistro();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	
	
	
}
