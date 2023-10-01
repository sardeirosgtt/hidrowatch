package com.hidro.hidrowhatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hidro.hidrowhatch.model.Hidrometro;
import com.hidro.hidrowhatch.model.Leitura;

@Repository
public interface LeituraRepository extends JpaRepository<Leitura, Long> {
	
	@Query("SELECT l FROM Leitura l WHERE l.hidrometro = :hidrometro ORDER BY l.dataLeitura DESC")
    Leitura findLatestByHidrometro(@Param("hidrometro") Hidrometro hidrometro);
}
