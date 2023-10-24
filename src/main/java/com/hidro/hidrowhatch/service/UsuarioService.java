package com.hidro.hidrowhatch.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hidro.hidrowhatch.model.RelUsuarioApartamento;
import com.hidro.hidrowhatch.model.RelUsuarioApartamentoId;
import com.hidro.hidrowhatch.model.Usuario;
import com.hidro.hidrowhatch.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;
	
	UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
	
	@org.springframework.transaction.annotation.Transactional
    public Usuario salvar(Usuario novoUsuario) {
        return repository.save(novoUsuario);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public UserDetails buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    @org.springframework.transaction.annotation.Transactional
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        return repository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    repository.save(usuario);
                    return usuario;
                })
                .orElse(null);
    }

    @org.springframework.transaction.annotation.Transactional
    public void deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}


