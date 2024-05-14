package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.EmprendedorDTO;
import com.app.InBestBackend.domain.mapper.EmprendedorMapper;
import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.repository.EmprendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprendedorService {
    
    @Autowired
    private EmprendedorRepository emprendedorRepository;
    
    public EmprendedorDTO save(EmprendedorDTO emprendedorDTO){
        emprendedorRepository.save(EmprendedorMapper.toEntinty(emprendedorDTO));
        return emprendedorDTO;
    }
    
    public Emprendedor buscarEmprendedor(Long id){
        return emprendedorRepository.findById(id).orElse(null);
    }
}
