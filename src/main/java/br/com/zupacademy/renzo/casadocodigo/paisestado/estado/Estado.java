package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;

@Table(
		   name = "estado", 
		   uniqueConstraints = {@UniqueConstraint(columnNames = {"nome", "id_pais"})}
		)
@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne
	@JoinColumn(nullable=false,name = "id_pais")
	private Pais pais;
	@NotBlank
	@Column(nullable=false) // Unico para o mesmo país
	private String nome;
	
	
	
	
	public Estado() {
	}
	
	public Estado(@Valid EstadoRequestForm form, Pais pais) {
		this.nome = form.getNome();
		this.pais = pais;
	}
	public Long getId() {
		return id;
	}
	public Pais getPais() {
		return pais;
	}
	public String getNome() {
		return nome;
	}
	
	
}
