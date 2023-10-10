package com.hidro.hidrowhatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hidro.hidrowhatch.dto.CondominioDTO;
import com.hidro.hidrowhatch.dto.CondominioMapper;
import com.hidro.hidrowhatch.model.Condominios;
import com.hidro.hidrowhatch.model.CriarCondominioRequest;
import com.hidro.hidrowhatch.service.CondominioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @GetMapping("/listar-condominios")
    public ResponseEntity<List<CondominioDTO>> listar() {
    	List<Condominios> condominios = condominioService.listarCondominios();
        List<CondominioDTO> condominioDTO = CondominioMapper.toCondominioDTOList(condominios);
        return ResponseEntity.ok(condominioDTO);
        
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondominioDTO> buscar(@PathVariable Long id) {
    	Condominios condominios = condominioService.buscarCondominiosPorId(id);
        CondominioDTO condominioDTO = CondominioMapper.toCondominioDTO(condominios);
        return ResponseEntity.ok(condominioDTO);
    }

    @PostMapping("/criar")
    public ResponseEntity<CondominioDTO> criarCondominio(@RequestBody @Valid CriarCondominioRequest request) {
        condominioService.criarCondominioComConfiguracao(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
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
