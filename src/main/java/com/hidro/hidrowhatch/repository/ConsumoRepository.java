package com.hidro.hidrowhatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hidro.hidrowhatch.model.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
}
