package com.hidro.hidrowhatch.service;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.Consumo;
import com.hidro.hidrowhatch.model.Leitura;
import com.hidro.hidrowhatch.model.ValoresUnitarios;
import com.hidro.hidrowhatch.repository.ConsumoRepository;
import com.hidro.hidrowhatch.repository.LeituraRepository;
import com.hidro.hidrowhatch.repository.ValoresUnitariosRepository;

@Service
public class LeituraService {

    @Autowired
    private LeituraRepository leituraRepository;

    @Autowired
    private ConsumoRepository consumoRepository;
    
    @Autowired
    private ValoresUnitariosRepository valoresRepository;
    

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
            
            Double ValorR  = calcularValorReal(consumoValor);
            
            Consumo consumo = new Consumo();
            consumo.setValor(consumoValor);
            consumo.setValorReal(ValorR);
            consumo.setDataConsumo(leitura.getDataLeitura());
            consumo.setHidrometro(leitura.getHidrometro());
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
    
    public double calcularValorReal(Double consumo) {
    	ValoresUnitarios valores = valoresRepository.findEntityWithMaxId();
    	Double valor=0.0;
    	if(consumo>=valores.getTamanhoFaixa1()) {
    		valor+=valores.getTamanhoFaixa1()*valores.getValorFaixa1();
    		consumo-=valores.getTamanhoFaixa1();
    		if(consumo>=valores.getTamanhoFaixa2()) {
    			valor+=valores.getTamanhoFaixa2()*valores.getValorFaixa2();
    			consumo-=valores.getTamanhoFaixa2();
    			if(consumo>=valores.getTamanhoFaixa3()) {
    				valor+=valores.getTamanhoFaixa3()*valores.getValorFaixa3();
        			consumo-=valores.getTamanhoFaixa3();
        			if(consumo>=valores.getTamanhoFaixa4()) {
        				valor+=valores.getTamanhoFaixa4()*valores.getValorFaixa4();
            			consumo-=valores.getTamanhoFaixa4();
            			if(consumo>=valores.getTamanhoFaixa5()) {
            				valor+=valores.getTamanhoFaixa5()*valores.getValorFaixa5();
                			consumo-=valores.getTamanhoFaixa5();
                			if(consumo>0) {
                				valor+=consumo*valores.getValorFaixa6();
                				valor+=valores.getTaxaFixa();
                			}
                		}else {
                			valor+=consumo*valores.getValorFaixa5();
                			valor+=valores.getTaxaFixa();
                			}
        			}else {
        				valor+=consumo*valores.getValorFaixa4();
        				valor+=valores.getTaxaFixa();
        			}
    			}else {
    				valor+=consumo*valores.getValorFaixa3();
    				valor+=valores.getTaxaFixa();
    			}
    		}else {
    			valor+=consumo*valores.getValorFaixa2();	
    			valor+=valores.getTaxaFixa();
    		}
    	}else{
    		valor+=consumo*valores.getValorFaixa1();
    		valor+=valores.getTaxaFixa();
		}
		return valor*2;
    }
}
