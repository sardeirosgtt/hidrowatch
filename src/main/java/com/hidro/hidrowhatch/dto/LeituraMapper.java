package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hidro.hidrowhatch.model.Bloco;
import com.hidro.hidrowhatch.model.Leitura;

public class LeituraMapper {
	public static LeituraDto toLeituraDto(Leitura leitura) {
	    LeituraDto dto = new LeituraDto();
		dto.setId(leitura.getId());
		dto.setValor(leitura.getValor());
		dto.setDataLeitura(leitura.getDataLeitura());
		dto.setHidrometroDTO(HidrometroMapper.toHidrometroDTO(leitura.getHidrometro()));
		return dto; 
	}

	public static List<LeituraDto> toLeituraList(List<Leitura> leitura) {
	    return leitura.stream().map(LeituraMapper::toLeituraDto).collect(Collectors.toList());
	}
}






