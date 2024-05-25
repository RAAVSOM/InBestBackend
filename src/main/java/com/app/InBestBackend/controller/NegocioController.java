package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.NegocioDTO;
import com.app.InBestBackend.domain.service.EmprendedorService;
import com.app.InBestBackend.domain.service.NegocioService;
import com.app.InBestBackend.persistence.entity.Emprendedor;
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
    private EmprendedorService emprendedorService;
    
    /*@Autowired
    private DropboxService dropboxService;
    
    //--------------funcion subida y descarga de archivos-------------
    @PostMapping("/{idNegocio}/subir-archivo/{nombreArchivo}")
    public ResponseEntity<String> subirArchivo(@PathVariable Long idNegocio, @RequestParam("file") MultipartFile file, @PathVariable String nombreArchivo) {
        try {
            dropboxService.uploadFile(file, idNegocio, nombreArchivo);
            return ResponseEntity.ok("Archivo subido con éxito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @PostMapping("/{idNegocio}/descargar-archivo/{nombreArchivo}")
    public ResponseEntity<String> descargarArchivo(@PathVariable Long idNegocio, @PathVariable String nombreArchivo){
        try {
            FileMetadata file = dropboxService.downloadAllFilesInFolder(idNegocio, nombreArchivo);
            return ResponseEntity.ok(file.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }*/
    
    //-------------funciones administrador-------------
    @GetMapping("/sinaprobar")
    public List<NegocioDTO> cargarNegociosSinAprobar(){
        return negocioService.cargarNegociosSinAprobar();
    }
    
    @PutMapping("/aceptarNegocio/{id}")
    public String aceptarNegocio(@PathVariable Long id){
        return negocioService.aceptarNegocio(id);
    }
    
    @DeleteMapping("/rechazarNegocio/{id}")
    public String rechazarNegocio(@PathVariable Long id){
        return negocioService.rechazarNegocio(id);
    }
    
    //-------------funciones emprendedor---------------
    @PostMapping("/negocioAgregar/{id}")
    public String agregarNegocio(@RequestBody NegocioDTO negocioDTO, @PathVariable Long id){
        negocioService.agregarNegocio(negocioDTO, id);
        return "exito";
    }
    
    @GetMapping("/cargarnegocios/{id}")
    public List<NegocioDTO> cargarNegociosE(@PathVariable Long id){
        return negocioService.cargarNegociosEmprendedor(id);
    }
    
    @PutMapping("/actualizarNegocio/{id}")
    public String actualizarNegocio(@PathVariable Long id, @RequestBody NegocioDTO negocioDTO){
        return negocioService.actualizarNegocio(id, negocioDTO);
    }
    
    @DeleteMapping("eliminarNegocio/{id}")
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
    
    
    //-----------funciones inversionista-----------
    
    @GetMapping
    public List<NegocioDTO> cargarNegocios(){
        return negocioService.cargarNegocios();
    }
    
    @GetMapping("vernegocioi/{id}")
    public NegocioDTO verNegocioI(@PathVariable Long id){
        return negocioService.verNegocioDesdeI(id);
    }
    
    //-------------funciones filtro---(PROXIMAMENTE)-------------
}
