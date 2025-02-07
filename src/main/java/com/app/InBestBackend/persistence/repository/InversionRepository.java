package com.app.InBestBackend.persistence.repository;

import com.app.InBestBackend.persistence.entity.Inversion;
import com.app.InBestBackend.persistence.entity.Inversionista;
import com.app.InBestBackend.persistence.entity.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InversionRepository extends JpaRepository<Inversion, Long>{
    public List<Inversion> findAllByNegocio(Negocio negocio);
    public List<Inversion> findAllByInversionista(Inversionista inversionista);
}
