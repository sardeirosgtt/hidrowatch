package com.hidro.hidrowhatch.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Leitura {

    @Id
    @GeneratedValue
    private Long id;

    private Double valor;

    private LocalDateTime dataLeitura;

    @ManyToOne
    @JoinColumn(name = "hidrometro_id")
    private Hidrometro hidrometro;
}
