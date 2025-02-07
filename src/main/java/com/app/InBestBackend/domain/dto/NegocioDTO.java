package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.entity.Solicitud;
import lombok.Data;

import java.util.List;

@Data
public class NegocioDTO {
    private Long id_negocio;
    private boolean aprobado;
    private boolean correccion;
    private boolean subasta;
    private boolean finalizado;
    private String titulo;
    private String descripcion;
    private String lugar;
    private String tipo_negocio;
    private String logo;
    private String video;
    private String plan;
    private String rut;
    private String mensaje_correccion;
    private Long monto_solicitado;
    private Long porcentaje_ofrecido;
    private Emprendedor emprendedor;
    private List<Solicitud> solicitudes;
    private List<Inversion> inversiones;
}
