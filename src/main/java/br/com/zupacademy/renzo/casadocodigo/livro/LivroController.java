package br.com.zupacademy.renzo.casadocodigo.livro;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	LivroRepository livroRepository;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<LivroRequestForm> criar(@RequestBody @Valid LivroRequestForm form, UriComponentsBuilder uriBuilder){
		Livro livro = form.toLivro(em);
		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		
		em.persist(livro);
		
		return ResponseEntity.created(uri).body(form);
	}
	
	@GetMapping
	public List<LivroResponseDto> listar(){
		List<Livro> lista = livroRepository.findAll();
		return Livro.toDtoList(lista);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<LivroResponseDto> listarPorId(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		
		if(livro.isEmpty()) return ResponseEntity.notFound().build();
		
		LivroResponseDto dto = new LivroResponseDto(livro.get());
		return ResponseEntity.ok().body(dto);
	}
}
