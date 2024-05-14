package com.app.InBestBackend.persistence.repository;

import com.app.InBestBackend.persistence.entity.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionRepository extends JpaRepository<Inversion, Long>{
    
}
