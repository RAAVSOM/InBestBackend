package com.app.InBestBackend.persistence.repository;

import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendedorRepository extends JpaRepository<Emprendedor, Long> {
    public Emprendedor findByUsuario(Usuario usuario);
}
