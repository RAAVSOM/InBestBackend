package com.app.InBestBackend.persistence.repository;

import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionistaRepository extends JpaRepository<Inversionista, Long>{
    public Inversionista findByUsuario(Usuario usuario);
}
