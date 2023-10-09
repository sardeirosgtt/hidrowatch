package com.hidro.hidrowhatch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.dto.CondominioDTO;
import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.model.Bloco;
import com.hidro.hidrowhatch.model.Condominios;
import com.hidro.hidrowhatch.model.CriarCondominioRequest;
import com.hidro.hidrowhatch.repository.CondominiosRepository;

@Service
public class CondominioService {

    @Autowired
    private CondominiosRepository condominiosRepository;
    
    @Autowired
    private BlocoService blocoService;  

    @Autowired
    private ApartamentoService apartamentoService;  

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
    
    public CondominioDTO criarCondominioComConfiguracao(CriarCondominioRequest request) {
        // Crie um novo condomínio com base nas informações fornecidas
        Condominios condominio = new Condominios();
        condominio.setNome(request.getNome());
        condominio.setCnpj(request.getCnpj());
        condominio.setEmail(request.getEmail());
        condominio.setEndereco(request.getEndereco());

        // Salve o condomínio no repositório
        condominio = condominiosRepository.save(condominio);

        // Crie blocos e apartamentos com base nas informações fornecidas
        for (int i = 1; i <= request.getNumeroDeBlocos(); i++) {
            Bloco bloco = new Bloco();
            bloco.setNumero("Bloco " + i);
            bloco.setQtdAndar(request.getNumeroDeAndaresPorBloco());
            bloco.setCondominios(condominio);  // Associe o bloco ao condomínio

            // Salve o bloco no repositório de blocos
            bloco = blocoService.salvarBloco(bloco);

            for (int j = 1; j <= request.getNumeroDeAndaresPorBloco(); j++) {
                for (int k = 1; k <= request.getNumeroDeApartamentosPorAndar(); k++) {
                    Apartamento apartamento = new Apartamento();
                    java.text.DecimalFormat formatoNumero = new java.text.DecimalFormat("00");
                    String numeroApartamento = formatoNumero.format(k);
                    apartamento.setNumero(numeroApartamento);
                    apartamento.setAndar(j);
                    apartamento.setBloco(bloco);  // Associe o apartamento ao bloco

                    // Salve o apartamento no repositório de apartamentos
                    apartamentoService.salvarApartamento(apartamento);



                }
            }
        }
        CondominioDTO condominioDTO = new CondominioDTO();
        condominioDTO.setId(condominio.getId());
        condominioDTO.setNome(condominio.getNome());
        condominioDTO.setCnpj(condominio.getCnpj());
        condominioDTO.setEmail(condominio.getEmail());
        condominioDTO.setEndereco(condominio.getEndereco());

        return condominioDTO;
    }
}
