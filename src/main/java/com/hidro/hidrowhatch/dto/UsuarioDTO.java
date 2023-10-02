package com.hidro.hidrowhatch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
public class UsuarioDTO {
	private Long id;
    private String cpf;
    private String nome;
    private String email;
}
