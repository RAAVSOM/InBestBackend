package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String usuario;
    private String clave;
    private String correo;
    private String tipo_usuario;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_persona")
    private Persona persona;

    @OneToMany(mappedBy = "usuario", targetEntity = Notificacion.class)
    private List<Notificacion> notificaciones;
    
}
