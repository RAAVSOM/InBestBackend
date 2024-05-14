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
            return new UsuarioDTO("", "");
        }
        return new UsuarioDTO(usuarioComp.getUsuario(), usuarioComp.getClave());
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
