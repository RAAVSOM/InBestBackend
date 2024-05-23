package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.InversionDTO;
import com.app.InBestBackend.domain.mapper.InversionMapper;
import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.repository.InversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InversionService {
    @Autowired
    private InversionRepository inversionRepository;
    
    public void aceptarSolicitud(Inversion inversion){
        inversionRepository.save(inversion);
    }

    public InversionDTO buscarInversion(Long id){
        Inversion inversionBd = inversionRepository.findById(id).orElse(null);
        inversionBd.getSolicitud().setNegocio(null);
        inversionBd.getSolicitud().setInversionista(null);
        inversionBd.setNegocio(null);
        inversionBd.setInversionista(null);
        return InversionMapper.toDTO(inversionBd);
    }
}
