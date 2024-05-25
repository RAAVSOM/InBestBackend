package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.EmprendedorDTO;
import com.app.InBestBackend.domain.mapper.EmprendedorMapper;
import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.entity.Usuario;
import com.app.InBestBackend.persistence.repository.EmprendedorRepository;
import com.app.InBestBackend.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmprendedorService {
    
    @Autowired
    private EmprendedorRepository emprendedorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public EmprendedorDTO save(EmprendedorDTO emprendedorDTO){
        emprendedorRepository.save(EmprendedorMapper.toEntinty(emprendedorDTO));
        return emprendedorDTO;
    }
    
    public EmprendedorDTO buscarEmprendedor(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        Emprendedor emprendedorBd = emprendedorRepository.findByUsuario(usuario);

        emprendedorBd.getNegocios().clear();
        emprendedorBd.getInversiones().clear();

        return EmprendedorMapper.toDTO(emprendedorBd);
    }


}
