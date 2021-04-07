package br.com.zupacademy.renzo.casadocodigo.cliente;

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

import br.com.zupacademy.renzo.casadocodigo.erros.ErrorDto;
import br.com.zupacademy.renzo.casadocodigo.paisestado.estado.Estado;
import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequestForm form, UriComponentsBuilder uriBuilder){
		
		Pais pais = em.find(Pais.class, form.getPaisId());
		Estado estado = null;
		if(form.getEstadoId() != null) {
			estado = em.find(Estado.class, form.getEstadoId());
			if(estado.getPais() != pais) {
				return ResponseEntity.badRequest().body(new ErrorDto("estado", "Estado não existe no pais " + pais.getNome()));
			}
		}
				
		Cliente cliente = new Cliente(form,pais,estado);
		
		em.persist(cliente);
		
		ClienteResponseDto dto = new ClienteResponseDto(cliente);
		
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
		
}

