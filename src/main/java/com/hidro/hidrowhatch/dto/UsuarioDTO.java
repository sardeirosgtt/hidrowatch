package com.hidro.hidrowhatch.dto;

import com.hidro.hidrowhatch.model.UsuarioRole;

import lombok.AllArgsConstructor;
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
    private String password;
    private UsuarioRole role;
}
