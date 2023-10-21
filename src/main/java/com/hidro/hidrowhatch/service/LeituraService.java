package com.hidro.hidrowhatch.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.model.Consumo;
import com.hidro.hidrowhatch.model.Hidrometro;
import com.hidro.hidrowhatch.model.Leitura;
import com.hidro.hidrowhatch.repository.ApartamentoRepository;
import com.hidro.hidrowhatch.repository.ConsumoRepository;
import com.hidro.hidrowhatch.repository.LeituraRepository;

@Service
public class LeituraService {

    @Autowired
    private LeituraRepository leituraRepository;

    @Autowired
    private ConsumoRepository consumoRepository;
    

    public List<Leitura> listarLeituras() {
        return leituraRepository.findAll();
    }

    public Leitura buscarLeituraPorId(Long id) {
        return leituraRepository.findById(id).orElse(null);
    }

    public Leitura salvarLeituraPorHidrometro(Leitura leitura) {
        List<Leitura> leituras = leituraRepository.findLatestByHidrometro(leitura.getHidrometro());

        if (!leituras.isEmpty()) {
            // Ordena a lista para que a leitura mais recente seja a primeira.
            leituras.sort(Comparator.comparing(Leitura::getDataLeitura).reversed());

            // Obtém a leitura mais recente da lista.
            Leitura leituraAnterior = leituras.get(0);
            
            double consumoValor = leitura.getValor() - leituraAnterior.getValor();
            
            Consumo consumo = new Consumo();
            consumo.setValor(consumoValor);
            consumo.setDataConsumo(leitura.getDataLeitura());
            consumo.setApartamento(leitura.getHidrometro().getApartamento());
            consumo.setLeituraAnterior(leituraAnterior.getValor());
            consumo.setLeituraAtual(leitura.getValor());
            
            consumoRepository.save(consumo);
        }
        
        return leituraRepository.save(leitura);
    }



    public void deletarLeitura(Long id) {
        leituraRepository.deleteById(id);
    }

    public Leitura editarLeitura(Long id, Leitura novaLeitura) {
        Leitura leituraExistente = leituraRepository.findById(id).orElse(null);
        if (leituraExistente != null) {
            leituraExistente.setValor(novaLeitura.getValor());
            leituraExistente.setDataLeitura(novaLeitura.getDataLeitura());
            leituraExistente.setHidrometro(novaLeitura.getHidrometro());
            return leituraRepository.save(leituraExistente);
        }
        return null;
    }
}
