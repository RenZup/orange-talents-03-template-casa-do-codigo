package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.PaisResponseDto;

public class EstadoResponseDto {
	private Long id;
	private String nome;
	private PaisResponseDto pais;
	
	public EstadoResponseDto(Estado estado) {
		this.id = estado.getId();
		this.nome=estado.getNome();
		pais  = new PaisResponseDto(estado.getPais());
		
	}
	
	public String getNome() {
		return nome;
	}
	public PaisResponseDto getPais() {
		return pais;
	}

	public Long getId() {
		return id;
	}
	/**
	 * Transforma uma lista de Estado em uma lista de EstadoResponseDto
	 */
	public static List<EstadoResponseDto>toDto(List<Estado> estados){
		return estados.stream().map(EstadoResponseDto::new).collect(Collectors.toList());
	}
	
}
