package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.NegocioDTO;
import com.app.InBestBackend.domain.mapper.NegocioMapper;
import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Negocio;
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
    public List<NegocioDTO> cargarNegociosSinAprobar(boolean aprobado){
        return negocioRepository.findAllByAprobado(aprobado).stream().map(NegocioMapper::toDTO).collect(Collectors.toList());
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
    public void agregarNegocio(NegocioDTO negocioDTO){
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
        NegocioDTO negocioDTOfromDB = NegocioMapper.toDTO(negocioRepository.findById(id).orElse(null));
        if(negocioDTOfromDB != null){
            negocioDTOfromDB.setAprobado(negocioDTO.isAprobado());
            negocioDTOfromDB.setEmprendedor(negocioDTO.getEmprendedor());
            negocioDTOfromDB.setSolicitudes(negocioDTO.getSolicitudes());
            negocioRepository.save(NegocioMapper.toEntinty(negocioDTOfromDB));
            return "actualizado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public String eliminarNegocio(Long id){
        NegocioDTO negocioDTO = NegocioMapper.toDTO(negocioRepository.findById(id).orElse(null));
        if(negocioDTO != null){
            negocioRepository.delete(NegocioMapper.toEntinty(negocioDTO));
            return "eliminado satisfactoriamente";
        }else{
            return "no se encontro negocio";
        }
    }
    
    public NegocioDTO verNegocioDesdeE(Long id){
        return NegocioMapper.toDTO(negocioRepository.findById(id).orElse(null));  
    }
    
    
    //-----------funciones inversionista-----------
    
    public List<NegocioDTO> cargarNegocios(){
        return negocioRepository.findAll().stream().map(NegocioMapper::toDTO).collect(Collectors.toList());
    }
    
    public NegocioDTO verNegocioDesdeI(Long id){
        return NegocioMapper.toDTO(negocioRepository.findById(id).orElse(null));  
    }
    
    public Negocio buscarNegocio(Long id){
        return negocioRepository.findById(id).orElse(null);
    }
    
    //-------------funciones filtro---(PROXIMAMENTE)-------------

}
