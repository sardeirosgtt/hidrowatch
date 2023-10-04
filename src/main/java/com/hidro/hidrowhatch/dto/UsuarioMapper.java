package com.hidro.hidrowhatch.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hidro.hidrowhatch.model.Usuario;
import com.hidro.hidrowhatch.model.UsuarioRole;

@Component
public class UsuarioMapper {
    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getCpf(), usuario.getNome(), usuario.getEmail(),usuario.getPassword(),usuario.getRole());
    }

    public static List<UsuarioDTO> toUsuarioDTOList(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toUsuarioDTO).collect(Collectors.toList());
    }

}
