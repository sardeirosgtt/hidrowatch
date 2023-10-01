package com.hidro.hidrowhatch.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private String cpf;
	
	@Nonnull
	private String nome;
	
	@Nonnull
	private String email;
	
	@OneToMany(mappedBy = "usuario")
    private List<Apartamento> apartamentos;
	
	
	
}
