package com.hidro.hidrowhatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hidro.hidrowhatch.model.Bloco;

public interface BlocoRepository extends JpaRepository<Bloco, Long> {
	
	List<Bloco> findByCondominiosId(Long idCondominio);
}
