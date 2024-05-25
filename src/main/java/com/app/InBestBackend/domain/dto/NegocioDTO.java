package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Solicitud;
import lombok.Data;

import java.util.List;

@Data
public class NegocioDTO {
    private Long id_negocio;
    private boolean aprobado;
    private boolean finalizado;
    private String titulo;
    private String descripcion;
    private String lugar;
    private String tipo_negocio;
    private Emprendedor emprendedor;
    private List<Solicitud> solicitudes;
}
