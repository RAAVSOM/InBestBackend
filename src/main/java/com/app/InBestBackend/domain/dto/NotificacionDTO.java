package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Usuario;
import lombok.Data;

@Data
public class NotificacionDTO {
    private Long id_notificacion;
    private String titulo;
    private String notificacion;
    private Usuario usuario;
}
