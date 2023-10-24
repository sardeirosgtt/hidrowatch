package com.hidro.hidrowhatch.model;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelUsuarioApartamento {
	
	@EmbeddedId
	private RelUsuarioApartamentoId id;
	
	private LocalDate dataCadastro;
	
	private LocalDate dataExclusão;
}
