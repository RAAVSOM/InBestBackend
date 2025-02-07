package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.NegocioDTO;
import com.app.InBestBackend.domain.service.EmprendedorService;
import com.app.InBestBackend.domain.service.InversionService;
import com.app.InBestBackend.domain.service.NegocioService;
import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.repository.InversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/negocio")
public class NegocioController {
    
    @Autowired
    private NegocioService negocioService;
    @Autowired
    private InversionRepository inversionRepository;
    @Autowired
    private InversionService inversionService;

    //-------------funciones administrador-------------
    @GetMapping("/sinaprobar")
    public List<NegocioDTO> cargarNegociosSinAprobar(){
        return negocioService.cargarNegociosSinAprobar();
    }
    @GetMapping("/sincorregir")
    public List<NegocioDTO> cargarNegociosSinCorregir(){
        return negocioService.cargarNegociosEnCorreccion();
    }
    
    @PutMapping("/aceptarNegocio/{id}")
    public String aceptarNegocio(@PathVariable Long id){
        return negocioService.aceptarNegocio(id);
    }

    @PutMapping("/corregirNegocio/{id}")
    public void corregirNegocio(@PathVariable Long id, @RequestBody NegocioDTO negocioDTO){
        negocioService.corregirNegocio(id ,negocioDTO);
    }
    
    @DeleteMapping("/rechazarNegocio/{id}")
    public String rechazarNegocio(@PathVariable Long id){
        return negocioService.rechazarNegocio(id);
    }
    
    //-------------funciones emprendedor---------------
    @PostMapping("/negocioAgregar/{id}")
    public Long agregarNegocio(@RequestBody NegocioDTO negocioDTO, @PathVariable Long id){
        return negocioService.agregarNegocio(negocioDTO, id);
    }
    
    @GetMapping("/cargarnegocios/{id}")
    public List<NegocioDTO> cargarNegociosE(@PathVariable Long id){
        return negocioService.cargarNegociosEmprendedor(id);
    }
    
    @PutMapping("/actualizarNegocio/{id}")
    public void actualizarNegocio_Url(@PathVariable Long id, @RequestBody NegocioDTO negocioDTO){
        negocioService.actualizarNegocio_Url(id, negocioDTO);
    }

    @PutMapping("/actualizarNegocioGeneral/{id}")
    public void actualizarNegocio(@PathVariable Long id, @RequestBody NegocioDTO negocioDTO){
        negocioService.actualizarNegocio(id, negocioDTO);
    }
    
    @DeleteMapping("/eliminarNegocio/{id}")
    public String eliminarNegocio(@PathVariable Long id){
        return negocioService.eliminarNegocio(id);
    }
    
    @GetMapping("/vernegocioe/{id}")
    public NegocioDTO verNegocioE(@PathVariable Long id){
        return negocioService.verNegocioDesdeE(id);
    }

    @PutMapping("/cerrar/{id}")
    public String cerrarSubasta(@PathVariable Long id){
        return negocioService.cerrarSubasta(id);
    }

    @PutMapping("/agregarMontos/{id}")
    public void agregarMontos(@PathVariable Long id, @RequestBody NegocioDTO negocioDTO){
        negocioService.agregar_montos(id, negocioDTO);
    }
    //-----------funciones inversionista-----------
    
    @GetMapping
    public List<NegocioDTO> cargarNegocios(){
        return negocioService.cargarNegocios();
    }
    
    @GetMapping("vernegocioi/{id}")
    public NegocioDTO verNegocioI(@PathVariable Long id){
        return negocioService.verNegocioDesdeI(id);
    }

    @GetMapping("/{id}")
    public List<NegocioDTO> cargarInversiones(@PathVariable Long id){
        return inversionService.cargarInversiones(id);
    }


    //-------------funciones filtro---(PROXIMAMENTE)-------------
    @GetMapping("/buscar")
    public List<NegocioDTO> busqueda(@RequestParam String info){
        return negocioService.searchNegocios(info);
    }
}
