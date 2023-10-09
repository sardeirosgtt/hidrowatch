package com.hidro.hidrowhatch.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Hidrometro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
	@NotEmpty
    private String numero;
    
    @NotNull
	@NotEmpty
    @Enumerated(EnumType.STRING)
    private TipoHidrometro tipo;


    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;
    
  
    @OneToMany(mappedBy = "hidrometro")
    private List<Leitura> leituras;
}
