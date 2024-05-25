package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.EmprendedorDTO;
import com.app.InBestBackend.domain.service.EmprendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/emprendedor")
public class EmprendedorController {
    
    @Autowired
    private EmprendedorService emprendedorService;
    
    @PostMapping("/registrarEmprendedor")
    public String registerEmprendedor(@RequestBody EmprendedorDTO emprendedorDTO){
        emprendedorService.save(emprendedorDTO);
        return "exito";
    }

    @GetMapping("/{id}")
    public EmprendedorDTO buscarEmprendedor(@PathVariable Long id){
        return emprendedorService.buscarEmprendedor(id);
    }
}
