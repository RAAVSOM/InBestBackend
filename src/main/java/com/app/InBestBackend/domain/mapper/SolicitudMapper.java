package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.SolicitudDTO;
import com.app.InBestBackend.persistence.entity.Solicitud;

public class SolicitudMapper {
    public static Solicitud toEntinty(SolicitudDTO solicitudDTO){
        Solicitud solicitud = new Solicitud();
        solicitud.setInversionista(solicitudDTO.getInversionista());
        solicitud.setNivel_riezgotolerado(solicitudDTO.getNivel_riezgotolerado());
        solicitud.setPorcentaje_liquidez(solicitudDTO.getPorcentaje_liquidez());
        solicitud.setPorcentaje_rentabilidad(solicitudDTO.getPorcentaje_rentabilidad());
        solicitud.setValor_solicitud(solicitudDTO.getValor_solicitud());
        return solicitud;
    }

    public static SolicitudDTO toDTO(Solicitud solicitud){
        SolicitudDTO solicitudDTO = new SolicitudDTO();
        solicitudDTO.setInversionista(solicitud.getInversionista());
        solicitudDTO.setNivel_riezgotolerado(solicitud.getNivel_riezgotolerado());
        solicitudDTO.setPorcentaje_liquidez(solicitud.getPorcentaje_liquidez());
        solicitudDTO.setPorcentaje_rentabilidad(solicitud.getPorcentaje_rentabilidad());
        solicitudDTO.setValor_solicitud(solicitud.getValor_solicitud());
        return solicitudDTO;
    }
}
