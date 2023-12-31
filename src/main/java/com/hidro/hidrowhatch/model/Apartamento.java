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
	
	private String numero;
	
	@NotNull
    private Integer andar;


    @ManyToOne
    @JoinColumn(name = "bloco_id")
    private Bloco bloco;
    
	
    @ManyToOne()
    @JoinColumn(name = "usuario_id", nullable = true)
    @JsonBackReference
    private Usuario usuario;
    

    @OneToMany(mappedBy = "apartamento")
    private List<Hidrometro> hidrometros;
	
}
