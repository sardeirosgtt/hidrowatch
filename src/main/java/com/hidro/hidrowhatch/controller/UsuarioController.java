package com.hidro.hidrowhatch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hidro.hidrowhatch.dto.UsuarioDTO;
import com.hidro.hidrowhatch.dto.UsuarioMapper;
import com.hidro.hidrowhatch.model.Usuario;
import com.hidro.hidrowhatch.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
        this.service = service;
    }
	
	@PostMapping
    public Usuario salvar(@RequestBody Usuario novoUsuario) {
        return service.salvar(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
    	List<Usuario> usuarios = service.listarTodos();
        List<UsuarioDTO> usuariosDTO = UsuarioMapper.toUsuarioDTOList(usuarios);
        return ResponseEntity.ok(usuariosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
    	Usuario usuario = service.buscarPorId(id);
        UsuarioDTO usuarioDTO = UsuarioMapper.toUsuarioDTO(usuario);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        return service.atualizar(id, usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    
    public Boolean validarCampos(Usuario usuario) {
    	return true;
    }
}


