package com.hidro.hidrowhatch.dto;

import java.util.List;

import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.model.Leitura;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class hidrometroDTO {
    

    private Long id;
    private String numero;

    private ApartamentoDTO apartamento;
    
    private List<LeituraDto> leituras;
}
