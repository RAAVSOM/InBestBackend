package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.InversionistaDTO;
import com.app.InBestBackend.domain.service.InversionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InversionistaController {
    
    @Autowired
    private InversionistaService inversionistaService;
    
    @PostMapping("/registerInversionista")
    public String registerInversionista(@RequestBody InversionistaDTO inversionistaDTO){
        inversionistaService.save(inversionistaDTO);
        return "exito";
    }
}
