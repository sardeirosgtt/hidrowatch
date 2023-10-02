package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hidro.hidrowhatch.model.Bloco;

public class BlocoMapper {
	public static BlocoDTO toBlocoDTO(Bloco bloco) {
	    return new BlocoDTO(bloco.getId(), bloco.getNumero(), bloco.getQtdAndar(), bloco.getCondominios().getId());
	}

	public static List<BlocoDTO> toBlocoDTOList(List<Bloco> blocos) {
	    return blocos.stream().map(BlocoMapper::toBlocoDTO).collect(Collectors.toList());
	}
}






