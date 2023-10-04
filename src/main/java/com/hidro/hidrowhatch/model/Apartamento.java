package com.hidro.hidrowhatch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String numero;
	
	@NotNull
	@NotEmpty
    private Integer andar;

	@NotNull
	@NotEmpty
    @ManyToOne
    @JoinColumn(name = "bloco_id")
    private Bloco bloco;
    
	@NotNull
	@NotEmpty
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;
    
	@NotNull
	@NotEmpty
    @OneToMany(mappedBy = "apartamento")
    private List<Hidrometro> hidrometros;
	
}
