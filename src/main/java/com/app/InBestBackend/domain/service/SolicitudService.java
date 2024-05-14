package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.SolicitudDTO;
import com.app.InBestBackend.domain.mapper.SolicitudMapper;
import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.entity.Negocio;
import com.app.InBestBackend.persistence.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;
    
    //------------funciones inversionista-----------------
    public List<SolicitudDTO> cargarSolicitudes(Negocio negocio, Inversionista inversionista){
        return solicitudRepository.findAllByNegocioAndInversionista(negocio, inversionista).stream().map(SolicitudMapper::toDTO).collect(Collectors.toList());
    }
    
    public void agregarSolicitud(SolicitudDTO solicitudDTO){
        solicitudRepository.save(SolicitudMapper.toEntinty(solicitudDTO));
    }
    
    public String eliminarsolicitud(Long id){
        SolicitudDTO solicitudDTO = SolicitudMapper.toDTO(solicitudRepository.findById(id).orElse(null));
        if(solicitudDTO != null){
            solicitudRepository.delete(SolicitudMapper.toEntinty(solicitudDTO));
            return "eliminado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public String actualizarSolicitud(Long id, SolicitudDTO solicitudDTO){
        SolicitudDTO solicitudDTOfromDB = SolicitudMapper.toDTO(solicitudRepository.findById(id).orElse(null));
        if(solicitudDTOfromDB != null){
            solicitudDTOfromDB.setInversionista(solicitudDTO.getInversionista());
            solicitudDTOfromDB.setNivel_riezgotolerado(solicitudDTO.getNivel_riezgotolerado());
            solicitudDTOfromDB.setPorcentaje_liquidez(solicitudDTO.getPorcentaje_liquidez());
            solicitudDTOfromDB.setPorcentaje_rentabilidad(solicitudDTO.getPorcentaje_rentabilidad());
            solicitudDTOfromDB.setValor_solicitud(solicitudDTO.getValor_solicitud());
            solicitudRepository.save(SolicitudMapper.toEntinty(solicitudDTOfromDB));
            return "actualizado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public SolicitudDTO verSolicitudI(Long id){
        return SolicitudMapper.toDTO(solicitudRepository.findById(id).orElse(null));
    }
    
    //------------funciones emprendedor----------------
    public List<SolicitudDTO> cargarSolicitudesNegocio(Negocio negocio){
        return solicitudRepository.findAllByNegocio(negocio).stream().map(SolicitudMapper::toDTO).collect(Collectors.toList());
    }
    
    public SolicitudDTO verSolicitudE(Long id){
        return SolicitudMapper.toDTO(solicitudRepository.findById(id).orElse(null));
    }
    
    public void concluirSubasta(Negocio negocio){
        solicitudRepository.deleteAllByNegocio(negocio);
    }
}
