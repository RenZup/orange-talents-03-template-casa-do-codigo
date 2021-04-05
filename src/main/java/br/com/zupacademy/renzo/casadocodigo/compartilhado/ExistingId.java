package br.com.zupacademy.renzo.casadocodigo.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExistingIdValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistingId {

		String message() default "Id inexistente";
		
		Class<?>[] groups() default {};
		
		Class<? extends Payload>[] payload() default {};
		
		String fieldName();
		
		Class<?> domainClass();

}
