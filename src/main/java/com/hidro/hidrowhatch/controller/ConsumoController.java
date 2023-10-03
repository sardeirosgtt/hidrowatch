package com.hidro.hidrowhatch.controller;

import com.hidro.hidrowhatch.dto.ConsumoDTO;
import com.hidro.hidrowhatch.dto.ConsumoMapper;
import com.hidro.hidrowhatch.dto.LeituraDto;
import com.hidro.hidrowhatch.dto.LeituraMapper;
import com.hidro.hidrowhatch.model.Consumo;
import com.hidro.hidrowhatch.model.Leitura;
import com.hidro.hidrowhatch.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos")
public class ConsumoController {

    @Autowired
    private ConsumoService consumoService;


    @GetMapping
    public List<ConsumoDTO> listar() {
        List<Consumo> consumos = consumoService.listarConsumos();
        return ConsumoMapper.toConsumoDTO(consumos);
    }

    @GetMapping("/{id}")
    public ConsumoDTO buscar(@PathVariable Long id) {
    	Consumo consumo = consumoService.buscarConsumoPorId(id);
        return ConsumoMapper.toConsumoDTO(consumo);
    }
    
    

    @PostMapping
    public Consumo salvar(@RequestBody Consumo consumo) {
        return consumoService.salvarConsumo(consumo);
    }

    @PutMapping("/{id}")
    public Consumo editar(@PathVariable Long id, @RequestBody Consumo consumo) {
        return consumoService.editarConsumo(id, consumo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        consumoService.deletarConsumo(id);
    }
}
