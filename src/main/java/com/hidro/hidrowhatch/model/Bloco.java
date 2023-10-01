package com.hidro.hidrowhatch.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bloco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private String numero;
	@Nonnull
	private int qtdApt;
	@Nonnull
	private int qtdAndar;
	
}
