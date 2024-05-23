package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.TipoDocumento;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PersonaDTO {
    private Long id_persona;
    private String nombre_persona;
    private String apellido_persona;
    private String ciudad;
    private int telefono;
    private TipoDocumento tipoDocumento;
}
