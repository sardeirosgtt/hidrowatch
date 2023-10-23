package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hidro.hidrowhatch.model.Consumo;

public class ConsumoMapper {

	public static ConsumoDTO toConsumoDTO(Consumo consumo) {
          ConsumoDTO dto = new ConsumoDTO();
            dto.setId(consumo.getId());
            dto.setValor(consumo.getValor());
            dto.setDataConsumo(consumo.getDataConsumo());
            dto.setLeituraAnterior(consumo.getLeituraAnterior());
            dto.setLeituraAtual(consumo.getLeituraAtual());
            dto.setValorReal(consumo.getValorReal());
            dto.setHidrometro(HidrometroMapper.toHidrometroDTO(consumo.getHidrometro()));
            return dto;
    }

    public static List<ConsumoDTO> toConsumoDTO(List<Consumo> consumo) {
        return consumo.stream().map(ConsumoMapper::toConsumoDTO).collect(Collectors.toList());
    }
}
