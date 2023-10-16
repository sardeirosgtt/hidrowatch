package com.hidro.hidrowhatch.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlocoDTO {
	
	private Long id;
	private String numero;
	private int qtdAndar;
	private CondominioDTO condominioDTO;
	
}
