package com.app.InBestBackend.persistence.repository;

import com.app.InBestBackend.persistence.entity.Emprendedor;
import com.app.InBestBackend.persistence.entity.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NegocioRepository extends JpaRepository<Negocio, Long>{
    public List<Negocio> findAllByAprobadoAndFinalizado(boolean aprobado,boolean finalizado);
    public List<Negocio> findAllByAprobado(boolean aprobado);
    public List<Negocio> findAllByAprobadoAndCorreccion(boolean aprobado, boolean correccion);
    public List<Negocio> findAllByEmprendedor(Emprendedor emprendedor);
    public List<Negocio> findAllByAprobadoTrueAndFinalizadoFalseAndTituloContainingIgnoreCaseOrAprobadoTrueAndFinalizadoFalseAndDescripcionContainingIgnoreCase(String titulo, String descripcion);
}
