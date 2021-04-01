package br.com.zupacademy.renzo.casadocodigo.erros;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
		
		@Autowired
		private MessageSource messageSource;
	
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		private List<ErrorDto> handleValidationError(MethodArgumentNotValidException exception) {
			
			List<ErrorDto> errors = new ArrayList<>();
			
			List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
			fieldErrors.forEach(error -> {
				String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
				errors.add(new ErrorDto(error.getField(), message));
			});
			
			return errors;

		}
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(EmailDuplicadoException.class)
		private ErrorDto handleValidationError(EmailDuplicadoException exception) {
			return new ErrorDto("Email", exception.getMessage());
		}
		
}
