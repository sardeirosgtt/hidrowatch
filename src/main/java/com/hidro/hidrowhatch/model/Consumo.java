package com.hidro.hidrowhatch.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
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
	@NotEmpty
    private Double valor;

    @NotNull
	@NotEmpty
    private LocalDateTime dataConsumo;


    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;
}
