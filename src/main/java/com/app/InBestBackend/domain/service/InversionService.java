package com.app.InBestBackend.domain.service;

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
}
