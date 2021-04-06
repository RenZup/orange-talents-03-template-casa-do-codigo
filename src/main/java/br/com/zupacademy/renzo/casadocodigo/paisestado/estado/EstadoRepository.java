package br.com.zupacademy.renzo.casadocodigo.paisestado.estado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.renzo.casadocodigo.paisestado.pais.Pais;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	Boolean existsByNomeAndPais(String nome, Pais pais);
}
