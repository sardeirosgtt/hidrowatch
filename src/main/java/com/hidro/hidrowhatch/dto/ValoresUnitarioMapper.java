package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hidro.hidrowhatch.model.ValoresUnitarios;

@Component
public class ValoresUnitarioMapper {

	public static ValoresUnitariosDTO toValoresUnitariosDTO(ValoresUnitarios valores) {
		
		ValoresUnitariosDTO dto = new ValoresUnitariosDTO();
		dto.setTamanhoFaixa1(valores.getTamanhoFaixa1());
		dto.setTamanhoFaixa2(valores.getTamanhoFaixa2());
		dto.setTamanhoFaixa3(valores.getTamanhoFaixa3());
		dto.setTamanhoFaixa4(valores.getTamanhoFaixa4());
		dto.setTamanhoFaixa5(valores.getTamanhoFaixa5());
		dto.setValorFaixa1(valores.getValorFaixa1());
		dto.setValorFaixa2(valores.getValorFaixa2());
		dto.setValorFaixa3(valores.getValorFaixa3());
		dto.setValorFaixa4(valores.getValorFaixa4());
		dto.setValorFaixa5(valores.getValorFaixa5());
		dto.setValorFaixa6(valores.getValorFaixa6());
		dto.setDataInicial(valores.getDataInicial());
		dto.setDataFim(valores.getDataFim());
		
		return dto;
	}
	
	public static List<ValoresUnitariosDTO> toValoresunitariosDTOList(List<ValoresUnitarios> valores) {
        return valores.stream().map(ValoresUnitarioMapper::toValoresUnitariosDTO).collect(Collectors.toList());
    }
}
