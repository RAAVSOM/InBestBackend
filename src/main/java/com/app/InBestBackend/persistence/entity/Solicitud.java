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
    private boolean aceptada;

    //realizar control de sobrecarga vaciando las listas
    @ManyToOne
    @JoinColumn(name="fk_inversionista")
    private Inversionista inversionista;

    //realizar control de sobrecarga vaciando las solicitudes y al emprendedor
    @ManyToOne
    @JoinColumn(name="fk_negocio")
    private Negocio negocio;
}
