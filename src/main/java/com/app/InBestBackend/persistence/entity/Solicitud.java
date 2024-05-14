package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solicitud;
    private int valor_solicitud;
    private float porcentaje_rentabilidad;
    private float porcentaje_liquidez;
    private float nivel_riezgotolerado;
    
    @ManyToOne
    @JoinColumn(name="fk_inversionista")
    private Inversionista inversionista;
    
    @ManyToOne
    @JoinColumn(name="fk_negocio")
    private Negocio negocio;
}
