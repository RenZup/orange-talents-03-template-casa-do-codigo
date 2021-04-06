package br.com.zupacademy.renzo.casadocodigo.paisestado.pais;

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
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaisResponseDto> cadastrar(@RequestBody @Valid PaisRequestForm form, UriComponentsBuilder uriBuilder){
		Pais pais = new Pais(form);
		URI uri = uriBuilder.path("paises/{id}").buildAndExpand(pais.getId()).toUri();
		paisRepository.save(pais);
		
		PaisResponseDto dto = new PaisResponseDto(pais);
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping
	public List<PaisResponseDto> listar(){
		List<Pais> lista = paisRepository.findAll();
		
		return PaisResponseDto.toDto(lista);
	}
}
