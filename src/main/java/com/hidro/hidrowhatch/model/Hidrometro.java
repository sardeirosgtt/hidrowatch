package com.hidro.hidrowhatch.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class Hidrometro {

    @Id
    @GeneratedValue
    private Long id;

    private String numero;

    private Double leitura;
    
    private LocalDateTime dataConsumo;


    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;
    
    @OneToMany(mappedBy = "hidrometro")
    private List<Leitura> leituras;
}
