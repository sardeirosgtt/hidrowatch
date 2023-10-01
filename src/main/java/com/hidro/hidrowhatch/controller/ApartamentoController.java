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

import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.service.ApartamentoService;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @GetMapping
    public List<Apartamento> listar() {
        return apartamentoService.listarApartamentos();
    }

    @GetMapping("/{id}")
    public Apartamento buscar(@PathVariable Long id) {
        return apartamentoService.buscarApartamentoPorId(id);
    }

    @PostMapping
    public Apartamento salvar(@RequestBody Apartamento apartamento) {
        return apartamentoService.salvarApartamento(apartamento);
    }

    @PutMapping("/{id}")
    public Apartamento editar(@PathVariable Long id, @RequestBody Apartamento apartamento) {
        return apartamentoService.editarApartamento(id, apartamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        apartamentoService.deletarApartamento(id);
    }
}
