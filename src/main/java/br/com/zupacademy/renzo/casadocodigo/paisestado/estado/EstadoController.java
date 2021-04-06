package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.renzo.casadocodigo.erros.ErrorDto;
import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;
import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequestForm form, UriComponentsBuilder uriBuilder){
		
		Optional<Pais> pais = paisRepository.findById(form.getIdPais());
		Assert.notNull(pais,"País Invalido");
		
		Estado estado = new Estado(form,pais.get());
		
		if(estadoRepository.existsEstadoComEsseNomeNoPais(form.getNome(), form.getIdPais()).isPresent()) {
			return ResponseEntity.badRequest().body(new ErrorDto("nome", "Ja existe um estado com esse nome no país " + pais.get().getNome()+ "."));
		}
		
		estadoRepository.save(estado);
		
		EstadoResponseDto dto = new EstadoResponseDto(estado);
		
		URI uri = uriBuilder.path("/estados/{id}").buildAndExpand(estado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@GetMapping
	public List<EstadoResponseDto> listar(){
		List<Estado> lista = estadoRepository.findAll();
		return EstadoResponseDto.toDto(lista);
	}
}
