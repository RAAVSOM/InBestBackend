package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.EmprendedorDTO;
import com.app.InBestBackend.persistence.entity.Emprendedor;

public class EmprendedorMapper {
    public static Emprendedor toEntinty(EmprendedorDTO emprendedorDTO){
        Emprendedor emprendedor = new Emprendedor();
        emprendedor.setInversiones(emprendedorDTO.getInversiones());
        emprendedor.setUsuario(emprendedorDTO.getUsuario());
        emprendedor.setNegocios(emprendedorDTO.getNegocios());
        emprendedor.setId_emprendedor(emprendedorDTO.getId_emprendedor());
        return emprendedor;
    }

    public static EmprendedorDTO toDTO(Emprendedor emprendedor){
        EmprendedorDTO emprendedorDTO = new EmprendedorDTO();
        emprendedorDTO.setInversiones(emprendedor.getInversiones());
        emprendedorDTO.setUsuario(emprendedor.getUsuario());
        emprendedorDTO.setNegocios(emprendedor.getNegocios());
        emprendedorDTO.setId_emprendedor(emprendedor.getId_emprendedor());
        return emprendedorDTO;
    }
}
