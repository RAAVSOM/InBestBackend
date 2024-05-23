package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Negocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_negocio;
    private boolean aprobado;

    //realizar control de sobrecarga vaciando las clases del emprendedor
    @ManyToOne
    @JoinColumn(name="fk_emprendedor")
    private Emprendedor emprendedor;

    // realizar control de sobrecarga vaciando el negocio, y al inversionista
    @OneToMany(mappedBy = "negocio", targetEntity = Solicitud.class)
    private List<Solicitud> solicitudes;
    
}
