package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.entity.Solicitud;
import com.app.InBestBackend.persistence.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class InversionistaDTO {
    private Long id_inversionista;
    private Usuario usuario;
    private List<Solicitud> solicitudes;
    private List<Inversion> inversiones;
}
