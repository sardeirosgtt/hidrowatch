package com.hidro.hidrowhatch.dto;

import java.time.LocalDateTime;

import com.hidro.hidrowhatch.model.Hidrometro;

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
    private LocalDateTime dataLeitura;
    private Hidrometro hidrometro;

}
