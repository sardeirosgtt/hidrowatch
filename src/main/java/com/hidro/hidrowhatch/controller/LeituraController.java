package com.hidro.hidrowhatch.controller;

import com.hidro.hidrowhatch.dto.ApartamentoDTO;
import com.hidro.hidrowhatch.dto.ApartamentoMapper;
import com.hidro.hidrowhatch.dto.LeituraDto;
import com.hidro.hidrowhatch.dto.LeituraMapper;
import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.model.Leitura;
import com.hidro.hidrowhatch.service.LeituraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leituras")
public class LeituraController {

    @Autowired
    private LeituraService leituraService;

    @GetMapping
    public List<LeituraDto> listar() {
        List<Leitura> leituras = leituraService.listarLeituras();
        return LeituraMapper.toLeituraList(leituras);
    }

    @GetMapping("/{id}")
    public LeituraDto buscar(@PathVariable Long id) {
    	Leitura leitura = leituraService.buscarLeituraPorId(id);
        return LeituraMapper.toLeituraDto(leitura);
    }


    @PostMapping
    public Leitura salvar(@RequestBody Leitura leitura) {
        return leituraService.salvarLeituraComCalculo(leitura);
    }

    @PutMapping("/{id}")
    public Leitura editar(@PathVariable Long id, @RequestBody Leitura leitura) {
        return leituraService.editarLeitura(id, leitura);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        leituraService.deletarLeitura(id);
    }
}

