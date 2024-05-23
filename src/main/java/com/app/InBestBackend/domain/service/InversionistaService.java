package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.InversionistaDTO;
import com.app.InBestBackend.domain.mapper.InversionistaMapper;
import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.repository.InversionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InversionistaService {
    
    @Autowired
    private InversionistaRepository inversionistaRepository;
    
    public InversionistaDTO save(InversionistaDTO inversionistaDTO){
        inversionistaRepository.save(InversionistaMapper.toEntinty(inversionistaDTO));
        return inversionistaDTO;
    }
    
    public InversionistaDTO buscarInversionista(Long id){
        Inversionista inversionista = inversionistaRepository.findById(id).orElse(null);
        inversionista.getSolicitudes().clear();
        inversionista.getInversiones().clear();
        return InversionistaMapper.toDTO(inversionista);
    }
}
