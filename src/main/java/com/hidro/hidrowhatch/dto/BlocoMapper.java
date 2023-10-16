package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hidro.hidrowhatch.model.Bloco;

public class BlocoMapper {
	public static BlocoDTO toBlocoDTO(Bloco bloco) {
	    BlocoDTO dto =  new BlocoDTO();
	    		dto.setId(bloco.getId()); 
	    		dto.setNumero(bloco.getNumero());	
	    		dto.setQtdAndar(bloco.getQtdAndar());
	    		dto.setCondominioDTO(CondominioMapper.toCondominioDTO(bloco.getCondominios()));
	    		return dto;
	}

	public static List<BlocoDTO> toBlocoDTOList(List<Bloco> blocos) {
	    return blocos.stream().map(BlocoMapper::toBlocoDTO).collect(Collectors.toList());
	}
}






