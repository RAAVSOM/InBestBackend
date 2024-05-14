package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Persona;
import lombok.Data;


@Data
public class UsuarioDTO {
    
    private String usuario;
    private String clave;
    private String correo;
    private Persona persona;
    private String tipo_usuario;

    public UsuarioDTO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public UsuarioDTO() {
    }
    
    
}
