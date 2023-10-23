package com.hidro.hidrowhatch.dto;

import com.hidro.hidrowhatch.model.TipoHidrometro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HidrometroDTO {
    

    private Long id;
    private String numero;
    private TipoHidrometro tipo;
    private ApartamentoDTO apartamento;
}
