package com.app.InBestBackend.persistence.repository;

import com.app.InBestBackend.persistence.entity.Inversionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionistaRepository extends JpaRepository<Inversionista, Long>{
    
}
