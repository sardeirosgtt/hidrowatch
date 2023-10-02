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

import com.hidro.hidrowhatch.dto.BlocoDTO;
import com.hidro.hidrowhatch.dto.BlocoMapper;
import com.hidro.hidrowhatch.model.Bloco;
import com.hidro.hidrowhatch.service.BlocoService;

@RestController
@RequestMapping("/blocos")
public class BlocoController {

    @Autowired
    private BlocoService blocoService;

    @GetMapping
    public List<BlocoDTO> listar() {
        List<Bloco> blocos = blocoService.listarBlocos();
        return BlocoMapper.toBlocoDTOList(blocos);
    }

    @GetMapping("/{id}")
    public BlocoDTO buscar(@PathVariable Long id) {
        Bloco bloco = blocoService.buscarBlocoPorId(id);
        return BlocoMapper.toBlocoDTO(bloco);
    }

    @PostMapping
    public Bloco salvar(@RequestBody Bloco bloco) {
        return blocoService.salvarBloco(bloco);
    }

    @PutMapping("/{id}")
    public Bloco editar(@PathVariable Long id, @RequestBody Bloco bloco) {
        return blocoService.editarBloco(id, bloco);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        blocoService.deletarBloco(id);
    }
}
