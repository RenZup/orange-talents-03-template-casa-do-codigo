package br.com.zupacademy.renzo.casadocodigo.livro;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.zupacademy.renzo.casadocodigo.autor.Autor;
import br.com.zupacademy.renzo.casadocodigo.categoria.Categoria;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false) // Lembra de adicionar o uniquevalue no dto
	private String titulo;
	
	@Column(nullable = false, length = 500)
	private String resumo;
	
	@Column(columnDefinition = "TEXT")
	private String sumario;
	
	@Column(nullable=false) // Adicionar @min no dto
	private Double preco;
	
	@Column(nullable=false) // Adicionar @min no dto
	private Integer numeroPaginas;
	
	@Column(nullable = false) // Adicionar UniqueValue no dto
	private String isbn;
	
	//Adicionar @Future no dto
	private LocalDate dataPublicacao;
	
	@ManyToOne
	@JoinColumn(name="id_categoria",nullable=false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="id_autor",nullable=false)
	private Autor autor;

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public Livro(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn,
			LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	@Deprecated
	public Livro() {}

	public static List<LivroResponseDto> toDtoList(List<Livro> lista) {
		return lista.stream().map(LivroResponseDto::new).collect(Collectors.toList());
	}
	
	
}
