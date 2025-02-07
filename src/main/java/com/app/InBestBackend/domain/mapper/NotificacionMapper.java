package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.InversionDTO;
import com.app.InBestBackend.domain.dto.NotificacionDTO;
import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.entity.Notificacion;

public class NotificacionMapper {
    public static Notificacion toEntinty(NotificacionDTO notificacionDTO){
        Notificacion notificacion = new Notificacion();
        notificacion.setId_notificacion(notificacionDTO.getId_notificacion());
        notificacion.setTitulo(notificacionDTO.getTitulo());
        notificacion.setUsuario(notificacionDTO.getUsuario());
        notificacion.setId_notificacion(notificacionDTO.getId_notificacion());
        return notificacion;
    }

    public static NotificacionDTO toDTO(Notificacion notificacion){
        NotificacionDTO notificacionDTO = new NotificacionDTO();
        notificacionDTO.setId_notificacion(notificacion.getId_notificacion());
        notificacionDTO.setTitulo(notificacion.getTitulo());
        notificacionDTO.setUsuario(notificacion.getUsuario());
        notificacionDTO.setId_notificacion(notificacion.getId_notificacion());
        return notificacionDTO;
    }
}
