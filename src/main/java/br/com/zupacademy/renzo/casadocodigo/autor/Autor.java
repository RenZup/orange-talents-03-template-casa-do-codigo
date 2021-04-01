package br.com.zupacademy.renzo.casadocodigo.autor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, unique=true)
	private String email;
	@Column(nullable = false,length = 400)
	private String descricao;
	@Column(nullable = false)
	private LocalDateTime dataRegistro = LocalDateTime.now();
	
	

	public Autor() {}
	
	public Autor(String nome, String email, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", dataRegistro="
				+ dataRegistro + "]";
	}

	public Long getId() {
		return id;
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
	
	public static List<AutorDto> toDtoList(List<Autor> autores){
		
		return autores.stream().map(AutorDto::new).collect(Collectors.toList());
	}
	
	
}
