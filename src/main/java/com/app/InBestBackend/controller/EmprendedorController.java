package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.EmprendedorDTO;
import com.app.InBestBackend.domain.service.EmprendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmprendedorController {
    
    @Autowired
    private EmprendedorService emprendedorService;
    
    @PostMapping("/registerEmprendedor")
    public String registerEmprendedor(@RequestBody EmprendedorDTO emprendedorDTO){
        emprendedorService.save(emprendedorDTO);
        return "exito";
    }
}
