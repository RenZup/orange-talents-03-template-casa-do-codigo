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

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
		@Autowired
		CategoriaRepository catRepository;
	
		@PostMapping
		@Transactional
		public ResponseEntity<CategoriaResponseDto> criar(@RequestBody @Valid CategoriaRequestForm form, UriComponentsBuilder uriBuilder){
						
			Categoria categoria = new Categoria(form.getNome());
			URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
			
			catRepository.save(categoria);
			
			return ResponseEntity.created(uri).body(new CategoriaResponseDto(categoria));
		}
		
		@GetMapping
		public List<CategoriaResponseDto> listar(){
			
			List<Categoria> lista = catRepository.findAll();
			
			return Categoria.toDto(lista);
		}
		
		
}
