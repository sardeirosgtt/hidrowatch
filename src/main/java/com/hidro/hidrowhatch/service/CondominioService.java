package com.hidro.hidrowhatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.Condominios;
import com.hidro.hidrowhatch.repository.CondominiosRepository;

@Service
public class CondominioService {

    @Autowired
    private CondominiosRepository condominiosRepository;

    public List<Condominios> listarCondominios() {
        return condominiosRepository.findAll();
    }

    public Condominios buscarCondominiosPorId(Long id) {
        return condominiosRepository.findById(id).orElse(null);
    }

    public Condominios salvarCondominios(Condominios condominios) {
        return condominiosRepository.save(condominios);
    }

    public void deletarCondominios(Long id) {
        condominiosRepository.deleteById(id);
    }

    public Condominios editarCondominios(Long id, Condominios novoCondominios) {
        Condominios condominiosExistente = condominiosRepository.findById(id).orElse(null);
        if (condominiosExistente != null) {
            condominiosExistente.setNome(novoCondominios.getNome());
            condominiosExistente.setCnpj(novoCondominios.getCnpj());
            condominiosExistente.setEmail(novoCondominios.getEmail());
            condominiosExistente.setEndereco(novoCondominios.getEndereco());
            return condominiosRepository.save(condominiosExistente);
        }
        return null;
    }
}
