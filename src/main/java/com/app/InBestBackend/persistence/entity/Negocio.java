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
    private boolean correccion;
    private boolean subasta;
    private boolean finalizado;
    private String titulo;
    private String descripcion;
    private String lugar;
    private String tipo_negocio;
    private String logo;
    private String video;
    private String plan;
    private String rut;
    private Long monto_solicitado;
    private Long porcentaje_ofrecido;
    private String mensaje_correccion;

    //realizar control de sobrecarga vaciando las clases del emprendedor
    @ManyToOne
    @JoinColumn(name="fk_emprendedor")
    private Emprendedor emprendedor;

    // realizar control de sobrecarga vaciando el negocio, y al inversionista
    @OneToMany(mappedBy = "negocio", targetEntity = Solicitud.class)
    private List<Solicitud> solicitudes;

    @OneToMany(mappedBy = "negocio", targetEntity = Inversion.class)
    private List<Inversion> inversiones;
    
}
