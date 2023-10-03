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

import com.hidro.hidrowhatch.dto.HidrometroDTO;
import com.hidro.hidrowhatch.dto.HidrometroMapper;
import com.hidro.hidrowhatch.model.Hidrometro;
import com.hidro.hidrowhatch.service.HidrometroService;

@RestController
@RequestMapping("/hidrometros")
public class HidrometroController {

    @Autowired
    private HidrometroService hidrometroService;

    @GetMapping
    public List<HidrometroDTO> listar() {
        List<Hidrometro> hidrometro = hidrometroService.listarHidrometros();
        return HidrometroMapper.toHidrometroDTOList(hidrometro);
    }

    @GetMapping("/{id}")
    public Hidrometro buscar(@PathVariable Long id) {
        return hidrometroService.buscarHidrometroPorId(id);
    }

    @PostMapping
    public Hidrometro salvar(@RequestBody Hidrometro hidrometro) {
        return hidrometroService.salvarHidrometro(hidrometro);
    }

    @PutMapping("/{id}")
    public Hidrometro editar(@PathVariable Long id, @RequestBody Hidrometro hidrometro) {
        return hidrometroService.editarHidrometro(id, hidrometro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        hidrometroService.deletarHidrometro(id);
    }
}
