package com.hidro.hidrowhatch.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValoresUnitarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double taxaFixa;
	
	private Double ValorFaixa1;
	
	private Double TamanhoFaixa1;
	
	private Double ValorFaixa2;

	private Double TamanhoFaixa2;
	
	private Double ValorFaixa3;
	
	private Double TamanhoFaixa3;
	
	private Double ValorFaixa4;
	
	private Double TamanhoFaixa4;
	
	private Double ValorFaixa5;
	
	private Double TamanhoFaixa5;
	
	private Double ValorFaixa6;
	
	private LocalDate dataInicial;
	
	private LocalDate dataFim;
	
}
