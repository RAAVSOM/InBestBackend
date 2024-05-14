package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.NegocioDTO;
import com.app.InBestBackend.persistence.entity.Negocio;

public class NegocioMapper {
    public static Negocio toEntinty(NegocioDTO negocioDTO){
        Negocio negocio = new Negocio();
        negocio.setSolicitudes(negocioDTO.getSolicitudes());
        negocio.setEmprendedor(negocioDTO.getEmprendedor());
        negocio.setAprobado(negocioDTO.isAprobado());
        return negocio;
    }

    public static NegocioDTO toDTO(Negocio negocio){
        NegocioDTO negocioDTO = new NegocioDTO();
        negocioDTO.setSolicitudes(negocio.getSolicitudes());
        negocioDTO.setEmprendedor(negocio.getEmprendedor());
        negocioDTO.setAprobado(negocio.isAprobado());
        return negocioDTO;
    }
}
