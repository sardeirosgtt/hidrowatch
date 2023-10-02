package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hidro.hidrowhatch.model.Condominios;

public class CondominioMapper {

	public static CondominioDTO toCondominioDTO(Condominios condominio) {
        return new CondominioDTO(condominio.getId(), condominio.getNome(), condominio.getCnpj(),condominio.getEmail(),condominio.getEndereco());
    }

    public static List<CondominioDTO> toCondominioDTOList(List<Condominios> condominios) {
        return condominios.stream().map(CondominioMapper::toCondominioDTO).collect(Collectors.toList());
    }
}
