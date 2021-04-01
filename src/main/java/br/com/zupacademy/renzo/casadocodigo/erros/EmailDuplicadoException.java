package br.com.zupacademy.renzo.casadocodigo.erros;

public class EmailDuplicadoException extends Exception {
	public EmailDuplicadoException() {
		super("Email já cadastrado");
	}
}
