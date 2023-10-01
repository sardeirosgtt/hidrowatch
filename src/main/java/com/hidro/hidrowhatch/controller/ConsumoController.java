package com.hidro.hidrowhatch.controller;

import com.hidro.hidrowhatch.model.Consumo;
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
    public List<Consumo> listar() {
        return consumoService.listarConsumos();
    }

    @GetMapping("/{id}")
    public Consumo buscar(@PathVariable Long id) {
        return consumoService.buscarConsumoPorId(id);
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
