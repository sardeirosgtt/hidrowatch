package com.hidro.hidrowhatch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	@NotNull
	@NotEmpty
	@Id
	private String cpf;
	
	@Nonnull
	@NotNull
	@NotEmpty
	private String nome;
	
	@Nonnull
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
    private List<Apartamento> apartamentos;
	
	
	
}
