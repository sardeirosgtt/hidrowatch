package com.hidro.hidrowhatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.Consumo;
import com.hidro.hidrowhatch.model.Hidrometro;
import com.hidro.hidrowhatch.model.Leitura;
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

    public Leitura salvarLeituraComCalculo(Leitura leitura) {
        // Busca a última leitura para o mesmo hidrômetro
        Leitura leituraAnterior = leituraRepository.findLatestByHidrometro(leitura.getHidrometro());

        // Verifica se o apartamento associado ao hidrômetro tem pelo menos dois hidrômetros
        if (leituraAnterior != null && leitura.getHidrometro().getApartamento().getHidrometros().size() >= 2) {
            // Calcula o consumo (leitura atual - leitura anterior)
            double consumoValor = leitura.getValor() - leituraAnterior.getValor();

            // Cria um novo consumo para o hidrômetro atual
            Consumo consumo = new Consumo();
            consumo.setValor(consumoValor);
            consumo.setDataConsumo(leitura.getDataLeitura()); // Use a data da leitura como data de consumo
            consumo.setApartamento(leitura.getHidrometro().getApartamento());

            // Salva o consumo para o hidrômetro atual
            consumoRepository.save(consumo);

            // Verifica se há mais de um hidrômetro no mesmo apartamento
            List<Hidrometro> hidrometros = leitura.getHidrometro().getApartamento().getHidrometros();
            if (hidrometros.size() >= 2) {
                // Calcula o consumo para o segundo hidrômetro
                Hidrometro outroHidrometro = hidrometros.stream()
                    .filter(h -> !h.getId().equals(leitura.getHidrometro().getId())) // Exclui o hidrômetro atual
                    .findFirst()
                    .orElse(null);

                if (outroHidrometro != null) {
                    // Calcula o consumo para o segundo hidrômetro (leitura atual - leitura anterior)
                    double consumoOutroValor = leitura.getValor() - leituraAnterior.getValor();

                    // Cria um novo consumo para o segundo hidrômetro
                    Consumo consumoOutro = new Consumo();
                    consumoOutro.setValor(consumoOutroValor);
                    consumoOutro.setDataConsumo(leitura.getDataLeitura()); // Use a data da leitura como data de consumo
                    consumoOutro.setApartamento(leitura.getHidrometro().getApartamento());

                    // Salva o consumo para o segundo hidrômetro
                    consumoRepository.save(consumoOutro);
                }
            }
        }

        // Salva a nova leitura
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
