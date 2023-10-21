package com.hidro.hidrowhatch.dto;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    
    
    private String dataLeitura;
    private HidrometroDTO hidrometro;

}
