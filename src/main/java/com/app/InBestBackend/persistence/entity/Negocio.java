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
    private boolean finalizado;
    private String titulo;
    private String descripcion;
    private String lugar;
    private String tipo_negocio;

    //realizar control de sobrecarga vaciando las clases del emprendedor
    @ManyToOne
    @JoinColumn(name="fk_emprendedor")
    private Emprendedor emprendedor;

    // realizar control de sobrecarga vaciando el negocio, y al inversionista
    @OneToMany(mappedBy = "negocio", targetEntity = Solicitud.class)
    private List<Solicitud> solicitudes;
    
}
