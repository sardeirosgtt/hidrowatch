package com.hidro.hidrowhatch.dto;

import java.util.stream.Collectors;

import java.util.List;

import com.hidro.hidrowhatch.model.Hidrometro;

public class HidrometroMapper {

    public static HidrometroDTO toHidrometroDTO(Hidrometro hidrometro) {
         HidrometroDTO dto = new HidrometroDTO();
            dto.setId(hidrometro.getId());
            dto.setNumero(hidrometro.getNumero());
            dto.setTipo(hidrometro.getTipo());
            dto.setApartamento(ApartamentoMapper.toApartamentoDTO(hidrometro.getApartamento()));
            return dto;
        
    }

    public static List<HidrometroDTO> toHidrometroDTOList(List<Hidrometro> Hidrometro) {
        return Hidrometro.stream().map(HidrometroMapper::toHidrometroDTO).collect(Collectors.toList());
    }
}
