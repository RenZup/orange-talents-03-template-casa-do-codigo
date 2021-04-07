package br.com.zupacademy.renzo.casadocodigo.compartilhado;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CpfOuCnpjValidator implements ConstraintValidator<CpfOuCnpj, Object> {
	
	public void initialize() {

	}
	
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		return (cpfValidator.isValid(value.toString(), context) || cnpjValidator.isValid(value.toString(), context));
	}
	
	


}