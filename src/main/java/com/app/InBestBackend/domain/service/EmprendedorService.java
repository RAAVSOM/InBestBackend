package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.EmprendedorDTO;
import com.app.InBestBackend.domain.mapper.EmprendedorMapper;
import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.repository.EmprendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmprendedorService {
    
    @Autowired
    private EmprendedorRepository emprendedorRepository;
    
    public EmprendedorDTO save(EmprendedorDTO emprendedorDTO){
        emprendedorRepository.save(EmprendedorMapper.toEntinty(emprendedorDTO));
        return emprendedorDTO;
    }
    
    public EmprendedorDTO buscarEmprendedor(Long id){
        Emprendedor emprendedorBd = emprendedorRepository.findById(id).orElse(null);
        List<Inversion> inversiones = new ArrayList<>();
        for(Inversion inversion : emprendedorBd.getInversiones()){

            inversion.getInversionista().getSolicitudes().clear();
            inversion.getInversionista().getInversiones().clear();

            inversion.getSolicitud().setInversionista(null);
            inversion.getSolicitud().setNegocio(null);

            inversion.getNegocio().setEmprendedor(null);
            inversion.getNegocio().getSolicitudes().clear();

            inversion.setEmprendedor(null);

            inversiones.add(inversion);
        }

        emprendedorBd.setInversiones(inversiones);

        return EmprendedorMapper.toDTO(emprendedorBd);
    }


}
