package com.hidro.hidrowhatch.service;

import com.hidro.hidrowhatch.model.Consumo;
import com.hidro.hidrowhatch.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    public List<Consumo> listarConsumos() {
        return consumoRepository.findAll();
    }

    public Consumo buscarConsumoPorId(Long id) {
        return consumoRepository.findById(id).orElse(null);
    }

    public Consumo salvarConsumo(Consumo consumo) {
        return consumoRepository.save(consumo);
    }

    public void deletarConsumo(Long id) {
        consumoRepository.deleteById(id);
    }

    public Consumo editarConsumo(Long id, Consumo novoConsumo) {
        Consumo consumoExistente = consumoRepository.findById(id).orElse(null);
        if (consumoExistente != null) {
            consumoExistente.setValor(novoConsumo.getValor());
            consumoExistente.setDataConsumo(novoConsumo.getDataConsumo());
            consumoExistente.setApartamento(novoConsumo.getApartamento());
            return consumoRepository.save(consumoExistente);
        }
        return null;
    }
}
