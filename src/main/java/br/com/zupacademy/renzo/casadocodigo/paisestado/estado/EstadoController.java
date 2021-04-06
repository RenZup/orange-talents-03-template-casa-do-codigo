package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	EstadoRepository estadoRepository;
	@PostMapping
	public ResponseEntity<EstadoResponseDto> cadastrar(@RequestBody EstadoRequestForm form){
		
		return null;
	}
}
