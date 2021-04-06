package br.com.zupacademy.renzo.casadocodigo.paisestado.pais;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.zupacademy.renzo.casadocodigo.paisestado.estado.Estado;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false) // adicionar UniqueValue no dto
	private String nome;
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;
	
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
	
	public List<Estado> getEstados() {
		return estados;
	}
	

	
}
