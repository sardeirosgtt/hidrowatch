package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hidro.hidrowhatch.model.Bloco;
import com.hidro.hidrowhatch.model.Leitura;

public class LeituraMapper {
	public static LeituraDto toLeituraDto(Leitura leitura) {
	    return new LeituraDto(leitura.getId(), leitura.getValor(), leitura.getDataLeitura(), leitura.getHidrometro());
	}

	public static List<LeituraDto> toLeituraList(List<Leitura> leitura) {
	    return leitura.stream().map(LeituraMapper::toLeituraDto).collect(Collectors.toList());
	}
}






