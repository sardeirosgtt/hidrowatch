package com.hidro.hidrowhatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.Bloco;
import com.hidro.hidrowhatch.repository.BlocoRepository;

@Service
public class BlocoService {

    @Autowired
    private BlocoRepository blocoRepository;

    public List<Bloco> listarBlocos() {
        return blocoRepository.findAll();
    }

    public Bloco buscarBlocoPorId(Long id) {
        return blocoRepository.findById(id).orElse(null);
    }

    public Bloco salvarBloco(Bloco bloco) {
        return blocoRepository.save(bloco);
    }

    public void deletarBloco(Long id) {
        blocoRepository.deleteById(id);
    }

    public Bloco editarBloco(Long id, Bloco novoBloco) {
        Bloco blocoExistente = blocoRepository.findById(id).orElse(null);
        if (blocoExistente != null) {
            blocoExistente.setNumero(novoBloco.getNumero());
            blocoExistente.setQtdAndar(novoBloco.getQtdAndar());
            blocoExistente.setCondominios(novoBloco.getCondominios());
            return blocoRepository.save(blocoExistente);
        }
        return null;
    }
}


