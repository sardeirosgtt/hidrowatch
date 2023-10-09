package com.hidro.hidrowhatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarCondominioRequest {


	    private String nome;
	    private String cnpj;
	    private String email;
	    private String endereco;
	    private int numeroDeBlocos;
	    private int numeroDeAndaresPorBloco;
	    private int numeroDeApartamentosPorAndar;


}