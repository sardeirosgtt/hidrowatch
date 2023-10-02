package com.hidro.hidrowhatch.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bloco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private String numero;

	@Nonnull
	private int qtdAndar;
	
	@ManyToOne
    @JoinColumn(name = "condominio_id")
    private Condominios condominios;

    @OneToMany(mappedBy = "bloco")
    private List<Apartamento> apartamentos;
}
