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

import com.hidro.hidrowhatch.dto.ApartamentoDTO;
import com.hidro.hidrowhatch.dto.ApartamentoMapper;
import com.hidro.hidrowhatch.dto.BlocoMapper;
import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.model.Bloco;
import com.hidro.hidrowhatch.service.ApartamentoService;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @GetMapping
    public List<ApartamentoDTO> listar() {
    	List<Apartamento> apartamento = apartamentoService.listarApartamentos();
        return ApartamentoMapper.toApartamentoDTOList(apartamento);
    }

    @GetMapping("/{id}")
    public ApartamentoDTO buscar(@PathVariable Long id) {
    	Apartamento apartamento = apartamentoService.buscarApartamentoPorId(id);
        return ApartamentoMapper.toApartamentoDTO(apartamento);
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
    
    @GetMapping("por-condominio/{id}")
    public List<Apartamento> buscarApartamentosPorCondominio(@PathVariable Long id) {
    	return  apartamentoService.buscarApartamentosPorCondominio(id);
    }
    
    @GetMapping("/por-usuario/{usuarioId}")
    public List<Apartamento> buscarApartamentosPorUsuario(@PathVariable Long usuarioId) {
        return apartamentoService.buscarApartamentosPorUsuario(usuarioId);
    }
}
