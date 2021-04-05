package br.com.zupacademy.renzo.casadocodigo.livro;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@PersistenceContext
	EntityManager em;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<LivroDto> criar(@RequestBody @Valid LivroDto form, UriComponentsBuilder uriBuilder){
		Livro livro = form.toLivro(em);
		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		
		em.persist(livro);
		
		return ResponseEntity.created(uri).body(form);
	}
}
