package br.com.zupacademy.renzo.casadocodigo.categoria;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.renzo.casadocodigo.erros.CategoriaDuplicadaException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
		@Autowired
		CategoriaRepository catRepository;
	
		@PostMapping
		@Transactional
		public ResponseEntity<CategoriaDto> criar(@RequestBody @Valid CategoriaDto form, UriComponentsBuilder uriBuilder) throws CategoriaDuplicadaException{
			
			if(catRepository.existsByNome(form.getNome())) throw new CategoriaDuplicadaException();
			
			Categoria categoria = new Categoria(form.getNome());
			URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
			
			catRepository.save(categoria);
			
			return ResponseEntity.created(uri).body(form);
		}
		
		@GetMapping
		public List<CategoriaDto> listar(){
			
			List<Categoria> lista = catRepository.findAll();
			
			return Categoria.toDto(lista);
		}
		
		
}
