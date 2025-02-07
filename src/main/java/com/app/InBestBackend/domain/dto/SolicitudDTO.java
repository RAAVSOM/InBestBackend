package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.entity.Negocio;
import lombok.Data;

@Data
public class SolicitudDTO {
    private Long id_solicitud;
    private int valor_solicitud;
    private float porcentaje_rentabilidad;
    private float porcentaje_liquidez;
    private float nivel_riezgotolerado;
    private boolean aceptada;
    private Inversionista inversionista;
    private Negocio negocio;
}
