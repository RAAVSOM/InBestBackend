package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.InversionDTO;
import com.app.InBestBackend.domain.mapper.InversionMapper;
import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.entity.Negocio;
import com.app.InBestBackend.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class InversionService {
    @Autowired
    private InversionRepository inversionRepository;

    @Autowired
    private NegocioRepository negocioRepository;
    @Autowired
    private InversionistaRepository inversionistaRepository;
    @Autowired
    private EmprendedorRepository emprendedorRepository;
    @Autowired
    private SolicitudRepository solicitudRepository;
    
    public void aceptarSolicitud(Long id_N, Long id_I, Long id_E, Long id_S){
        Inversion inversion = new Inversion();
        inversion.setNegocio(negocioRepository.findById(id_N).orElse(null));
        inversion.setInversionista(inversionistaRepository.findById(id_I).orElse(null));
        inversion.setEmprendedor(emprendedorRepository.findById(id_E).orElse(null));
        inversion.setSolicitud(solicitudRepository.findById(id_S).orElse(null));

        inversionRepository.save(inversion);
    }

    public InversionDTO buscarInversion(Long id){
        Inversion inversionBd = inversionRepository.findById(id).orElse(null);
        inversionBd.getSolicitud().setNegocio(null);
        inversionBd.getSolicitud().setInversionista(null);
        inversionBd.setNegocio(null);
        inversionBd.getInversionista().getSolicitudes().clear();
        inversionBd.getInversionista().getInversiones().clear();
        return InversionMapper.toDTO(inversionBd);
    }

    public List<InversionDTO> getInversiones(Long id){
        Negocio negocio = negocioRepository.findById(id).orElse(null);
        List<Inversion> inversionesBd = inversionRepository.findAllByNegocio(negocio);
        List<InversionDTO> inversiones = new ArrayList<>();
        for(Inversion inversion : inversionesBd){
            inversion.getSolicitud().setNegocio(null);
            inversion.getSolicitud().setInversionista(null);
            inversion.setNegocio(null);
            inversion.setInversionista(null);
            inversion.setEmprendedor(null);
            inversiones.add(InversionMapper.toDTO(inversion));
        }
        return inversiones;
    }
}
