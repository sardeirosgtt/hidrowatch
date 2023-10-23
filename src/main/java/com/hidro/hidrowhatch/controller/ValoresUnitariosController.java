package com.hidro.hidrowhatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hidro.hidrowhatch.model.ValoresUnitarios;
import com.hidro.hidrowhatch.service.ValoresUnitariosService;

@RestController
@RequestMapping("/valoresUnitarios")
public class ValoresUnitariosController {
	
	@Autowired
	private final ValoresUnitariosService service;
	
	public ValoresUnitariosController (ValoresUnitariosService service) {
		this.service = service;
	}
	
	@PostMapping
    public ValoresUnitarios salvar(@RequestBody ValoresUnitarios valoresUnitarios) {
        return service.salvar(valoresUnitarios);
    }

}
