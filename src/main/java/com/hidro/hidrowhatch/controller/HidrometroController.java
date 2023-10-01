package com.hidro.hidrowhatch.controller;

import com.hidro.hidrowhatch.model.Hidrometro;
import com.hidro.hidrowhatch.service.HidrometroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hidrometros")
public class HidrometroController {

    @Autowired
    private HidrometroService hidrometroService;

    @GetMapping
    public List<Hidrometro> listar() {
        return hidrometroService.listarHidrometros();
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
