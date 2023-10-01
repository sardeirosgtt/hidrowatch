package com.hidro.hidrowhatch.controller;

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
    public List<Leitura> listar() {
        return leituraService.listarLeituras();
    }

    @GetMapping("/{id}")
    public Leitura buscar(@PathVariable Long id) {
        return leituraService.buscarLeituraPorId(id);
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

