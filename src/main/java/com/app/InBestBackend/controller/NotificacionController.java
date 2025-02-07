package com.app.InBestBackend.controller;

import com.app.InBestBackend.domain.dto.NotificacionDTO;
import com.app.InBestBackend.domain.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping("/{id}")
    public List<NotificacionDTO> getNotificacion(@PathVariable Long id) {
        return notificacionService.cargarNotificaciones(id);
    }
}
