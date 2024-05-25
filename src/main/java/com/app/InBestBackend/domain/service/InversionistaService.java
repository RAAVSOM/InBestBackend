package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.InversionistaDTO;
import com.app.InBestBackend.domain.mapper.InversionistaMapper;
import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.entity.Usuario;
import com.app.InBestBackend.persistence.repository.InversionistaRepository;
import com.app.InBestBackend.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InversionistaService {
    
    @Autowired
    private InversionistaRepository inversionistaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public InversionistaDTO save(InversionistaDTO inversionistaDTO){
        inversionistaRepository.save(InversionistaMapper.toEntinty(inversionistaDTO));
        return inversionistaDTO;
    }
    
    public InversionistaDTO buscarInversionista(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        Inversionista inversionista = inversionistaRepository.findByUsuario(usuario);
        inversionista.getSolicitudes().clear();
        inversionista.getInversiones().clear();
        return InversionistaMapper.toDTO(inversionista);
    }

    public String actualizarInfo(InversionistaDTO inversionistaDTO, Long id){
        Inversionista inversionista = inversionistaRepository.findById(id).orElse(null);
        inversionista.setUsuario(inversionistaDTO.getUsuario());
        inversionistaRepository.save(inversionista);
        return "Exito";
    }
}
