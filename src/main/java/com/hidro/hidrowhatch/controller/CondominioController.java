package com.hidro.hidrowhatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hidro.hidrowhatch.model.Condominios;
import com.hidro.hidrowhatch.service.CondominioService;


@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @GetMapping
    public List<Condominios> listar() {
        return condominioService.listarCondominios();
    }

    @GetMapping("/{id}")
    public Condominios buscar(@PathVariable Long id) {
        return condominioService.buscarCondominiosPorId(id);
    }

    @PostMapping
    public Condominios salvar(@RequestBody Condominios condominios) {
        return condominioService.salvarCondominios(condominios);
    }

    @PutMapping("/{id}")
    public Condominios editar(@PathVariable Long id, @RequestBody Condominios condominios) {
        return condominioService.editarCondominios(id, condominios);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        condominioService.deletarCondominios(id);
    }
}
