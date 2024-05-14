package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    private String nombre_persona;
    private String apellido_persona;
    private String ciudad;
    private int telefono;
    
    @OneToOne
    @JoinColumn(name="id_tipodocumento")
    private TipoDocumento tipoDocumento; 
}
