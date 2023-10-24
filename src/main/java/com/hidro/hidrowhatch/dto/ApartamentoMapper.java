package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hidro.hidrowhatch.model.Apartamento;

public class ApartamentoMapper {
    public static ApartamentoDTO toApartamentoDTO(Apartamento apartamento) {
        ApartamentoDTO dto = new ApartamentoDTO();
        dto.setId(apartamento.getId());
        dto.setNumero(apartamento.getNumero());
        dto.setAndar(apartamento.getAndar());
        dto.setBloco(BlocoMapper.toBlocoDTO(apartamento.getBloco()));
        if(apartamento.getUsuario()!=null) {
        dto.setUsuario(UsuarioMapper.toUsuarioDTO(apartamento.getUsuario()));
        }else {
        	dto.setUsuario(null);
        }
        return dto;
    }

    public static List<ApartamentoDTO> toApartamentoDTOList(List<Apartamento> apartamentos) {
        return apartamentos.stream().map(ApartamentoMapper::toApartamentoDTO).collect(Collectors.toList());
    }
}
