package com.hidro.hidrowhatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double valor;

    @NotNull
    private String dataConsumo;
    
    
    private Double leituraAnterior;

    
    private Double leituraAtual;
    
    
    private Double ValorReal;

    @ManyToOne
    @JoinColumn(name = "hidrometro_id")
    @NotNull
    private Hidrometro hidrometro;
}
