package com.hidro.hidrowhatch.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condominios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	@Nonnull
	private String nome;
	
	@NotNull
	@NotEmpty
	@Nonnull
	private String cnpj;
	
	@NotNull
	@NotEmpty
	@Nonnull
	private String email;
	
	@NotNull
	@NotEmpty
	@Nonnull
	private String endereco;

	@NotNull
	@NotEmpty
	@OneToMany(mappedBy = "condominios")
    private List<Bloco> blocos;
}
