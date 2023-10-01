package com.hidro.hidrowhatch.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Condominios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private String nome;
	
	@Nonnull
	private String cnpj;
	
	@Nonnull
	private String email;
	
	@Nonnull
	private String endereco;

	@OneToMany(mappedBy = "condominios")
    private List<Bloco> blocos;
}
