package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.EmprendedorDTO;
import com.app.InBestBackend.persistence.entity.Emprendedor;

public class EmprendedorMapper {
    public static Emprendedor toEntinty(EmprendedorDTO emprendedorDTO){
        Emprendedor emprendedor = new Emprendedor();
        emprendedor.setUsuario(emprendedorDTO.getUsuario());
        emprendedor.setNegocios(emprendedorDTO.getNegocios());
        return emprendedor;
    }

    public static EmprendedorDTO toDTO(Emprendedor emprendedor){
        EmprendedorDTO emprendedorDTO = new EmprendedorDTO();
        emprendedorDTO.setUsuario(emprendedor.getUsuario());
        emprendedorDTO.setNegocios(emprendedor.getNegocios());
        return emprendedorDTO;
    }
}
