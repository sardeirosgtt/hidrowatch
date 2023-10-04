package com.hidro.hidrowhatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hidro.hidrowhatch.dto.AuthenticationDTO;
import com.hidro.hidrowhatch.dto.UsuarioDTO;
import com.hidro.hidrowhatch.dto.UsuarioMapper;
import com.hidro.hidrowhatch.model.Usuario;
import com.hidro.hidrowhatch.model.UsuarioRole;
import com.hidro.hidrowhatch.repository.UsuarioRepository;
import com.hidro.hidrowhatch.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private final UsuarioService service;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioController(UsuarioService service,BCryptPasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }
	
	@PostMapping
    public Usuario salvar(@RequestBody Usuario novoUsuario) {
		novoUsuario.setPassword(passwordEncoder.encode(novoUsuario.getPassword()));
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
    
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().build();
		
	}
}


