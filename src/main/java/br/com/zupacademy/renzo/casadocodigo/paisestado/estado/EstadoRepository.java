package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query("Select e FROM Estado e WHERE nome = :nome AND id_pais = :idPais")
	Optional<Estado> existsEstadoComEsseNomeNoPais(String nome, Long idPais);
	
	
}
