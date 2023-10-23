package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hidro.hidrowhatch.model.Usuario;

@Component
public class UsuarioMapper {
    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto=  new UsuarioDTO();
        		if (usuario!= null) {
				dto.setId(usuario.getId());
        		dto.setCpf(usuario.getCpf());
        		dto.setNome(usuario.getNome());
        		dto.setEmail(usuario.getEmail());
        		dto.setPassword(usuario.getPassword());
        		dto.setRole(usuario.getRole());
        		return dto;
				} else {
					return null;
				}
        		
        		
    }
    
    public static Usuario toUsuario(UsuarioDTO usuarioDTO) {
    	Usuario usuario = new Usuario();
        		
        		usuario.setId(usuarioDTO.getId());
        		usuario.setCpf(usuarioDTO.getCpf());
        		usuario.setNome(usuarioDTO.getNome());
        		usuario.setEmail(usuarioDTO.getEmail());
        		usuario.setPassword(usuarioDTO.getPassword());
        		usuario.setRole(usuarioDTO.getRole());
        		return usuario;   		
    }

    public static List<UsuarioDTO> toUsuarioDTOList(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toUsuarioDTO).collect(Collectors.toList());
    }

}
