package br.com.zupacademy.renzo.casadocodigo.autor;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<AutorResponseDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder){
		
		Autor autor = form.toAutor();
		autorRepository.save(autor);
		
		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new AutorResponseDto(autor));
		
	}
	@GetMapping
	public List<AutorResponseDto> listar(){
		List<Autor> lista = autorRepository.findAll();
		
		return Autor.toDtoList(lista);
	}
		
}
