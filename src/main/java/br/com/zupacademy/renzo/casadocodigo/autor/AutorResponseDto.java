package br.com.zupacademy.renzo.casadocodigo.autor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AutorResponseDto {
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataRegistro;
	
	public AutorResponseDto(Autor autor) {
		this.id=autor.getId();
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

	public Long getId() {
		return id;
	}
	
	
	
}
