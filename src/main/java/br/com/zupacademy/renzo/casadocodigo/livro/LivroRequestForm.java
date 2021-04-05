package br.com.zupacademy.renzo.casadocodigo.livro;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraintvalidators.RegexpURLValidator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.renzo.casadocodigo.autor.Autor;
import br.com.zupacademy.renzo.casadocodigo.categoria.Categoria;
import br.com.zupacademy.renzo.casadocodigo.compartilhado.ExistingId;
import br.com.zupacademy.renzo.casadocodigo.compartilhado.UniqueValue;

public class LivroRequestForm {
	
	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank @Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(value = 20)
	private Double preco;
	
	@Min(value = 100)
	private Integer numeroPaginas;
	
	@UniqueValue(domainClass = Livro.class,fieldName = "isbn")
	@ISBN
	@Pattern(regexp = "^([0-9]{13})$",message = "Formato Invalido. Esperando 13 numeros, sem outros caracteres")
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy",shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@ExistingId(domainClass = Categoria.class,fieldName = "id")
	private Long categoriaId;
	
	@NotNull
	@ExistingId(domainClass = Autor.class,fieldName = "id")
	private Long autorId;
	
	@Deprecated
	public LivroRequestForm() {}
	
	
	public LivroRequestForm(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) Double preco, @Min(100) Integer numeroPaginas, @ISBN String isbn,
			@Future LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}



	public Livro toLivro(EntityManager em) {
		@NotNull Categoria categoria = em.find(Categoria.class, categoriaId);
		@NotNull Autor autor = em.find(Autor.class, autorId);
		Livro livro = new Livro(titulo,resumo,sumario,preco,numeroPaginas,isbn,dataPublicacao,categoria,autor);
		return livro;
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
	public Long getCategoriaId() {
		return categoriaId;
	}
	public Long getAutorId() {
		return autorId;
	}
		
	
}
