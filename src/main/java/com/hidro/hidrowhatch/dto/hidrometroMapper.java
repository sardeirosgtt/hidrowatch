package com.hidro.hidrowhatch.dto;

import java.util.stream.Collectors;

import java.util.List;

import com.hidro.hidrowhatch.model.Hidrometro;

public class hidrometroMapper {

    public static hidrometroDTO toHidrometroDTO(Hidrometro hidrometro) {
         hidrometroDTO dto = new hidrometroDTO();
            dto.setId(hidrometro.getId());
            dto.setNumero(hidrometro.getNumero());
            dto.setLeituras(LeituraMapper.toLeituraList(hidrometro.getLeituras()));
            dto.setApartamento(ApartamentoMapper.);

            return dto;
        
    }

    public static List<hidrometroDTO> toHidrometroDTOList(List<Hidrometro> Hidrometro) {
        return Hidrometro.stream().map(hidrometroMapper::toHidrometroDTO).collect(Collectors.toList());
    }
}
