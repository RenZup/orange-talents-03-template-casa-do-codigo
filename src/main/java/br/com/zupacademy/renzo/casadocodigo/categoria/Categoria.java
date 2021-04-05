package br.com.zupacademy.renzo.casadocodigo.categoria;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable =  false)
	private String nome;
	
	@Deprecated
	public Categoria() {}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	public static List<CategoriaResponseDto> toDto(List<Categoria> lista) {
		return lista.stream().map(CategoriaResponseDto::new).collect(Collectors.toList());
	}
	
	
	
}
