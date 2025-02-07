package com.app.InBestBackend.domain.service;

import com.app.InBestBackend.domain.dto.NotificacionDTO;
import com.app.InBestBackend.domain.mapper.NegocioMapper;
import com.app.InBestBackend.domain.mapper.NotificacionMapper;
import com.app.InBestBackend.persistence.entity.Notificacion;
import com.app.InBestBackend.persistence.entity.Usuario;
import com.app.InBestBackend.persistence.repository.NotificacionRepository;
import com.app.InBestBackend.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService {
    @Autowired
    NotificacionRepository notificacionRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<NotificacionDTO> cargarNotificaciones(Long id_Usuario){
        Usuario usuarioBd = usuarioRepository.findById(id_Usuario).orElse(null);
        return notificacionRepository.findAllByUsuario(usuarioBd).stream().map(NotificacionMapper::toDTO).collect(Collectors.toList());
    }


    public void crearNotificacion(String titulo, String notificacion_msj, Long id_Usuario) {
        Usuario usuarioBd = usuarioRepository.findById(id_Usuario).orElse(null);
        Notificacion notificacion = new Notificacion();
        notificacion.setNotificacion(notificacion_msj);
        notificacion.setTitulo(titulo);
        notificacion.setUsuario(usuarioBd);
        notificacionRepository.save(notificacion);
    }
}
