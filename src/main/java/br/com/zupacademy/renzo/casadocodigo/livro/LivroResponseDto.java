package br.com.zupacademy.renzo.casadocodigo.livro;

import java.time.LocalDate;

import br.com.zupacademy.renzo.casadocodigo.autor.AutorResponseDto;
import br.com.zupacademy.renzo.casadocodigo.categoria.CategoriaResponseDto;

public class LivroResponseDto {
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private CategoriaResponseDto categoria;
	private AutorResponseDto autor;
	@Deprecated
	public LivroResponseDto() {
		
	}
	
	public LivroResponseDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario=livro.getSumario();
		this.preco=livro.getPreco();
		this.numeroPaginas=livro.getNumeroPaginas();
		this.isbn=livro.getIsbn();
		this.dataPublicacao=livro.getDataPublicacao();
		this.categoria = new CategoriaResponseDto(livro.getCategoria());
		this.autor = new AutorResponseDto(livro.getAutor());
		
	}


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

	public CategoriaResponseDto getCategoria() {
		return categoria;
	}

	public AutorResponseDto getAutor() {
		return autor;
	}



	
}
