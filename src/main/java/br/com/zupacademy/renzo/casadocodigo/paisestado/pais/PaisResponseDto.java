package br.com.zupacademy.renzo.casadocodigo.paisestado.pais;

import java.util.List;
import java.util.stream.Collectors;

public class PaisResponseDto {
	private Long id;
	private String nome;
	
	public PaisResponseDto(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
		
		
	}
	
	public static List<PaisResponseDto> toDto(List<Pais> paises) {
		return paises.stream().map(PaisResponseDto::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
}
