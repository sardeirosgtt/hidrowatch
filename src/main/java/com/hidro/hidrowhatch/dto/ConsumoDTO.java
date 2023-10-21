package com.hidro.hidrowhatch.dto;

import java.time.LocalDateTime;

import com.hidro.hidrowhatch.model.Apartamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoDTO {

	private Long id;
	private Double valor;
	private String dataConsumo;
	private Double leituraAnterior;  
    private Double leituraAtual;
	private ApartamentoDTO apartamento;
}
