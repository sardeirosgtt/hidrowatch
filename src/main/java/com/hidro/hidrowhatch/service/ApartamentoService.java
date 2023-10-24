package com.hidro.hidrowhatch.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.dto.ApartamentoDTO;
import com.hidro.hidrowhatch.dto.UsuarioMapper;
import com.hidro.hidrowhatch.model.Apartamento;
import com.hidro.hidrowhatch.model.Bloco;
import com.hidro.hidrowhatch.model.RelUsuarioApartamento;
import com.hidro.hidrowhatch.model.RelUsuarioApartamentoId;
import com.hidro.hidrowhatch.model.Usuario;
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

    public Apartamento salvarApartamento(Apartamento apartamento, Usuario usuario) {
    	RelUsuarioApartamentoId id = new RelUsuarioApartamentoId();
		
		id.setUsuario(usuario);
		id.setApartamento(apartamento);
		
		RelUsuarioApartamento rel = new RelUsuarioApartamento();
		
		rel.setId(id);
		rel.setDataCadastro(LocalDate.now());
				
        return apartamentoRepository.save(apartamento);

		
    }

    public void deletarApartamento(Long id) {
        apartamentoRepository.deleteById(id);
    }
    
    public List<Apartamento> ListarApartamentoPorUsuario(Long id) {
       return apartamentoRepository.findByUsuarioId(id);
    }
    

    public Apartamento editarApartamento(Long id, ApartamentoDTO novoApartamentoDTO) {
        Apartamento apartamentoExistente = apartamentoRepository.findById(id).orElse(null);
        if (apartamentoExistente != null) {
            // Faça as atualizações necessárias no objeto apartamentoExistente com base no novoApartamentoDTO
            apartamentoExistente.setNumero(novoApartamentoDTO.getNumero());
            apartamentoExistente.setAndar(novoApartamentoDTO.getAndar());
            if(novoApartamentoDTO.getUsuario()!=null) {
            apartamentoExistente.setUsuario(UsuarioMapper.toUsuario(novoApartamentoDTO.getUsuario()));
            }else {
            	apartamentoExistente.setUsuario(null);
            }
            // Outras atualizações, se necessário
            return apartamentoRepository.save(apartamentoExistente);
        }
        return null;
    }

   
    public List<Apartamento> listarApartamentosPorBloco(Long blocoId) {
        return apartamentoRepository.findByBlocoId(blocoId);
    }
}
