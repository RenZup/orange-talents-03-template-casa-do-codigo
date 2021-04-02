package br.com.zupacademy.renzo.casadocodigo.erros;

public class CategoriaDuplicadaException extends Exception {
	public CategoriaDuplicadaException() {
		super("Categoria duplicada");
	}
}
