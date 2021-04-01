package br.com.zupacademy.renzo.casadocodigo.autor;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.renzo.casadocodigo.erros.EmailDuplicadoException;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder) throws EmailDuplicadoException{
		Autor autor = form.toAutor();
		
		Optional<Autor> autorEmail = autorRepository.findByEmail(autor.getEmail());
		if (autorEmail.isPresent()) throw new EmailDuplicadoException();
	
		autorRepository.save(autor);
		
		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AutorDto(autor));
		
	}
	@GetMapping
	public List<AutorDto> listar(){
		List<Autor> lista = autorRepository.findAll();
		
		return Autor.toDtoList(lista);
	}
		
}
