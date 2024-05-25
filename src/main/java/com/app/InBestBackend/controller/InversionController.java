package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.InversionDTO;
import com.app.InBestBackend.domain.mapper.InversionMapper;
import com.app.InBestBackend.domain.service.InversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/inversion")
public class InversionController {
    @Autowired
    private InversionService inversionService;

    @PostMapping("/aceptarSolicitud/{id_N}/{id_I}/{id_E}/{id_S}")
    public void aceptarSolicitud(@PathVariable Long id_N, @PathVariable Long id_I, @PathVariable Long id_E, @PathVariable Long id_S){
        inversionService.aceptarSolicitud(id_N, id_I, id_E, id_S);
    }

    @GetMapping("/all/{id}")
    public List<InversionDTO> getInversiones(@PathVariable Long id){
        return inversionService.getInversiones(id);
    }

    @GetMapping("/{id}")
    public InversionDTO burcarInversion(@PathVariable Long id){
        return inversionService.buscarInversion(id);
    }
}
