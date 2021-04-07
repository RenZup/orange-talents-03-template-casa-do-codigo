package br.com.zupacademy.renzo.casadocodigo.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.zupacademy.renzo.casadocodigo.compartilhado.CpfOuCnpj;
import br.com.zupacademy.renzo.casadocodigo.compartilhado.ExistingId;
import br.com.zupacademy.renzo.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.renzo.casadocodigo.paisestado.estado.Estado;
import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;

public class ClienteRequestForm {
	
	private @NotBlank  String nome;
	private @NotBlank String sobrenome;
	private @NotBlank @Email String email;
	private @NotNull @CpfOuCnpj 
	@Pattern(regexp = "^([0-9]{11}|[0-9]{14})$",message = "Digite um CPF ou CNPJ valido, sem caracteres especiais")
	@UniqueValue(domainClass = Cliente.class,fieldName = "documento")
	String documento; // Necessária validação com @CPF ou @CNPJ
	private @NotBlank String endereco;
	private @NotBlank String complemento;
	private @NotBlank String cidade;
	private @NotNull @ExistingId(domainClass = Pais.class,fieldName = "id") Long paisId;
	private @ExistingId(domainClass = Estado.class,fieldName = "id") Long estadoId;
	private @NotNull @Pattern(regexp = "^([0-9]{10}|[0-9]{11})$",message = "Favor digitar o numero com DDD")
	String telefone;
	private @NotNull Integer cep;
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
	public Long getPaisId() {
		return paisId;
	}
	public Long getEstadoId() {
		return estadoId;
	}
	public String getTelefone() {
		return telefone;
	}
	public Integer getCep() {
		return cep;
	}
	@Override
	public String toString() {
		return "ClienteRequestForm [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", paisId=" + paisId + ", estadoId=" + estadoId + ", telefone=" + telefone + ", cep=" + cep + "]";
	}
	
	
}
