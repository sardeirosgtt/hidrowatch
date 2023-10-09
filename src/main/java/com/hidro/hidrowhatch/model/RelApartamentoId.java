package com.hidro.hidrowhatch.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;


@Embeddable
public class RelApartamentoId {
	
	@ManyToOne
	private Apartamento apartamento;
	
	@ManyToOne
	private Usuario usuario;

}
