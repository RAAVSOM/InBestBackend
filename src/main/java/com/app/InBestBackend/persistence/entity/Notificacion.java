package com.app.InBestBackend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_notificacion;
    private String titulo;
    private String notificacion;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;
}