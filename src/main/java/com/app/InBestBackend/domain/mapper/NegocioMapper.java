package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.NegocioDTO;
import com.app.InBestBackend.persistence.entity.Negocio;

public class NegocioMapper {
    public static Negocio toEntinty(NegocioDTO negocioDTO){
        Negocio negocio = new Negocio();
        negocio.setSolicitudes(negocioDTO.getSolicitudes());
        negocio.setTitulo(negocioDTO.getTitulo());
        negocio.setDescripcion(negocioDTO.getDescripcion());
        negocio.setLugar(negocioDTO.getLugar());
        negocio.setTipo_negocio(negocioDTO.getTipo_negocio());
        negocio.setEmprendedor(negocioDTO.getEmprendedor());
        negocio.setAprobado(negocioDTO.isAprobado());
        negocio.setFinalizado(negocioDTO.isFinalizado());
        negocio.setId_negocio(negocioDTO.getId_negocio());
        return negocio;
    }

    public static NegocioDTO toDTO(Negocio negocio){
        NegocioDTO negocioDTO = new NegocioDTO();
        negocioDTO.setSolicitudes(negocio.getSolicitudes());
        negocioDTO.setTitulo(negocio.getTitulo());
        negocioDTO.setDescripcion(negocio.getDescripcion());
        negocioDTO.setLugar(negocio.getLugar());
        negocioDTO.setTipo_negocio(negocio.getTipo_negocio());
        negocioDTO.setEmprendedor(negocio.getEmprendedor());
        negocioDTO.setAprobado(negocio.isAprobado());
        negocioDTO.setFinalizado(negocio.isFinalizado());
        negocioDTO.setId_negocio(negocio.getId_negocio());
        return negocioDTO;
    }
}
