package com.hidro.hidrowhatch.service;

import com.hidro.hidrowhatch.model.Hidrometro;
import com.hidro.hidrowhatch.repository.HidrometroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HidrometroService {

    @Autowired
    private HidrometroRepository hidrometroRepository;

    public List<Hidrometro> listarHidrometros() {
        return hidrometroRepository.findAll();
    }

    public Hidrometro buscarHidrometroPorId(Long id) {
        return hidrometroRepository.findById(id).orElse(null);
    }

    public Hidrometro salvarHidrometro(Hidrometro hidrometro) {
        return hidrometroRepository.save(hidrometro);
    }

    public void deletarHidrometro(Long id) {
        hidrometroRepository.deleteById(id);
    }

    public Hidrometro editarHidrometro(Long id, Hidrometro novoHidrometro) {
        Hidrometro hidrometroExistente = hidrometroRepository.findById(id).orElse(null);
        if (hidrometroExistente != null) {
            hidrometroExistente.setNumero(novoHidrometro.getNumero());
            hidrometroExistente.setLeitura(novoHidrometro.getLeitura());
            hidrometroExistente.setDataConsumo(novoHidrometro.getDataConsumo());
            hidrometroExistente.setApartamento(novoHidrometro.getApartamento());
            return hidrometroRepository.save(hidrometroExistente);
        }
        return null;
    }
}
