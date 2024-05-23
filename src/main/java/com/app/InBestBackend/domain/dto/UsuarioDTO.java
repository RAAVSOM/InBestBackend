package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Persona;
import lombok.Data;


@Data
public class UsuarioDTO {

    private Long id_usuario;
    private String usuario;
    private String clave;
    private String correo;
    private Persona persona;
    private String tipo_usuario;

}
