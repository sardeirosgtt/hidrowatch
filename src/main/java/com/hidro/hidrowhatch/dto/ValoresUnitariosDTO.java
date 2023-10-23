package com.hidro.hidrowhatch.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
public class ValoresUnitariosDTO {
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
