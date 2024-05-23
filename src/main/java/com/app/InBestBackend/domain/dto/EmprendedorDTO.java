package com.app.InBestBackend.domain.dto;

import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.entity.Negocio;
import com.app.InBestBackend.persistence.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class EmprendedorDTO {
    private Long id_emprendedor;
    private Usuario usuario;
    private List<Negocio> negocios;
    private List<Inversion> inversiones;
}
