package br.com.zupacademy.renzo.casadocodigo.paisestado.pais;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.renzo.casadocodigo.paisestado.estado.Estado;

public class PaisResponseDto {
	private String nome;
	private List<Estado> estados;
	
	public PaisResponseDto(Pais pais) {
		this.nome = pais.getNome();
		this.estados = pais.getEstados();
	}
	
	public static List<PaisResponseDto> toDto(List<Pais> paises) {
		return paises.stream().map(PaisResponseDto::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public List<Estado> getEstados() {
		return estados;
	}
	
	
	
}
