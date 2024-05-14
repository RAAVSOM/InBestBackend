package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    
    @Column(name = "usuario", unique = true)
    private String usuario;
    private String clave;
    private String correo;
    private String tipo_usuario;
    
    @OneToOne
    @JoinColumn(name="id_persona")
    private Persona persona;
    
}
