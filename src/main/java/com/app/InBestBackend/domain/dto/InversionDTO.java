package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.entity.Negocio;
import com.app.InBestBackend.persistence.entity.Solicitud;
import lombok.Data;

@Data
public class InversionDTO {
    private Long id_inversion;
    private Inversionista inversionista;
    private Solicitud solicitud;
    private Negocio negocio;
    private Emprendedor emprendedor;
}
