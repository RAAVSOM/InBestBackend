package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.UsuarioDTO;
import com.app.InBestBackend.persistence.entity.Usuario;


public class UsuarioMapper {
    public static Usuario toEntinty(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setPersona(usuarioDTO.getPersona());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setClave(usuarioDTO.getClave());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setTipo_usuario(usuarioDTO.getTipo_usuario());
        return usuario;
    }

    public static UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPersona(usuario.getPersona());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setClave(usuario.getClave());
        usuarioDTO.setUsuario(usuario.getUsuario());
        usuarioDTO.setTipo_usuario(usuario.getTipo_usuario());
        return usuarioDTO;
    }
}
