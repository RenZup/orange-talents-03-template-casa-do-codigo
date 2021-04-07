package br.com.zupacademy.renzo.casadocodigo.cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteResponseDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	private String nomePais;
	private String nomeEstado;
	private String telefone;
	private Integer cep;
	
	public ClienteResponseDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.email = cliente.getEmail();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.nomePais = cliente.getPais().getNome();
		
		if(cliente.getEstado()!=null) {
		this.nomeEstado = cliente.getEstado().getNome();}
		
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
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

	public String getNomePais() {
		return nomePais;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public Integer getCep() {
		return cep;
	}
	
	public static List<ClienteResponseDto> toDto (List<Cliente> clientes){
		return clientes.stream().map(ClienteResponseDto::new).collect(Collectors.toList());
	}
	
	
	@Override
	public String toString() {
		return "ClienteResponseDto [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", documento=" + documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade="
				+ cidade + ", nomePais=" + nomePais + ", nomeEstado=" + nomeEstado + ", telefone=" + telefone + ", cep="
				+ cep + "]";
	}
	
	
}
