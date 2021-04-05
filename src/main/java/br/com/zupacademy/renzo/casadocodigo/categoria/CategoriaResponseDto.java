package br.com.zupacademy.renzo.casadocodigo.categoria;

public class CategoriaResponseDto {
	private Long id;
	private String nome;
	
	@Deprecated
	public CategoriaResponseDto(){}
	
	public CategoriaResponseDto(Categoria categoria) {
		this.nome = categoria.getNome();
		this.id = categoria.getId();
	}
	
	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}
	
	
}

