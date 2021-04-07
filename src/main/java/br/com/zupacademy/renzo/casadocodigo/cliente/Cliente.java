package br.com.zupacademy.renzo.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.zupacademy.renzo.casadocodigo.paisestado.estado.Estado;
import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;

@Entity
public class Cliente {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String sobrenome;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false, unique = true)
	private String documento; // Necessária validação com @CPF ou @CNPJ
	
	@Column(nullable=false)
	private String endereco;
	
	@Column(nullable=false)
	private String complemento;
	
	@Column(nullable=false)
	private String cidade;
	
	@ManyToOne
	@JoinColumn(nullable=false,name = "id_pais")
	private Pais pais;
	
	@ManyToOne
	private Estado estado;
	
	@Column(nullable=false)
	private String telefone;
	
	@Column(nullable=false)
	private Integer cep;
	
	@Deprecated
	/**
	 * Hibernate Only
	 * */
	public Cliente() {}
	
	public Cliente(ClienteRequestForm form, Pais pais, Estado estado) {
		nome = form.getNome();
		sobrenome = form.getSobrenome();
		email = form.getEmail();
		endereco = form.getEndereco();
		documento = form.getDocumento();
		complemento = form.getDocumento();
		cidade = form.getCidade();
		telefone = form.getTelefone();
		cep = form.getCep();
		this.pais = pais;
		this.estado = estado;
	}

	@Override
	public String toString() {
		if(estado == null)
			return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", documento="
					+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
					+ ", pais=" + pais.getNome() + ", telefone=" + telefone + ", cep=" + cep + "]";
		
		return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", pais=" + pais.getNome() + ", estado=" + estado.getNome() + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public Integer getCep() {
		return cep;
	}
	
	
}
