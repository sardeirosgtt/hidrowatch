package com.hidro.hidrowhatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.repository.ApartamentoRepository;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public List<Apartamento> listarApartamentos() {
        return apartamentoRepository.findAll();
    }

    public Apartamento buscarApartamentoPorId(Long id) {
        return apartamentoRepository.findById(id).orElse(null);
    }

    public Apartamento salvarApartamento(Apartamento apartamento) {
        return apartamentoRepository.save(apartamento);
    }

    public void deletarApartamento(Long id) {
        apartamentoRepository.deleteById(id);
    }

    public Apartamento editarApartamento(Long id, Apartamento novoApartamento) {
        Apartamento apartamentoExistente = apartamentoRepository.findById(id).orElse(null);
        if (apartamentoExistente != null) {
        	// Faça as atualizações necessárias no objeto apartamentoExistente com base no novoApartamento
            apartamentoExistente.setNumero(novoApartamento.getNumero());
            apartamentoExistente.setAndar(novoApartamento.getAndar());
            apartamentoExistente.setBloco(novoApartamento.getBloco());
            apartamentoExistente.setUsuario(novoApartamento.getUsuario());
            // ...
            return apartamentoRepository.save(apartamentoExistente);
        }
        return null;
    }
    
    public List<Apartamento> buscarApartamentosPorCondominio(Long condominioId) {
        // Use o repositório para buscar todos os apartamentos de um determinado condomínio
        return apartamentoRepository.findByCondominioId(condominioId);
    }
    
    public List<Apartamento> buscarApartamentosPorUsuario(Long usuarioId) {
        // Use o repositório para buscar todos os apartamentos do usuário
        return apartamentoRepository.findByUsuarioId(usuarioId);
    }
}
