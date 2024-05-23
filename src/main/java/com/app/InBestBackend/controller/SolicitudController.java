package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.SolicitudDTO;
import com.app.InBestBackend.domain.service.InversionistaService;
import com.app.InBestBackend.domain.service.NegocioService;
import com.app.InBestBackend.domain.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    
    //--------------funciones inversionista-------------
    @GetMapping("/cargarsolicitud/{id}/{id_negocio}")
    public List<SolicitudDTO> cargarSolicitudI(@PathVariable Long id, @PathVariable Long id_negocio){
        return solicitudService.cargarSolicitudes(id, id_negocio);
    }
    
    @PostMapping("/solicitudAgregar")
    public String agregarSolicitud(@RequestBody SolicitudDTO solicitudDTO){
        solicitudService.agregarSolicitud(solicitudDTO);
        return "exito";
    }
    
    @DeleteMapping("/eliminarsolicitud/{id}")
    public String eliminarSolicitud(@PathVariable Long id){
        return solicitudService.eliminarsolicitud(id);
    }
    
    @PutMapping("/actualizarsolicitud/{id}")
    public String actualizarSolicitud(@PathVariable Long id, @RequestBody SolicitudDTO solicitudDTO){
        return solicitudService.actualizarSolicitud(id, solicitudDTO);
    }
    
    @GetMapping("/versolicitudi/{id}")
    public SolicitudDTO verSolicitudI(@PathVariable Long id){
        return solicitudService.verSolicitudI(id);
    }
    
    //------------funciones emprendedor----------------
    @GetMapping("/cargarsolicitudn/{id}")
    public List<SolicitudDTO> cargarSolicitudE(@PathVariable Long id){
        return solicitudService.cargarSolicitudesNegocio(id);
    }
    
    @GetMapping("/versolicitude/{id}")
    public SolicitudDTO verSolicitudE(@PathVariable Long id){
        return solicitudService.verSolicitudE(id);
    }
    
    @DeleteMapping("/concluir/{id}")
    public void concluirSubasta(@PathVariable Long id){
        solicitudService.concluirSubasta(id);
    }
}
