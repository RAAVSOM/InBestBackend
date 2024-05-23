package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.InversionistaDTO;
import com.app.InBestBackend.domain.service.InversionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inversionista")
public class InversionistaController {
    
    @Autowired
    private InversionistaService inversionistaService;
    
    @PostMapping("registerInversionista")
    public String registerInversionista(@RequestBody InversionistaDTO inversionistaDTO){
        inversionistaService.save(inversionistaDTO);
        return "exito";
    }

    @GetMapping("/{id}")
    public InversionistaDTO buscarInversionista(@PathVariable Long id){
        return  inversionistaService.buscarInversionista(id);
    }
}
