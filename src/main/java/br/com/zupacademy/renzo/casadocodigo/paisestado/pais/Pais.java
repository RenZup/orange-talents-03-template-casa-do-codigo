package br.com.zupacademy.renzo.casadocodigo.paisestado.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false) // adicionar UniqueValue no dto
	private String nome;
	
	@Deprecated
	public Pais() {	}
	
	public Pais(PaisRequestForm form) {
		this.nome = form.getNome();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	

	
}
