package com.hidro.hidrowhatch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDTO {
	
	    private Long id;
	    private String numero;
	    private int andar;
	    private BlocoDTO bloco;
	    private UsuarioDTO usuario; 
}
