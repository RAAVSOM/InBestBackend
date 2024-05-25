package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.NegocioDTO;
import com.app.InBestBackend.domain.mapper.NegocioMapper;
import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Negocio;
import com.app.InBestBackend.persistence.entity.Solicitud;
import com.app.InBestBackend.persistence.repository.EmprendedorRepository;
import com.app.InBestBackend.persistence.repository.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NegocioService {
    @Autowired
    private NegocioRepository negocioRepository;
    @Autowired
    private EmprendedorRepository emprendedorRepository;
    
    //----------funciones administrador-----------
    public List<NegocioDTO> cargarNegociosSinAprobar(){
        List<Negocio> negociosBd = negocioRepository.findAllByAprobado(false);
        List<NegocioDTO> negocios = new ArrayList<>();
        for(Negocio negocio : negociosBd){
            negocio.getEmprendedor().getNegocios().clear();
            negocio.getEmprendedor().getInversiones().clear();
            negocio.getSolicitudes().clear();

            negocios.add(NegocioMapper.toDTO(negocio));
        }

        return negocios;
    }
    
    public String rechazarNegocio(Long id){
        NegocioDTO negocioDTO = NegocioMapper.toDTO(negocioRepository.findById(id).orElse(null));
        if(negocioDTO != null){
            negocioRepository.delete(NegocioMapper.toEntinty(negocioDTO));
            return "rechazado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public String aceptarNegocio(Long id){
        NegocioDTO negocioDTO = NegocioMapper.toDTO(negocioRepository.findById(id).orElse(null));
        if(negocioDTO != null){
            negocioDTO.setAprobado(true);
            negocioRepository.save(NegocioMapper.toEntinty(negocioDTO));
            return "actualizado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    
    //---------------funciones emprendedor-------------
    public void agregarNegocio(NegocioDTO negocioDTO, Long id){
        Emprendedor emprendedor = emprendedorRepository.findById(id).orElse(null);
        negocioDTO.setEmprendedor(emprendedor);
        negocioRepository.save(NegocioMapper.toEntinty(negocioDTO));
    }
    
    public List<NegocioDTO> cargarNegociosEmprendedor(Long id){
        Emprendedor emprendedor = emprendedorRepository.findById(id).orElse(null);
        List<NegocioDTO> negociosBd = negocioRepository.findAllByEmprendedor(emprendedor).stream().map(NegocioMapper::toDTO).collect(Collectors.toList());

        List<NegocioDTO> negocios = new ArrayList<>();
        for(NegocioDTO negocio: negociosBd){
            negocio.setEmprendedor(null);
            negocio.getSolicitudes().clear();
            negocios.add(negocio);
        }

        return negocios;
    }
    
    public String actualizarNegocio(Long id, NegocioDTO negocioDTO){
        Negocio negocioBd = negocioRepository.findById(id).orElse(null);
        if(negocioBd != null){
            negocioBd.setAprobado(negocioDTO.isAprobado());
            negocioRepository.save(negocioBd);
            return "actualizado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public String eliminarNegocio(Long id){
        Negocio negocio = negocioRepository.findById(id).orElse(null);
        if(negocio != null){
            negocioRepository.delete(negocio);
            return "eliminado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public NegocioDTO verNegocioDesdeE(Long id){
        Negocio negocioBd = negocioRepository.findById(id).orElse(null);
        negocioBd.setEmprendedor(null);
        List<Solicitud> solicitudes = new ArrayList<>();
        for (Solicitud solicitud : negocioBd.getSolicitudes()){
            solicitud.getInversionista().getInversiones().clear();
            solicitud.getInversionista().getSolicitudes().clear();
            solicitud.setNegocio(null);
            solicitudes.add(solicitud);
        }
        negocioBd.setSolicitudes(solicitudes);
        return NegocioMapper.toDTO(negocioBd);
    }

    public String cerrarSubasta(Long id){
        Negocio negocio = negocioRepository.findById(id).orElse(null);
        negocio.setFinalizado(true);
        negocio.getSolicitudes().clear();
        negocioRepository.save(negocio);
        return "exito";
    }
    
    
    //-----------funciones inversionista-----------
    
    public List<NegocioDTO> cargarNegocios(){
        List<Negocio> negociosBd = negocioRepository.findAllByAprobadoAndFinalizado(true, false);
        List<NegocioDTO> negocios = new ArrayList<>();
        for(Negocio negocio: negociosBd){
            negocio.getEmprendedor().getNegocios().clear();
            negocio.getEmprendedor().getInversiones().clear();
            negocio.getSolicitudes().clear();
            negocios.add(NegocioMapper.toDTO(negocio));
        }
        return negocios;
    }
    
    public NegocioDTO verNegocioDesdeI(Long id){
        Negocio negocioBd = negocioRepository.findById(id).orElse(null);
        negocioBd.setEmprendedor(null);
        negocioBd.getSolicitudes().clear();
        return NegocioMapper.toDTO(negocioBd);
    }
    
    public Negocio buscarNegocio(Long id){
        return negocioRepository.findById(id).orElse(null);
    }
    
    //-------------funciones filtro---(PROXIMAMENTE)-------------

}
