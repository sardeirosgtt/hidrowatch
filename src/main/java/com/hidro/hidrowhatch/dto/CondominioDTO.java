package com.hidro.hidrowhatch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CondominioDTO {
	
	private Long id;
	private String nome;
	private String cnpj;
	private String email;
	private String endereco;
	
	
}
