package com.hidro.hidrowhatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hidro.hidrowhatch.model.ValoresUnitarios;

@Repository
public interface ValoresUnitariosRepository extends JpaRepository<ValoresUnitarios, Long> {

	@Query("SELECT v FROM ValoresUnitarios v WHERE v.id = (SELECT MAX(id) FROM ValoresUnitarios)")
    ValoresUnitarios findEntityWithMaxId();
}
