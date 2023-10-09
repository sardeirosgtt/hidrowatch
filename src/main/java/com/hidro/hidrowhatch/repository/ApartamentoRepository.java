package com.hidro.hidrowhatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.model.Hidrometro;
import com.hidro.hidrowhatch.model.Leitura;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

	@Query("SELECT a FROM Apartamento a WHERE a.bloco.condominios.id = :condominioId")
    List<Apartamento> findByCondominioId(Long condominioId);
	
	List<Apartamento> findByUsuarioId(Long usuarioId);

	@Query("SELECT a FROM Apartamento a WHERE a.bloco.id = :blocoId")
	List<Apartamento> findByBlocoId(Long blocoId);
}
