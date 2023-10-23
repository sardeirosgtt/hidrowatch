package com.hidro.hidrowhatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.ValoresUnitarios;
import com.hidro.hidrowhatch.repository.ValoresUnitariosRepository;

@Service
public class ValoresUnitariosService {

	@Autowired
	private final ValoresUnitariosRepository valoresRepository;
	
	public ValoresUnitariosService(ValoresUnitariosRepository valoresRepository) {
		 this.valoresRepository = valoresRepository;
	}
	
	@org.springframework.transaction.annotation.Transactional
    public ValoresUnitarios salvar(ValoresUnitarios novoValor) {
        return valoresRepository.save(novoValor);
    }
	
	

}
