package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Inversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inversion;
    
    @ManyToOne
    @JoinColumn(name="fk_inversionista")
    private Inversionista inversionista;
    
    @OneToOne
    @JoinColumn(name="id_solicitud")
    private Solicitud solicitud;
    
    @OneToOne
    @JoinColumn(name="id_negocio")
    private Negocio negocio;
    
    @ManyToOne
    @JoinColumn(name="fk_emprendedor")
    private Emprendedor emprendedor;
}
