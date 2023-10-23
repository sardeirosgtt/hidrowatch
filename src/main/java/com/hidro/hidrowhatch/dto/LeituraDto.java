package com.hidro.hidrowhatch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeituraDto {
    
    private Long id;
    private Double valor;
    
    
    private String dataLeitura;
    private HidrometroDTO hidrometro;

}
