package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Inversionista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inversionista;
    
    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "inversionista", targetEntity = Solicitud.class)
    private List<Solicitud> solicitudes;
    
    @OneToMany(mappedBy = "inversionista", targetEntity = Inversion.class)
    private List<Inversion> inversiones;
    
}
