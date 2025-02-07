package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.SolicitudDTO;
import com.app.InBestBackend.domain.mapper.SolicitudMapper;
import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.entity.Negocio;
import com.app.InBestBackend.persistence.entity.Solicitud;
import com.app.InBestBackend.persistence.repository.InversionistaRepository;
import com.app.InBestBackend.persistence.repository.NegocioRepository;
import com.app.InBestBackend.persistence.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private NegocioRepository negocioRepository;

    @Autowired
    private InversionistaRepository inversionistaRepository;
    
    //------------funciones inversionista-----------------
    public List<SolicitudDTO> cargarSolicitudes(Long id, Long id_negocio){
        Negocio negocio = negocioRepository.findById(id_negocio).orElse(null);
        Inversionista inversionista = inversionistaRepository.findById(id).orElse(null);

        List<Solicitud> solicitudesBd = solicitudRepository.findAllByNegocioAndInversionista(negocio, inversionista);
        List<SolicitudDTO> solicitudes = new ArrayList<>();
        for (Solicitud solicitud : solicitudesBd){
            solicitud.setInversionista(null);
            solicitud.getNegocio().getSolicitudes().clear();
            solicitud.getNegocio().getInversiones().clear();
            solicitud.getNegocio().setEmprendedor(null);
            solicitudes.add(SolicitudMapper.toDTO(solicitud));
        }

        return solicitudes;
    }
    
    public void agregarSolicitud(SolicitudDTO solicitudDTO, Long id_I, Long id_N){
        Inversionista inversionista = inversionistaRepository.findById(id_I).orElse(null);
        Negocio negocio = negocioRepository.findById(id_N).orElse(null);
        solicitudDTO.setInversionista(inversionista);
        solicitudDTO.setNegocio(negocio);
        solicitudRepository.save(SolicitudMapper.toEntinty(solicitudDTO));
    }
    
    public String eliminarsolicitud(Long id){
        Solicitud solicitud = solicitudRepository.findById(id).orElse(null);
        if(solicitud != null){
            solicitudRepository.delete(solicitud);
            return "eliminado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public String actualizarSolicitud(Long id, SolicitudDTO solicitudDTO){
        Solicitud solicitudBd = solicitudRepository.findById(id).orElse(null);
        if(solicitudBd != null){
            solicitudBd.setInversionista(solicitudDTO.getInversionista());
            solicitudBd.setNivel_riezgotolerado(solicitudDTO.getNivel_riezgotolerado());
            solicitudBd.setPorcentaje_liquidez(solicitudDTO.getPorcentaje_liquidez());
            solicitudBd.setPorcentaje_rentabilidad(solicitudDTO.getPorcentaje_rentabilidad());
            solicitudBd.setValor_solicitud(solicitudDTO.getValor_solicitud());
            solicitudRepository.save(solicitudBd);
            return "actualizado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public SolicitudDTO verSolicitudI(Long id){
        Solicitud solicitudBd = solicitudRepository.findById(id).orElse(null);
        solicitudBd.setInversionista(null);
        solicitudBd.getNegocio().getSolicitudes().clear();
        solicitudBd.getNegocio().getInversiones().clear();
        solicitudBd.getNegocio().setEmprendedor(null);
        return SolicitudMapper.toDTO(solicitudBd);
    }
    
    //------------funciones emprendedor----------------
    public List<SolicitudDTO> cargarSolicitudesNegocio(Long id){
        Negocio negocio = negocioRepository.findById(id).orElse(null);
        List<Solicitud> solicitudesBd = solicitudRepository.findAllByNegocio(negocio);
        List<SolicitudDTO> solicitudes = new ArrayList<>();
        for (Solicitud solicitud : solicitudesBd){
            solicitud.getInversionista().getSolicitudes().clear();
            solicitud.getInversionista().getInversiones().clear();
            solicitud.setNegocio(null);
            solicitudes.add(SolicitudMapper.toDTO(solicitud));
        }
        return solicitudes;
    }
    
    public SolicitudDTO verSolicitudE(Long id){
        Solicitud solicitudBd = solicitudRepository.findById(id).orElse(null);
        solicitudBd.getInversionista().getSolicitudes().clear();
        solicitudBd.getInversionista().getInversiones().clear();
        solicitudBd.setNegocio(null);
        return SolicitudMapper.toDTO(solicitudBd);
    }
    
    public void concluirSubasta(Long id){
        Negocio negocio = negocioRepository.findById(id).orElse(null);
        solicitudRepository.deleteAllByNegocio(negocio);
    }
}
