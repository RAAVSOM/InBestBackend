package com.app.InBestBackend.persistence.repository;

import com.app.InBestBackend.persistence.entity.Negocio;
import com.app.InBestBackend.persistence.entity.Notificacion;
import com.app.InBestBackend.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    public List<Notificacion> findAllByUsuario(Usuario usuario);
}
