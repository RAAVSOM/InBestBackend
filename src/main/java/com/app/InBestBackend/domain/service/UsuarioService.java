package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.UsuarioDTO;
import com.app.InBestBackend.domain.mapper.UsuarioMapper;
import com.app.InBestBackend.persistence.entity.Usuario;
import com.app.InBestBackend.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
	
    public UsuarioDTO loadUsuarioByUsuario(String usuario) throws Exception{
        Usuario usuarioComp = usuarioRepository.findByUsuario(usuario);
        if(usuarioComp == null){
            UsuarioDTO usuarioMal = new UsuarioDTO();
            usuarioMal.setUsuario("");
            usuarioMal.setClave("");
            return usuarioMal;
        }else{
            UsuarioDTO usuarioBien = new UsuarioDTO();
            usuarioBien.setId_usuario(usuarioComp.getId_usuario());
            usuarioBien.setUsuario(usuarioComp.getUsuario());
            usuarioBien.setClave(usuarioComp.getClave());
            usuarioBien.setTipo_usuario(usuarioComp.getTipo_usuario());
            return usuarioBien;
        }

    }
        
    public boolean validarContraseña(UsuarioDTO usersDTO, String clave){
        return usersDTO.getClave().matches(clave);
    }
    
    public List<Usuario> cargartodos(){
        return usuarioRepository.findAll();
    }
    
    public Usuario guardar(UsuarioDTO usuarioDTO){
        return usuarioRepository.save(UsuarioMapper.toEntinty(usuarioDTO));
    }
        
}
