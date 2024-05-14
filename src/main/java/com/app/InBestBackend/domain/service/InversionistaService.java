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
    
    public Inversionista buscarInversionista(Long id){
        return inversionistaRepository.findById(id).orElse(null);
    }
}
