package com.hidro.hidrowhatch.model;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rel_apartamento")
public class RelApartamento {
	
	@EmbeddedId
	private RelApartamentoId id;
	
	private LocalDateTime dataCadastro;
	
	
	

}
