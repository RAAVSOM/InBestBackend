package com.app.InBestBackend.domain.mapper;

import com.app.InBestBackend.domain.dto.NegocioDTO;
import com.app.InBestBackend.persistence.entity.Negocio;

public class NegocioMapper {
    public static Negocio toEntinty(NegocioDTO negocioDTO){
        Negocio negocio = new Negocio();
        negocio.setInversiones(negocioDTO.getInversiones());
        negocio.setMonto_solicitado(negocioDTO.getMonto_solicitado());
        negocio.setPorcentaje_ofrecido(negocioDTO.getPorcentaje_ofrecido());
        negocio.setSubasta(negocioDTO.isSubasta());
        negocio.setMensaje_correccion(negocioDTO.getMensaje_correccion());
        negocio.setCorreccion(negocioDTO.isCorreccion());
        negocio.setRut(negocioDTO.getRut());
        negocio.setPlan(negocioDTO.getPlan());
        negocio.setVideo(negocioDTO.getVideo());
        negocio.setLogo(negocioDTO.getLogo());
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
        negocioDTO.setInversiones(negocio.getInversiones());
        negocioDTO.setMonto_solicitado(negocio.getMonto_solicitado());
        negocioDTO.setPorcentaje_ofrecido(negocio.getPorcentaje_ofrecido());
        negocioDTO.setSubasta(negocio.isSubasta());
        negocioDTO.setMensaje_correccion(negocio.getMensaje_correccion());
        negocioDTO.setCorreccion(negocio.isCorreccion());
        negocioDTO.setRut(negocio.getRut());
        negocioDTO.setPlan(negocio.getPlan());
        negocioDTO.setVideo(negocio.getVideo());
        negocioDTO.setLogo(negocio.getLogo());
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
